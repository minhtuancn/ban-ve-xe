package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import database.ConnectionPool;
import database.Database;
import factory.dao.DAO;
import model.DiaDiem;
import model.Tuyen;

public class DiaDiemDAOImpl implements DiaDiemDAO, DAO {

	@Override
	public DiaDiem getDiaDiem(long id) {
		DiaDiem diadiem = null;
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql1 = "SELECT tendiadiem FROM diadiem  WHERE iddiadiem=?";
		PreparedStatement pre = null;
		ResultSet res;
		try {
			pre = con.prepareStatement(sql1);
			pre.setLong(1, id);
			res = pre.executeQuery();
			while (res.next()) {
				diadiem = new DiaDiem(id, res.getString("tendiadiem"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}

		return diadiem;
	}

	@Override
	public List<DiaDiem> getAllDiaDiem() {
		List<DiaDiem> listDiaDiem = new ArrayList<>();
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "SELECT diadiem.iddiadiem,diadiem.tendiadiem FROM diadiem";
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql);
			ResultSet res = pre.executeQuery();
			while (res.next()) {
				listDiaDiem.add(new DiaDiem(res.getLong("iddiadiem"), res
						.getString("tendiadiem")));
			}
			Collections.sort(listDiaDiem);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return listDiaDiem;
	}

	@Override
	public long addDiaDiem(String tenDiaDiem) {
		Connection con = ConnectionPool.getInstance().getConnection();
		PreparedStatement pre = null, pre1 = null;
		String sql = "INSERT into diadiem(tendiadiem) VALUES (?)";
		String sql1 = "select iddiadiem from diadiem where tendiadiem = ?";
		ResultSet res;
		long len = 1;
		try {

			pre1 = con.prepareStatement(sql);
			pre1.setString(1, tenDiaDiem);
			if (pre1.executeUpdate() == 0) {
				len = -1;
			} else {
				pre = con.prepareStatement(sql1);
				pre.setString(1, tenDiaDiem);
				res = pre.executeQuery();
				if (!res.next()) {
					len = -2;
				} else
					len = res.getLong("iddiadiem");
			}
		} catch (SQLException e) {
			len = -1;
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().closePre(pre1);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return len;
	}

	@Override
	public int deleteDiaDiem(long idDD) {
		Connection con = ConnectionPool.getInstance().getConnection();
		PreparedStatement pre = null;
		String sql = "delete from diadiem where iddiadiem = ?";
		String sqlCheck = "SELECT tuyen.idtuyen, tuyen.iddiemdi,tuyen.iddiemden FROM tuyen WHERE tuyen.iddiemdi = ? OR tuyen.iddiemden = ?";
		ResultSet res;
		int kq = 1;
		try {
			pre = con.prepareStatement(sqlCheck);
			pre.setLong(1, idDD);
			pre.setLong(2, idDD);
			res = pre.executeQuery();
			if (!res.next()) {
				pre.close();
				pre = con.prepareStatement(sql);
				pre.setLong(1, idDD);
				if(pre.executeUpdate() == 0)
					kq = -2;
			}else{
				kq = -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			kq = -3;
		} finally {
			Database.getInstance().closePre(pre);
			Database.getInstance().closeCon(con);
		}
		return kq;
	}

	@Override
	public boolean editDiaDiem(long id, String value) {
		Connection con = ConnectionPool.getInstance().getConnection();
		PreparedStatement pre = null;
		String sql = "update diadiem set tendiadiem = ? where iddiadiem = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, value);
			pre.setLong(2, id);
			if (pre.executeUpdate() == 0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
}
