package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			pre.setString(1, tk.getMatKhau());
			pre.setBoolean(3, false);
			if (pre.executeUpdate() != 0) {
				pre.close();
				pre = con.prepareStatement(sql2);
				pre.setString(1, tk.getTenTK());
				pre.setString(2, tk.getMatKhau());
				res = pre.executeQuery();
				while(res.next()){
					id = res.getLong("idtuyen");
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

}
