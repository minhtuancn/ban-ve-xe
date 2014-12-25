package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.LayMaVe;
import database.ConnectionPool;
import database.Database;
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import model.DatVe;
import model.DiaDiem;
import model.Ghe;
import model.KhachHang;
import model.KhachHangThuongXuyen;
import model.KhachHangVangLai;
import model.ThongTinVe;
import model.Ve;

public class VeDAOImpl implements VeDAO {
	private GheDAO gheDAO;
	private ChuyenDAO chuyenDao;
	private ThanhToanDAO thanhToanDAO;
	private KhachHangDAO khachHangDAO;


	@Override
	public List<Ve> getAllVe(long idKhachHang) {
		List<Ve> listVe = new ArrayList<>();
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "SELECT idve,dakhoihanh,ghichu,mave,ngaydatve,thoihanthanhtoan,trangthaithanhtoan,idchuyen,idkhachhang,lahuyve,lidohuy FROM ve where idkhachhang = ?";
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql);
			pre.setLong(1, idKhachHang);
			ResultSet res = pre.executeQuery();
			Ve ve;
			while (res.next()) {
				ve = new Ve(res.getString("mave"), res.getString("ghichu"),
						res.getDate("ngaydatve"),
						((GheDAO) new FactoryDAOImp()
								.createDAO(FactoryDao.GHE_DAO)).getGheOfVe(res
								.getLong("idve")),
						res.getBoolean("dakhoihanh"),
						res.getBoolean("trangthaithanhtoan"),
						res.getDate("thoihanthanhtoan"),
						res.getBoolean("lahuyve"), res.getString("lidohuy"));
				ve.setPhuongThucThanhToan(getThanhToanDAO().getThanhToan(
						ve.getIdVe()));
				ve.setChuyen(getChuyenDAO().getChuyen(res.getLong("idchuyen")));
				listVe.add(ve);
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
		Ve ve = null;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, "'%" + maSearch + "%'");
			pre.setString(2, "'%" + maSearch + "%'");
			pre.setString(3, "'%" + maSearch + "%'");
			pre.setString(4, "'%" + maSearch + "%'");
			ResultSet res = pre.executeQuery();
			while (res.next()) {
				ve = new Ve(res.getLong("idve"), res.getString("mave"),
						res.getString("ghichu"), res.getDate("ngaydatve"),
						null, res.getBoolean("dakhoihanh"),
						res.getBoolean("trangthaithanhtoan"),
						res.getDate("thoihanthanhtoan"),
						res.getBoolean("trangthaihuyve"),
						res.getString("lidohuyve"));
				ve.setPhuongThucThanhToan(getThanhToanDAO().getThanhToan(
						ve.getIdVe()));
				ve.setChuyen(getChuyenDAO().getChuyen(res.getLong("idchuyen")));
				listVe.add(ve);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return listVe;
	}

	public GheDAO getGheDAO() {
		gheDAO = (GheDAO) (gheDAO != null ? gheDAO : factoryDao
				.createDAO(FactoryDao.GHE_DAO));
		return gheDAO;

	}

	public ChuyenDAO getChuyenDAO() {
		chuyenDao = (ChuyenDAO) (chuyenDao != null ? chuyenDao : factoryDao
				.createDAO(FactoryDao.CHUYEN_DAO));
		return chuyenDao;
	}

	public ThanhToanDAO getThanhToanDAO() {
		thanhToanDAO = (ThanhToanDAO) (thanhToanDAO != null ? thanhToanDAO
				: factoryDao.createDAO(FactoryDao.THANH_TOAN_DAO));
		return thanhToanDAO;
	}

	public KhachHangDAO getKhachHangDAO() {
		khachHangDAO = (KhachHangDAO) (khachHangDAO != null ? khachHangDAO
				: factoryDao.createDAO(FactoryDao.KHACH_HANG_DAO));
		return khachHangDAO;
	}

