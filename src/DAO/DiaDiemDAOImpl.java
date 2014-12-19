package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionPool;
import database.Database;
import model.DiaDiem;
import model.Tuyen;

public class DiaDiemDAOImpl implements DiaDiemDAO {
	private static List<DiaDiem> listDiaDiem;

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
		listDiaDiem = new ArrayList<>();
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return listDiaDiem;
	}


	@Override
	public int addDiaDiem(String tenDiaDiem) {
		listDiaDiem.add(new DiaDiem(tenDiaDiem));
		return listDiaDiem.size();
	}

	@Override
	public boolean deleteDiaDiem(int id) {
		listDiaDiem.remove(id);
		return true;
	}

	@Override
	public boolean editDiaDiem(int id, String value) {
		DiaDiem t = listDiaDiem.get(id);
		t.setTenDiaDiem(value);
		return true;
	}
}
