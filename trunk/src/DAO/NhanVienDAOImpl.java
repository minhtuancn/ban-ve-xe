package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.ConnectionPool;
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import model.KhachHang;
import model.KhachHangThuongXuyen;
import model.NhanVien;
import model.TaiKhoan;

public class NhanVienDAOImpl implements NhanVienDAO{
	private TaiKhoanDAO taiKhoanDAO;

	
	public TaiKhoanDAO getTaiKhoanDao() {
		taiKhoanDAO = (TaiKhoanDAO) (taiKhoanDAO == null ? new FactoryDAOImp()
				.createDAO(FactoryDao.TAI_KHOAN_DAO) : taiKhoanDAO);
		return taiKhoanDAO;
	}
	
	
	@Override
	public NhanVien checkLoginAdmin(String name, String pass) {
		Connection con = ConnectionPool.getInstance().getConnection();
		PreparedStatement pre = null;
		String sql = "SELECT nhanvien.idnhanvien,nhanvien.tennhanvien,nhanvien.idtaikhoan FROM nhanvien INNER JOIN taikhoan ON nhanvien.idnhanvien = taikhoan.idtaikhoan WHERE tentk =? AND matkhau=?";
		String sqlQuyen = "Select quyen from quyen where idnhanvien = ?";
		ResultSet res;
		NhanVien nv = null;
		TaiKhoan tk = null;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, name);
			pre.setString(2, pass);
			res = pre.executeQuery();
			while (res.next()) {
				System.out.println("NhanVienDaoImpl:" + res.getLong("idtaikhoan"));
				tk = getTaiKhoanDao().getTaiKhoan(res.getLong("idtaikhoan"));
				nv = new NhanVien(res.getLong("idnhanvien"), res.getString("tennhanvien"), tk);
				pre.close();
				res.close();
				pre = con.prepareStatement(sqlQuyen);
				pre.setLong(1, nv.getIdNhanVien());
				res = pre.executeQuery();
				while(res.next()){
					nv.getQuyen().add(res.getString("quyen"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return nv;
	}
	

}