	@Override
	public String addVe(Ve ve) {
		Connection con = ConnectionPool.getInstance().getConnection();
		System.out.println("VeDAOImlp " + ve.getTenGhe());
		PreparedStatement pre = null;
		String sql = "INSERT into Ve(dakhoihanh, ghichu,mave,ngaydatve, thoihanthanhtoan, trangthaithanhtoan, idchuyen, idkhachhang, lahuyve, dagiahan) VALUES (?,?,?,?,?,?,?,?,?,0)";
		String giuCho = null;
		try {
			giuCho = getGheDAO().setGiuCho(ve, Ghe.DANG_GIU);
			if (giuCho != null) {
				throw new SQLException("error");
			} else {
				pre = con.prepareStatement(sql);
				pre.setByte(1, (byte) 0);
				pre.setString(2, ve.getGhiChu());
				pre.setString(3, ve.getMaVe());
				pre.setTimestamp(4, new Timestamp(ve.getNgayDatVes().getTime()));
				pre.setTimestamp(5, new Timestamp(ve.getThoiHanThanhToans()
						.getTime()));
				pre.setByte(6, (byte) 0);
				pre.setLong(7, ve.getChuyen().getIdChuyen());
				pre.setLong(8, ve.getKhachHang().getIdKhachHang());
				pre.setByte(9, (byte) 0);
				if (pre.executeUpdate() == 0) {
					giuCho = "Thêm vé không thành công!";
					throw new SQLException("error");
				}
			}
		} catch (SQLException e) {
			if (!"error".equals(e.getMessage()))
				giuCho = "Lỗi hệ thống, xin vui lòng thử lại sau vài phút!";
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return giuCho;
	}

	@Override
	public Ve timVeOfMaVe(String maVe) {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "SELECT ve.idve, ve.dakhoihanh, ve.ghichu,ve.mave,ve.ngaydatve,ve.thoihanthanhtoan,ve.trangthaithanhtoan,ve.idchuyen,ve.lahuyve,ve.lidohuy,ve.idkhachhang FROM ve INNER JOIN khachhang ON ve.idkhachhang = khachhang.idkhachhang WHERE ve.mave = ?";
		PreparedStatement pre = null;
		Ve ve = null;
		Date now = new Date();
		Date thoiHanThanhToan;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, maVe);
			ResultSet res = pre.executeQuery();
			while (res.next()) {
				thoiHanThanhToan = res.getTimestamp("thoihanthanhtoan");
				if (thoiHanThanhToan.compareTo(now) < 0 && !res.getBoolean("trangthaithanhtoan")) {
					deleteVe(maVe);
				} else {
					ve = new Ve(res.getLong("idve"), res.getString("mave"),
							res.getString("ghichu"), new Date(res.getTimestamp(
									"ngaydatve").getTime()), getGheDAO()
									.getGheOfVe(res.getLong("idve")),
							res.getBoolean("dakhoihanh"),
							res.getBoolean("trangthaithanhtoan"),
							res.getTimestamp("thoihanthanhtoan"),
							res.getBoolean("lahuyve"), res.getString("lidohuy"));
					ve.setPhuongThucThanhToan(getThanhToanDAO().getThanhToan(
							ve.getIdVe()));
					ve.setChuyen(getChuyenDAO().getChuyen(
							res.getLong("idchuyen")));
					System.out.println("Vedaoiml " + ve.getThoiHanThanhToans());
					System.out.println("Vedaoiml " + ve.getThoiHanThanhToan());
					ve.setKhachHang(getKhachHangDAO().getKhachHang(
							res.getLong("idkhachhang")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return ve;
	}

	@Override
	public void deleteVe(Ve ve) {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "delete from ve where idve = ? or mave = ?";
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql);
			pre.setLong(1, ve.getIdVe());
			pre.setString(2, ve.getMaVe());
			pre.executeUpdate();
			LayMaVe.getInstant().ungetMaVe(ve.getMaVe());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}

	}

	@Override
	public void deleteVe(String maVe) {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "delete from ve where mave = ?";
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
	}

	public boolean checkMaVe(String maVe) {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "select maVe from ve where mave = ?";
		PreparedStatement pre = null;
		boolean kq = true;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, maVe);
			kq = pre.executeQuery().next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return kq;

	}

	@Override
	public String thanhToanVe(String maVe) {
		Ve ve = timVeOfMaVe(maVe);
		String mes = null;
		if (ve != null) {
			mes = getGheDAO().setGheDaDat(ve);
			if (mes == null) {
				mes = getKhachHangDAO().thanhToanVe(ve);
				if (mes == null) {
					Connection con = ConnectionPool.getInstance()
							.getConnection();
					String sql = "update ve set trangthaithanhtoan = ? where mave =?";
					PreparedStatement pre = null;
					try {
						pre = con.prepareStatement(sql);
						pre.setBoolean(1, true);
						pre.setString(2, maVe);
						pre.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						ConnectionPool.getInstance().closePre(pre);
						ConnectionPool.getInstance().freeConnection(con);
					}
				}
			}
		} else {
			mes = "Vé đã bị hủy do hết hạn thanh toán!";
		}
		return mes;
	}

	@Override
	public String giaHan(String maVe) {
		System.out.println("VeDaoImpl " + maVe);
		String mes = null;
		Date date;
		Date now = new Date();
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "select thoihanthanhtoan, dagiahan from ve where mave = ?";
		String sqlUpdate = "update ve set thoihanthanhtoan = ?, dagiahan = ? where mave = ?";
		PreparedStatement pre = null;
		ResultSet res;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, maVe);
			res = pre.executeQuery();
			if (res.next()) {
				if (!res.getBoolean("dagiahan")) {
					date = new Date(res.getTimestamp("thoihanthanhtoan")
							.getTime());
					if (date.compareTo(now) < 0) {
						mes = "Mã vé không tồn tại hoặc đã bị huỷ do hết hạn thanh toán!";
						deleteVe(maVe);
						throw new SQLException("daxoa");
					} else {
						date.setTime(date.getTime() +  2 * 60 * 60 * 1000);
						mes = getGheDAO().giaHan(maVe, date);
						if (mes == null) {
							pre.close();
							pre = con.prepareStatement(sqlUpdate);
							pre.setTimestamp(1, new Timestamp(date.getTime()));
							pre.setBoolean(2, true);
							pre.setString(3, maVe);
							if (pre.executeUpdate() == 0) {
								mes = "Mã vé không tồn tại hoặc đã bị huỷ do hết hạn thanh toán!";
								throw new SQLException("daxoa");
							}
						}else{
							throw new SQLException("daxoa");
						}
					}
				} else {
					mes = "Gia hạn không thành công! Vé đã 1 lần gia han!";
					throw new SQLException("daxoa");
				}
			} else {
				mes = "Mã vé không tồn tại hoặc đã bị huỷ do hết hạn thanh toán!";
				throw new SQLException("daxoa");
			}
		} catch (SQLException e) {
			if (!e.getMessage().equals("daxoa"))
				mes = "Lỗi hệ thống!";
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return mes;
	}

}
