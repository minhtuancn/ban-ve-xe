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
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import model.Chuyen;
import model.DatVe;
import model.Ghe;
import model.Ve;

public class GheDAOImpl implements GheDAO {
	private VeDAO veDAO;
	
	@Override
	public List<Ghe> getAllGhe(long idChuyen) {
		Connection con = ConnectionPool.getInstance().getConnection();
		ArrayList<Ghe> list = new ArrayList<Ghe>();
		String sql1 = "SELECT idghe,soghe,trangthai, giucho FROM ghe WHERE idchuyen = ?";
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
				trangThai = 0;
				switch (res.getByte("trangthai")) {
				case Ghe.CHUA_DAT:
					// khong lam gi het
					break;
				case Ghe.DANG_GIU:
					// kiểm tra thời gian giữ ghế còn hiệu lực không
					System.out.println("GheDAOImpl : "+ res.getTimestamp("giucho"));
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
	public String setGiuCho(Ve datVe) {
		List<Ghe> listGhe = datVe.getDanhSachGhe();
		Connection con = ConnectionPool.getInstance().getConnection();
		String sqlCheck = "select trangthai, giucho , mave from ghe where idghe=?";
		String sqlSet = "update ghe set trangthai=?, giucho = ? , mave=? where idghe=?";
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
						preSet.setString(3, datVe.getMaVe());
						preSet.setLong(4, ghe.getIdGhe());
						preSet.executeUpdate();
						break;
					case Ghe.DANG_GIU:
						if (res.getTimestamp("giucho") != null) {
							giuCho = new Date(res.getTimestamp("giucho")
									.getTime());
							if (giuCho.compareTo(now) > 0) {
								mes = "Ghế " + ghe.getSoGhe() + " của tuyến "
										+ datVe.getTuyenXe()
										+ " đã có người đặt trước!";
								throw new SQLException("dadat");
							} else {
								getVeDAO().deleteVe(res.getString("mave"));
								preSet.setByte(1, Ghe.DANG_GIU);
								preSet.setTimestamp(2,
										new Timestamp(datCho.getTime()));
								preSet.setString(3, datVe.getMaVe());
								preSet.setLong(4, ghe.getIdGhe());
								preSet.executeUpdate();
							}
						}
						break;
					case Ghe.DA_DAT:
						mes = "Ghế " + ghe.getSoGhe() + " của tuyến "
								+ datVe.getTuyenXe()
								+ " đã có người đặt trước!";
						throw new SQLException("dadat");
					default:
						break;
					}
				}
			}
			con.commit();
		} catch (SQLException e) {
			if(!"dadat".equals(e.getMessage()))
			mes = "Lỗi hệ thống, xin vui lòng thử lại sau vài phút!";
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
		String sql1 = "SELECT ve.idve, ghe.idghe, ghe.soghe, ghe.trangthai, ghe.mave, ghe.idchuyen, ghe.giucho FROM ve INNER JOIN ghe ON ghe.mave = ve.mave where ve.idve = ?;";
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


	@Override
	public String setNonGiuCho(Ve datVe) {
		List<Ghe> listGhe = datVe.getDanhSachGhe();
		Connection con = ConnectionPool.getInstance().getConnection();
		String sqlSet = "update ghe set trangthai=? where idghe=?";
		PreparedStatement preSet = null;
		String mes = null;
		int i = 0;
		try {
			con.setAutoCommit(false);
			preSet = con.prepareStatement(sqlSet);
			for (Ghe ghe : listGhe){
				preSet.setByte(1, Ghe.DANG_GIU);
				preSet.setLong(2, ghe.getIdGhe());
				if (preSet.executeUpdate() == 0){
					throw new SQLException();
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
			ConnectionPool.getInstance().closePre(preSet);
			ConnectionPool.getInstance().setDefaulAutoCommit(con);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return mes;
	}

	/**
	 * @return the veDAO
	 */
	public VeDAO getVeDAO() {
		veDAO = (VeDAO) (veDAO == null ? new FactoryDAOImp().createDAO(FactoryDao.VE_DAO): veDAO);
		return veDAO;
	}
	
}
