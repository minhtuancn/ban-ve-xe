package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;

import util.LayMaVe;
import database.ConnectionPool;
import model.KhachHang;
import model.TaiKhoan;

public class TaiKhoanDAOImpl implements TaiKhoanDAO {

	@Override
	public long addTaiKhoan(TaiKhoan tk) {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "insert into taikhoan (tentk, matkhau, dakichhoat) value (?,?,?) ";
		String sql2 = "select idtaikhoan from taikhoan where tentk = ? and matkhau = ?";
		PreparedStatement pre = null;
		ResultSet res = null;
		long id = -1;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, tk.getTenTK());
			pre.setString(2, tk.getMatKhau());
			pre.setBoolean(3, false);
			if (pre.executeUpdate() != 0) {
				pre.close();
				pre = con.prepareStatement(sql2);
				pre.setString(1, tk.getTenTK());
				pre.setString(2, tk.getMatKhau());
				res = pre.executeQuery();
				while(res.next()){
					id = res.getLong("idtaikhoan");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return id;
	}

	@Override
	public boolean checkUser(String user) {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "select tentk from taikhoan where tentk =? ";
		PreparedStatement pre = null;
		ResultSet res = null;
		boolean kq = false;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, user);
			res = pre.executeQuery();
			if(res.next()){
				kq=  true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		
		return kq;
	}

	@Override
	public long upDateMatKhau(String tk, String pass) {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "update taikhoan set matkhau = ? where tentk = ?";
		PreparedStatement pre = null;
		long idtaikhoan = -1;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, pass);
			pre.setString(2, tk);
			if(pre.executeUpdate() > 0){
			idtaikhoan = 2;	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return idtaikhoan;
	}

	@Override
	public TaiKhoan getTaiKhoan(long idTk) {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "select * from taikhoan where idtaikhoan = ?";
		PreparedStatement pre = null;
		TaiKhoan tk = null;
		ResultSet res ;
		try {
			pre = con.prepareStatement(sql);
			pre.setLong(1, idTk);
			res = pre.executeQuery();
			if(res.next()){
				tk = new TaiKhoan(res.getString("tentk"), res.getString("matkhau"), res.getBoolean("dakichhoat"));
				tk.setIdTaiKhoan(idTk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return tk;
	}

	@Override
	public TaiKhoan layMatKhau(String tk) {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "select idtaikhoan from taikhoan where tentk = ?";
		String sql2 = "update taikhoan set matkhau = ? where idtaikhoan = ?";
		PreparedStatement pre = null;
		ResultSet res = null;
		TaiKhoan taiKhoan = null;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, tk);
			res = pre.executeQuery();
			if(res.next()){
				String newPass = LayMaVe.getInstant().getMaVe(6);
				System.out.println("TaiKhoanDAOImp new pass " + newPass);
				String passMD5 = DigestUtils.md5Hex(newPass);
				long idTaiKhoan = res.getLong("idtaikhoan");
				pre.close();
				pre = con.prepareStatement(sql2);
				pre.setString(1, passMD5);
				pre.setLong(2, idTaiKhoan);
				if( pre.executeUpdate() != 0 ){
					taiKhoan = getTaiKhoan(idTaiKhoan);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return taiKhoan;
	}

	@Override
	public boolean kichHoatTaiKhoan(long idTk) {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "update taikhoan set dakichhoat= ? where idtaikhoan = ?";
		PreparedStatement pre = null;
		boolean res =false;
		try {
			pre = con.prepareStatement(sql);
			pre.setBoolean(1, true);
			pre.setLong(2, idTk);
			int t = pre.executeUpdate();
			if(t>0)  res=true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return res;
	}
}
