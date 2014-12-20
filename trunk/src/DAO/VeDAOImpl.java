package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.ConnectionPool;
import model.DatVe;
import model.DiaDiem;
import model.ThongTinVe;
import model.Ve;

public class VeDAOImpl implements VeDAO{
	
	@Override
	public List<Ve> getVe(String maVe) {
		return null;
	}

	@Override
	public List<Ve> getAllVe(long idKhachHang) {
		 List<Ve> listVe = new ArrayList<>();
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "SELECT idve,dakhoihanh,ghichu,mave,ngaydatve,thoihanthanhtoan,trangthaithanhtoan,idchuyen,idkhachhang,lahuyve,lidohuy FROM ve";
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql);
			pre.setLong(1, idKhachHang);
			ResultSet res = pre.executeQuery();
			while (res.next()) {
			listVe.add(new Ve(res.getString("mave"), res.getString("ghichu"), res.getDate("ngaydatve"), null , res.getBoolean("dakhoihanh"), res.getBoolean("trangthaithanhtoan"), res.getDate("thoihanthanhtoan"), res.getBoolean("trangthaihuyve"), res.getString("lidohuyve")))	;			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
			return listVe;
	}

	@Override
	public List<Ve> searchVe(String maSearch) {
		 List<Ve> listVe = new ArrayList<>();
			Connection con = ConnectionPool.getInstance().getConnection();
			String sql = "SELECT idve,dakhoihanh,ghichu,mave,ngaydatve,thoihanthanhtoan,trangthaithanhtoan,idchuyen,idkhachhang,lahuyve,lidohuy FROM ve INNER JOIN khachhang ON ve.idkhachhang = khachhang.idkhachhang WHERE khachhang.sdt like ? OR khachhang.cmnd like ? OR khachhang.tenkhachhang like ? OR ve.mave like ? ";
			PreparedStatement pre = null;
			try {
				pre = con.prepareStatement(sql);
				pre.setString(1, "'%"+ maSearch+"%'");
				pre.setString(2, "'%"+ maSearch+"%'");
				pre.setString(3, "'%"+ maSearch+"%'");
				pre.setString(4, "'%"+ maSearch+"%'");
				ResultSet res = pre.executeQuery();
				while (res.next()) {
				listVe.add(new Ve(res.getString("mave"), res.getString("ghichu"), res.getDate("ngaydatve"), null , res.getBoolean("dakhoihanh"), res.getBoolean("trangthaithanhtoan"), res.getDate("thoihanthanhtoan"), res.getBoolean("trangthaihuyve"), res.getString("lidohuyve")))	;			
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectionPool.getInstance().closePre(pre);
				ConnectionPool.getInstance().freeConnection(con);
			}
				return listVe;
	}

}
