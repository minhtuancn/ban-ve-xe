package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionPool;
import model.Chuyen;
import model.Ghe;

public class GheDAOImpl implements GheDAO{

	@Override
	public List<Ghe> getAllGhe(long idChuyen) {
		Connection con = ConnectionPool.getInstance().getConnection();
		ArrayList<Ghe> list = new ArrayList<Ghe>();
		String sql1 = "SELECT idghe,soghe,trangthai FROM ghe WHERE idchuyen = ?";
		PreparedStatement pre = null;
		ResultSet res;
		try {
			pre = con.prepareStatement(sql1);
			pre.setLong(1, idChuyen);
			res = pre.executeQuery();
			while (res.next()) {
				list.add(new Ghe(res.getLong("idghe"), res.getInt("soghe"), res.getByte("trangthai")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return list;
	}

}
