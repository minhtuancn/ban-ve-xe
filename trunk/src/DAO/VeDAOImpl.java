package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.ConnectionPool;
import database.Database;
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import model.DatVe;
import model.DiaDiem;
import model.ThongTinVe;
import model.Ve;

public class VeDAOImpl implements VeDAO {
	private GheDAO gheDAO;
	private ChuyenDAO chuyenDao;
	private ThanhToanDAO thanhToanDAO;

	@Override
	public List<Ve> getVe(String maVe) {
		return null;
	}

	@Override
	public List<Ve> getAllVe(long idKhachHang) {
		List<Ve> listVe = new ArrayList<>();
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "SELECT idve,dakhoihanh,ghichu,mave,ngaydatve,thoihanthanhtoan,trangthaithanhtoan,idchuyen,idkhachhang,lahuyve,lidohuy FROM ve";
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql);
			pre.setLong(1, idKhachHang);
			ResultSet res = pre.executeQuery();
			while (res.next()) {
				listVe.add(new Ve(res.getString("mave"), res
						.getString("ghichu"), res.getDate("ngaydatve"),
						((GheDAO) new FactoryDAOImp()
								.createDAO(FactoryDao.GHE_DAO)).getGheOfVe(res
								.getLong("idve")),
						res.getBoolean("dakhoihanh"), res
								.getBoolean("trangthaithanhtoan"), res
								.getDate("thoihanthanhtoan"), res
								.getBoolean("trangthaihuyve"), res
								.getString("lidohuyve")));
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
				ve = new Ve(res.getLong("idve"),res.getString("mave"), res
						.getString("ghichu"), res.getDate("ngaydatve"), null,
						res.getBoolean("dakhoihanh"), res
								.getBoolean("trangthaithanhtoan"), res
								.getDate("thoihanthanhtoan"), res
								.getBoolean("trangthaihuyve"), res
								.getString("lidohuyve"));
				ve.setPhuongThucThanhToan(getThanhToanDAO().getThanhToan(ve.getIdVe()));;
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
		gheDAO =  (GheDAO) (gheDAO != null ? gheDAO : factoryDao
				.createDAO(FactoryDao.GHE_DAO));
		return gheDAO;

	}

	public ChuyenDAO getChuyenDAO(){
		chuyenDao = (ChuyenDAO) (chuyenDao!=null ? chuyenDao : factoryDao.createDAO(FactoryDao.CHUYEN_DAO));
		return chuyenDao;
	}
	
	public ThanhToanDAO getThanhToanDAO(){
		thanhToanDAO = (ThanhToanDAO) (thanhToanDAO!=null ? thanhToanDAO : factoryDao.createDAO(FactoryDao.THANH_TOAN_DAO));
		return thanhToanDAO;
	}
	
	@Override
//	public String addVe( String ghiChu, String maVe, Date ngayDat,
//			Date thoiHanThanhToan, long idChuyen,
//			long idKhachHang) {
	public String addVe(Ve ve){
		Connection con = ConnectionPool.getInstance().getConnection();
		PreparedStatement pre = null, pre1 = null;
		String sql = "INSERT into Ve(dakhoihanh, ghichu,mave,ngaydatve, thoihanthanhtoan, trangthaithanhtoan, idchuyen, idkhachhang, lahuyve) VALUES (?,?,?,?,?,?,?,?,?)";
		ResultSet res;
		int len = 1;
		String giuCho = null;
		try {
			gheDAO = getGheDAO();
//			Ve ve = new Ve(maVe,new DatVe(getChuyenDAO().getChuyen(idChuyen)), ghiChu);
			giuCho = gheDAO.setGiuCho(ve);
			if(null == giuCho){
			pre = con.prepareStatement(sql);
			pre.setByte(1, (byte) 0);
			pre.setString(2, ve.getGhiChu());
			pre.setString(3, ve.getMaVe());
			pre.setTimestamp(4,new Timestamp(ve.getNgayDatVes().getTime()));
			pre.setTimestamp(5,new Timestamp(ve.getThoiHanThanhToans().getTime()));
			pre.setByte(6, (byte) 0);
			pre.setLong(7, ve.getChuyen().getIdChuyen());
			pre.setLong(8, ve.getKhachHang().getIdKhachHang());
			pre.setByte(9, (byte) 0);
			if (pre.executeUpdate() == 0) {
				giuCho= "Thêm vé không thành công!";
				gheDAO.setNonGiuCho(ve);
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return giuCho;
	}

}
