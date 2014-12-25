package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.ConnectionPool;
import model.ChuyenKhoanATM;
import model.ChuyenKhoanWeb;
import model.ThanhToan;
import model.TraTienTrucTiep;

public class ThanhToanDAOIpml implements ThanhToanDAO{

	@Override
	public ThanhToan getThanhToan(long idve) {
		ThanhToan thanhToan= null;
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "SELECT idthanhtoan,sotien,ngaythanhtoan FROM thanhtoan WHERE idve=?";
		String sql1 = "SELECT idthanhtoan FROM chuyenkhoanweb WHERE idthanhtoan=?";
		String sql2 = "SELECT idthanhtoan,nhanvienthanhtoan,tennguoithanhtoan FROM tratientructiep WHERE idthanhtoan=?";
		String sql3 = "SELECT idthanhtoan,sotaikhoan,tennganhang,tennguoithanhtoan FROM chuyenkhoanatm WHERE idthanhtoan=?";
		PreparedStatement pre = null,pre1=null;
		ResultSet res, res1;
		try {
			pre = con.prepareStatement(sql);
			pre.setLong(1, idve);
			res = pre.executeQuery();
			while(res.next()){
				pre1= con.prepareStatement(sql1);
				pre1.setLong(1, res.getLong("idthanhtoan"));
				res1=pre1.executeQuery();
				while(res1.next()){
					thanhToan = new ChuyenKhoanWeb();
				}
				pre1.close();
				pre1 = con.prepareStatement(sql2);
				pre1.setLong(1, res.getLong("idthanhtoan"));
				res1=pre1.executeQuery();
				while(res1.next()){
					thanhToan = new TraTienTrucTiep();
				}
				pre1.close();
				pre1 = con.prepareStatement(sql3);
				pre1.setLong(1, res.getLong("idthanhtoan"));
				res1=pre1.executeQuery();
				while(res1.next()){
					thanhToan = new ChuyenKhoanATM();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().closePre(pre1);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return thanhToan;
	}

	@Override
	public int deleteThanhToan(String maVe) {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "delete from thanhtoan where mave = ?";
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, maVe);
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return 0;
	}

}
