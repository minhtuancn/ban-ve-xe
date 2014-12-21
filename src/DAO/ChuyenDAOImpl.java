package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.ConnectionPool;
import factory.dao.FactoryDao;
import model.Chuyen;
import model.DiaDiem;
import model.Tuyen;
import model.Xe;

public class ChuyenDAOImpl implements ChuyenDAO {
	private TuyenDAO tuyenDAO;
	private XeDAO xeDAO;
	private GheDAO gheDAO;

	public ChuyenDAOImpl() {
	}

	@Override
	public Chuyen getChuyen(long id) {
		Connection con = ConnectionPool.getInstance().getConnection();
		Chuyen chuyen = null;
		String sql1 = "SELECT phancong.idtuyen, chuyen.idchuyen, chuyen.benxuatphat,  chuyen.chuakhoihanh, chuyen.gia,  chuyen.giokhoihanh,chuyen.idxe, phancong.ngaydi  FROM chuyen INNER JOIN phancong ON phancong.idchuyen = chuyen.idchuyen  WHERE chuyen.idchuyen = ?";
		PreparedStatement pre = null;
		ResultSet res;
		Tuyen tuyen = null;
		try {
			pre = con.prepareStatement(sql1);
			pre.setLong(1, id);
			res = pre.executeQuery();
			while (res.next()) {
				chuyen = getChuyen(id,getTuyenDAO()
						.getTuyen(res.getLong("idTuyen")));
						
			}
			chuyen.setDanhSachGheNgoi(getGheDAO().getAllGhe(id));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return chuyen;
	}

	@Override
	public Chuyen getChuyen(long id, Tuyen tuyen) {
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
				chuyen = new Chuyen(res.getLong("idchuyen"), tuyen,
						res.getString("giokhoihanh"), getXeDAO().getXe(
								res.getLong("idxe")),
						res.getString("benxuatphat"), res.getInt("gia"));
			}
			chuyen.setDanhSachGheNgoi(getGheDAO().getAllGhe(id));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return chuyen;
	}

	@Override
	public List<Chuyen> getAllChuyen(Tuyen tuyen, Date ngayDi) {
		List<Chuyen> list = new ArrayList<Chuyen>();
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql1 = "SELECT idchuyen FROM phancong WHERE idtuyen = ? and Date(ngaydi) = ?";
		PreparedStatement pre = null;
		ResultSet res;
		try {
			pre = con.prepareStatement(sql1);
			pre.setLong(1, tuyen.getIdTuyen());
			pre.setDate(2, new java.sql.Date(ngayDi.getTime()));
			res = pre.executeQuery();
			while (res.next()) {
				list.add(getChuyen(res.getLong("idchuyen"), tuyen));
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
	public int addChuyen(Tuyen tuyen, String gioKhoiHanh, long idXe,
			String benXuatPhat, int gia) {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql1 = "INSERT into chuyen(benxuatphat,chuakhoihanh,gia,giokhoihanh,idtuyen,idxe) VALUES (?,?,?,?,?,?)";
		String sql2 = "SELECT giokhoihanh FROM chuyen Where ";
		PreparedStatement pre = null;
		int res;
		try {
			// if()
			pre = con.prepareStatement(sql1);
			pre.setString(1, benXuatPhat);
			pre.setBoolean(2, false);
			pre.setInt(3, gia);
			pre.setString(4, gioKhoiHanh);
			pre.setLong(4, tuyen.getIdTuyen());
			pre.setLong(6, idXe);
			res = pre.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}

		return 1;
	}

	@Override
	public boolean deleteChuyen(int id) {
		// list.remove(id);
		// System.out.println(id);
		return true;
	}

	@Override
	public boolean editChuyen(int id, String value, int columnPosition) {
		// Chuyen c = list.get(id);
		Xe xe = null;
		System.out.println(columnPosition);
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
			// c.setGia(Integer.parseInt(value));
			break;
		default:
			break;
		}
		return true;
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

}
