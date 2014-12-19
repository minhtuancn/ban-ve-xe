package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.ConnectionPool;
import database.Database;
import model.DiaDiem;
import model.Tuyen;

public class TuyenDAOImpl implements TuyenDAO {
	private List<Tuyen> listAllTuyen;
	private List<DiaDiem> listAllDiaDiem;
	private SimpleDateFormat f_yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public Tuyen getTuyen(String diemDi, String diemDen, String date) { // yyyy-MM-dd
		Connection con = ConnectionPool.getInstance().getConnection();
		Tuyen tuyen = null;
		String diemDenRs = "", diemDiRs = "";
		long iddiemDi = -1, iddiemDen = -1;
		String sql1 = "SELECT tuyen.iddiemdi,tuyen.iddiemden,phancong.ngaydi,tuyen.idtuyen FROM tuyen INNER JOIN phancong ON phancong.idtuyen = tuyen.idtuyen WHERE DATE(phancong.ngaydi) =?";
		String sql2 = "SELECT diadiem.tendiadiem FROM diadiem WHERE diadiem.iddiadiem =?";
		PreparedStatement pre = null;
		ResultSet res;
		try {
			Date d = f_yyyy_MM_dd.parse(date);
			pre = con.prepareStatement(sql1);
			pre.setDate(1, new java.sql.Date(d.getTime()));
			res = pre.executeQuery();
			while (res.next()) {
				iddiemDi = res.getLong("iddiemdi");
				iddiemDen = res.getLong("iddiemden");
			}
			if (iddiemDen != -1) {
				pre = con.prepareStatement(sql2);
				pre.setLong(1, iddiemDi);
				res = pre.executeQuery();
				while (res.next()) {
					diemDiRs = res.getString("tendiadiem");
				}
				pre = con.prepareStatement(sql2);
				pre.setLong(1, iddiemDen);
				res = pre.executeQuery();
				while (res.next()) {
					diemDenRs = res.getString("tendiadiem");
				}
				tuyen = new Tuyen(new DiaDiem(diemDiRs), new DiaDiem(diemDenRs));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return tuyen;
	}
	
	

	@Override
	public List<Tuyen> getAllTuyen() {
		listAllTuyen = new ArrayList<>();
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql1 = "SELECT tuyen.idtuyen,tuyen.iddiemdi, tuyen.iddiemden FROM tuyen";
		String sql2 = "SELECT diadiem.tendiadiem FROM diadiem WHERE diadiem.iddiadiem =?";
		PreparedStatement pre = null, pre2 = null;
		ResultSet res, res2;
		try {
			pre = con.prepareStatement(sql1);
			pre2 = con.prepareStatement(sql2);
			long id;
			String diaDiem_s = null;
			res = pre.executeQuery();
			DiaDiem diaDiem;
			while (res.next()) {
				id = res.getLong("iddiemdi");
				pre2.setLong(1, id);
				res2 = pre2.executeQuery();
				while (res2.next()) {
					diaDiem_s = res2.getString("tendiadiem");
				}
				diaDiem = new DiaDiem(id, diaDiem_s);
				//
				id = res.getLong("iddiemden");
				pre2.setLong(1, id);
				res2 = pre2.executeQuery();
				while (res2.next()) {
					diaDiem_s = res2.getString("tendiadiem");
				}
				listAllTuyen
						.add(new Tuyen(diaDiem, new DiaDiem(id, diaDiem_s)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().closePre(pre2);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return listAllTuyen;
	}

	
	@Override
	public long addTuyen(long diemDi, long diemDen) {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "INSERT into tuyen(iddiemdi, iddiemden) VALUES (?,?)";
		String sql1 = "SELECT tuyen.idtuyen FROM tuyen where iddiemdi=? and iddiemden =?";
		long len = -1;
		int size = 0;
		ResultSet res;
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql1);
			pre.setLong(1, diemDi);
			pre.setLong(2, diemDen);
			res = pre.executeQuery();
			if (!res.next()) {
				pre = con.prepareStatement(sql);
				pre.setLong(1, diemDi);
				pre.setLong(2, diemDen);
				size = pre.executeUpdate();
				if (size > 0) {
					pre = con.prepareStatement(sql1);
					pre.setLong(1, diemDi);
					pre.setLong(2, diemDen);
					res = pre.executeQuery();
					while (res.next()) {
						len = res.getLong("idtuyen");
					}
				}
			} else
				len = -2;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return len;
	}

	@Override
	public int deleteTuyen(long id) {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "DELETE FROM tuyen WHERE tuyen.idtuyen=?";
		String sql1 = "SELECT idtuyen FROM phancong WHERE phancong.idtuyen=?";
		PreparedStatement pre = null;
		ResultSet res;
		int len = 1;
		try {
			pre = con.prepareStatement(sql1);
			pre.setLong(1, id);
			res = pre.executeQuery();
			if (!res.next()) {
				pre = con.prepareStatement(sql);
				pre.setLong(1, id);
				if (pre.executeUpdate() == 0)
					len = -1;
			} else {
				len = -2;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}

		return len;
	}

	@Override
	public Tuyen getTuyen(long id) {
		Tuyen tuyen = null;
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql1 = "SELECT iddiemdi, iddiemden FROM tuyen  WHERE idtuyen=?";
		String sql2 = "SELECT tendiadiem FROM diadiem  WHERE iddiadiem=?";
		PreparedStatement pre = null, pre2 = null;
		ResultSet res, res2;
		long iddiadiem;
		DiaDiem diaDiem = null;
		try {
			pre = con.prepareStatement(sql1);
			pre2 = con.prepareStatement(sql2);
			pre.setLong(1, id);
			res = pre.executeQuery();
			while (res.next()) {
				iddiadiem = res.getLong("iddiemdi");
				pre2.setLong(1, iddiadiem);
				res2 = pre2.executeQuery();
				while (res2.next()) {
					diaDiem = new DiaDiem(iddiadiem,
							res2.getString("tendiadiem"));
				}
				//
				iddiadiem = res.getLong("iddiemden");
				pre2.setLong(1, iddiadiem);
				res2 = pre2.executeQuery();
				while (res2.next()) {
					tuyen = new Tuyen(diaDiem, new DiaDiem(iddiadiem,
							res2.getString("tendiadiem")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}

		return tuyen;
	}

	@Override
	public int editTuyen(long id, String value, int columnPosition) {
		Connection con = ConnectionPool.getInstance().getConnection();
		PreparedStatement pre = null;
		ResultSet res;
		String sqlIdDiaDiem = "select iddiemdi, iddiemden from tuyen where idtuyen = ?";
		// sql dùng để kiểm tra chuyến có tồn tại không nếu ta update
		String sqlKtTuyen = "select iddiemdi, iddiemden from tuyen where iddiemdi = ? and iddiemden = ?";
		String sql1 = "update tuyen set "
				+ ((columnPosition == 0) ? " iddiemdi " : " iddiemden ")
				+ " = ? where idtuyen = ?";
		int kq = -1;
		long idDiaDiem;
		long valueL = Long.parseLong(value);
		//
		try {
			pre = con.prepareStatement(sqlIdDiaDiem);
			pre.setLong(1, id);
			res = pre.executeQuery();
			if (res.next()) {
				idDiaDiem = res.getLong((columnPosition == 0) ? 2 : 1);
				pre = con.prepareStatement(sqlKtTuyen);
				if (columnPosition == 0) {
					pre.setLong(1, valueL);
					pre.setLong(2, idDiaDiem);
				} else {
					pre.setLong(1, idDiaDiem);
					pre.setLong(2, valueL);
				}
				res = pre.executeQuery();
				if (res.next()) {
					kq = -2;
				} else {
					if (valueL == idDiaDiem) {
						kq = -3;
					} else {
						pre = con.prepareStatement(sql1);
						pre.setLong(1, valueL);
						pre.setLong(2, id);
						kq = pre.executeUpdate();
					}
				}
			} else
				kq = -1;
		} catch (SQLException e) {
			e.printStackTrace();
			kq = 0;
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return kq;
	}
}
