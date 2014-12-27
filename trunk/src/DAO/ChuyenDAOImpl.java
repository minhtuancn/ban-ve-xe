package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import database.ConnectionPool;
import factory.dao.FactoryDao;
import model.Chuyen;
import model.DiaDiem;
import model.Ghe;
import model.Tuyen;
import model.Xe;

public class ChuyenDAOImpl implements ChuyenDAO {
	private TuyenDAO tuyenDAO;
	private XeDAO xeDAO;
	private GheDAO gheDAO;

	public ChuyenDAOImpl() {
	}

	@Override
	public Chuyen getChuyen(long id, boolean isAdmin) {
		Connection con = ConnectionPool.getInstance().getConnection();
		Chuyen chuyen = null;
		String sql1 = "SELECT phancong.idtuyen, chuyen.idchuyen, chuyen.benxuatphat,  chuyen.chuakhoihanh, chuyen.gia,  chuyen.giokhoihanh,chuyen.idxe, phancong.ngaydi  FROM chuyen INNER JOIN phancong ON phancong.idchuyen = chuyen.idchuyen  WHERE chuyen.idchuyen = ?";
		PreparedStatement pre = null;
		ResultSet res;
		try {
			pre = con.prepareStatement(sql1);
			pre.setLong(1, id);
			res = pre.executeQuery();
			while (res.next()) {
				if (!isAdmin && res.getBoolean("chuakhoihanh")) {
					System.out.println("aaaa");
					continue;
				}
				chuyen = getChuyen(id,
						getTuyenDAO().getTuyen(res.getLong("idTuyen")), isAdmin);
				chuyen.setDanhSachGheNgoi(getGheDAO().getAllGhe(id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return chuyen;
	}

	@Override
	public Chuyen getChuyen(long id, Tuyen tuyen, boolean isAdmin) {
		Connection con = ConnectionPool.getInstance().getConnection();
		Chuyen chuyen = null;
		String sql1 = "SELECT phancong.idtuyen, chuyen.idchuyen, chuyen.benxuatphat,  chuyen.chuakhoihanh, chuyen.gia,  chuyen.giokhoihanh,chuyen.idxe, phancong.ngaydi  FROM chuyen INNER JOIN phancong ON phancong.idchuyen = chuyen.idchuyen  WHERE chuyen.idchuyen = ?";
		PreparedStatement pre = null;
		ResultSet res;
		try {
			pre = con.prepareStatement(sql1);
			pre.setLong(1, id);
			res = pre.executeQuery();
			while (res.next()) {
				if (!isAdmin && res.getBoolean("chuakhoihanh"))
					continue;
				chuyen = new Chuyen(res.getLong("idchuyen"), tuyen,
						res.getString("giokhoihanh"), getXeDAO().getXe(
								res.getLong("idxe")),
						res.getString("benxuatphat"), res.getInt("gia"));
				chuyen.setChuaKhoiHanh(res.getBoolean("chuakhoihanh"));
				chuyen.setDanhSachGheNgoi(getGheDAO().getAllGhe(id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return chuyen;
	}

	@Override
	public List<Chuyen> getAllChuyen(Tuyen tuyen, Date ngayDi, boolean isAdmin) {
		List<Chuyen> list = new ArrayList<Chuyen>();
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql1 = "SELECT idchuyen FROM phancong WHERE idtuyen = ? and Date(ngaydi) = ?";
		PreparedStatement pre = null;
		ResultSet res;
		Chuyen chuyen = null;
		try {
			pre = con.prepareStatement(sql1);
			pre.setLong(1, tuyen.getIdTuyen());
			pre.setDate(2, new java.sql.Date(ngayDi.getTime()));
			res = pre.executeQuery();
			while (res.next()) {
				chuyen = getChuyen(res.getLong("idchuyen"), tuyen, isAdmin);
				if (chuyen != null)
					list.add(chuyen);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		Collections.sort(list);
		return list;
	}

	@Override
	public long addChuyen(Tuyen tuyen, String gioKhoiHanh, long idXe, int gia) {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql1 = "INSERT into chuyen(benxuatphat,chuakhoihanh,gia,giokhoihanh,idxe) VALUES (?,?,?,?,?)";
		String sqlIdChuyen = " SHOW TABLE STATUS LIKE 'chuyen'";
		String sqlPhanCong = "insert into phancong (idtuyen, idchuyen, ngaydi) values (?,?,?)";
		String sqlGhe = "insert into ghe (soghe, trangthai, idchuyen) values (?,0,? )";
		String sql2 = "SELECT giokhoihanh FROM chuyen Where ";
		Xe xe = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		long id = -1;
		try {
			con.setAutoCommit(false);
			pre = con.prepareStatement(sql1);
			pre.setString(1, tuyen.getDiemDi().getTenDiaDiem());
			pre.setBoolean(2, false);
			pre.setInt(3, gia);
			pre.setString(4, gioKhoiHanh);
			pre.setLong(5, idXe);
			id = pre.executeUpdate();
			if (id != 0) {
				pre.close();
				pre = con.prepareStatement(sqlIdChuyen);
				res = pre.executeQuery();
				if (res.next()) {
					id = res.getLong("Auto_increment") - 1;
					pre.close();
					xe = getXeDAO().getXe(idXe);
					pre = con.prepareStatement(sqlGhe);
					pre.setLong(2, id);
					for (int i = 0; i < xe.getSoGhe(); i++) {
						pre.setInt(1, i + 1);
						pre.executeUpdate();
					}
					pre.close();
					pre = con.prepareStatement(sqlPhanCong);
					pre.setLong(1, tuyen.getIdTuyen());
					pre.setLong(2, id);
					pre.setTimestamp(3, new Timestamp(tuyen.getNgayDi()
							.getTime()));
					pre.executeUpdate();
				} else {
					id = -1;
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
			ConnectionPool.getInstance().setDefaulAutoCommit(con);
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}

		return id;
	}

	@Override
	public String deleteChuyen(int id) {
		Connection con = ConnectionPool.getInstance().getConnection();
		String mes = null;
		String sqlCheckGhe = "select trangthai from ghe where idchuyen = ?";
		String sqlDeleteGhe = "delete from ghe where idchuyen  = ?";
		String sqlDeletePhanCong = "Delete from phancong where idchuyen = ?";
		String sqlDeleteChuyen = "Delete from chuyen where idchuyen = ?";
		PreparedStatement pre = null;
		ResultSet res;
		try {
			con.setAutoCommit(false);
			pre = con.prepareStatement(sqlCheckGhe);
			pre.setLong(1, id);
			res = pre.executeQuery();
			while (res.next())
				if (res.getByte("trangthai") != Ghe.CHUA_DAT)
					mes = "Xóa chuyến không thành công, chuyến đã có người đặt vé";
			if (mes == null) {
				pre.close();
				pre = con.prepareStatement(sqlDeleteGhe);
				pre.setLong(1, id);
				pre.executeUpdate();//
				pre.close();
				pre = con.prepareStatement(sqlDeletePhanCong);
				pre.setLong(1, id);
				pre.executeUpdate();//
				pre.close();
				pre = con.prepareStatement(sqlDeleteChuyen);
				pre.setLong(1, id);
				pre.executeUpdate();
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			mes = "Lỗi hệ thống!";
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			ConnectionPool.getInstance().setDefaulAutoCommit(con);
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return mes;
	}

	@Override
	public boolean editChuyen(int id, String value, int columnPosition) {
		Chuyen c = getChuyen(id, true);
		switch (columnPosition) {
		case 0:
			// c.setGioKhoiHanh(value);
			;
			break;
		case 1:
			// if (value.equalsIgnoreCase("45"))
			// xe = new Xe("", "", 45);
			// else
			// xe = new Xe("", "", 16);
			// c.setXe(xe);
			break;
		case 2:
			// c.setBenXuatPhat(value);
			break;
		case 3:
			try{
				c.setGia(Integer.parseInt(value));
				return updateChuyen(c);
			}catch (NumberFormatException e) {
				return false;
			}
		default:
			break;
		}
		return true;
	}

	private boolean updateChuyen(Chuyen chuyen) {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "update chuyen set gia = ? where idchuyen = ?";
		PreparedStatement pre = null;
		boolean kq = false;
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, chuyen.getGia());
			pre.setLong(2, chuyen.getIdChuyen());
			kq = pre.executeUpdate() != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return kq;
	}

	public TuyenDAO getTuyenDAO() {
		return (TuyenDAO) ((tuyenDAO != null) ? tuyenDAO : factoryDao
				.createDAO(FactoryDao.TUYEN_DAO));
	}

	public XeDAO getXeDAO() {
		return (XeDAO) ((xeDAO != null) ? xeDAO : factoryDao
				.createDAO(FactoryDao.XE_DAO));
	}

	public GheDAO getGheDAO() {
		return (GheDAO) ((gheDAO != null) ? gheDAO : factoryDao
				.createDAO(FactoryDao.GHE_DAO));
	}

	@Override
	public String getTenChuyen(long idVe) {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "SELECT tuyen.iddiemdi,tuyen.iddiemden FROM chuyen INNER JOIN ve ON ve.idchuyen = chuyen.idchuyen INNER JOIN phancong ON phancong.idchuyen = chuyen.idchuyen INNER JOIN tuyen ON phancong.idtuyen = tuyen.idtuyen WHEREve.idve = ? ";
		String sql1 = "SELECT tendiadiem FROM diadiem WHERE iddiadiem = ? ";
		PreparedStatement pre = null, pre1 = null;
		ResultSet res, res1;
		String kq = "";
		try {
			pre = con.prepareStatement(sql);
			pre.setLong(1, idVe);
			res = pre.executeQuery();
			while (res.next()) {
				pre1 = con.prepareStatement(sql1);
				pre1.setLong(1, res.getLong("iddiemdi"));
				res1 = pre1.executeQuery();
				while (res1.next()) {
					kq += res1.getString("tendiadiem") + " - ";
				}
				pre1 = con.prepareStatement(sql1);
				pre1.setLong(1, res.getLong("iddiemden"));
				res1 = pre1.executeQuery();
				while (res1.next()) {
					kq += res1.getString("tendiadiem");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().closePre(pre1);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return kq;
	}

	@Override
	public boolean capNhatKhoiHanh(long id) {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "update chuyen set chuakhoihanh = ? where idchuyen = ?";
		PreparedStatement pre = null, pre1 = null;
		boolean kq = false;
		try {
			pre = con.prepareStatement(sql);
			pre.setBoolean(1, true);
			pre.setLong(2, id);
			kq = pre.executeUpdate() != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre1);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return kq;
	}

}
