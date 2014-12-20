package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controller.DangNhap;
import database.ConnectionPool;
import database.Database;
import model.Chuyen;
import model.DatVe;
import model.Ghe;

public class GheDAOImpl implements GheDAO {

	@Override
	public List<Ghe> getAllGhe(long idChuyen) {
		Connection con = ConnectionPool.getInstance().getConnection();
		ArrayList<Ghe> list = new ArrayList<Ghe>();
		String sql1 = "SELECT idghe,soghe,trangthai,idve, giucho FROM ghe WHERE idchuyen = ?";
		PreparedStatement pre = null;
		ResultSet res;
		Date now = new Date();
		Date dateGiuCho;
		byte trangThai = 0;
		try {
			pre = con.prepareStatement(sql1);
			pre.setLong(1, idChuyen);
			res = pre.executeQuery();
			while (res.next()) {
				switch (res.getByte("trangthai")) {
				case Ghe.CHUA_DAT:
					// khong lam gi het
					break;
				case Ghe.DANG_GIU:
					// kiểm tra thời gian giữ ghế còn hiệu lực không
					dateGiuCho = new Date(res.getTimestamp("giucho").getTime());
					trangThai = dateGiuCho.compareTo(now) < 0 ? Ghe.CHUA_DAT
							: Ghe.DA_DAT;
					break;
				case Ghe.DA_DAT:
					trangThai = Ghe.DA_DAT;
					break;
				default:
					break;
				}
				list.add(new Ghe(res.getLong("idghe"), res.getInt("soghe"),
						trangThai));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return list;
	}

	@Override
	public String setGiuCho(DatVe datVe) {
		List<Ghe> listGhe = datVe.getDanhsachGheDat();
		Connection con = ConnectionPool.getInstance().getConnection();
		String sqlCheck = "select trangthai, giucho from ghe where idghe=?";
		String sqlSet = "update ghe set trangthai=?, giucho = ? where idghe=?";
		PreparedStatement preCheck = null;
		PreparedStatement preSet = null;
		ResultSet res;
		byte trangThai;
		Date giuCho; // var date giữ chố của ghế trên database
		// var date hiện tại + 10 phút
		Date datCho = new Date(System.currentTimeMillis() + 10 * 60 * 1000);
		Date now = new Date();
		String mes = null;
		try {
			con.setAutoCommit(false);
			preCheck = con.prepareStatement(sqlCheck);
			preSet = con.prepareStatement(sqlSet);
			for (Ghe ghe : listGhe) {
				preCheck.setLong(1, ghe.getIdGhe());
				res = preCheck.executeQuery();
				while (res.next()) {
					trangThai = res.getByte("trangthai");
					switch (trangThai) {
					case Ghe.CHUA_DAT:
						preSet.setByte(1, Ghe.DANG_GIU);
						preSet.setTimestamp(2, new Timestamp(datCho.getTime()));
						preSet.setLong(3, ghe.getIdGhe());
						break;
					case Ghe.DANG_GIU:
						if (res.getTimestamp("giucho") != null) {
							giuCho = new Date(res.getTimestamp("giucho")
									.getTime());
							if (giuCho.compareTo(now) > 0) {
								mes = "Ghế " + ghe.getSoGhe() + " của tuyến "
										+ datVe.getTuyenXe()
										+ " đã có người đặt trước!";
								throw new SQLException();
							} else {
								preSet.setByte(1, Ghe.DANG_GIU);
								preSet.setTimestamp(2,
										new Timestamp(datCho.getTime()));
								preSet.setLong(3, ghe.getIdGhe());
							}
						}
						break;
					case Ghe.DA_DAT:
						throw new SQLException();
					default:
						break;
					}
				}
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			ConnectionPool.getInstance().closePre(preCheck);
			ConnectionPool.getInstance().closePre(preSet);
			ConnectionPool.getInstance().setDefaulAutoCommit(con);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return mes;
	}

	@Override
	public List<Ghe> getGheOfVe(long idVe) {
		Connection con = ConnectionPool.getInstance().getConnection();
		ArrayList<Ghe> list = new ArrayList<Ghe>();
		String sql1 = "SELECT idghe,soghe,trangthai,idve, giucho FROM ghe WHERE idve = ?";
		PreparedStatement pre = null;
		ResultSet res;
		Date now = new Date();
		Date dateGiuCho;
		byte trangThai = 0;
		try {
			pre = con.prepareStatement(sql1);
			pre.setLong(1, idVe);
			res = pre.executeQuery();
			while (res.next()) {
				list.add(new Ghe(res.getLong("idghe"), res.getInt("soghe"), res
						.getByte("trangthai")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return list;
	}

	public static void main(String[] args) {
		Connection con = Database.getInstance().getConnection();
		ArrayList<Ghe> list = new ArrayList<Ghe>();
		String sql1 = "SELECT idghe,soghe,trangthai,idve, giucho FROM ghe WHERE idve = ?";
		PreparedStatement pre = null;
		ResultSet res;
		Date now = new Date();
		Date dateGiuCho;
		byte trangThai = 0;
		try {
			pre = con.prepareStatement(sql1);
			pre.setLong(1, 2);
			res = pre.executeQuery();
			while (res.next()) {
				list.add(new Ghe(res.getLong("idghe"), res.getInt("soghe"), res
						.getByte("trangthai")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.getInstance().closePre(pre);
		}
		System.out.println(list);
	}
}
