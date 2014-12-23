package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionPool;
import database.Database;
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import model.DiaDiem;
import model.KhachHang;
import model.KhachHangThuongXuyen;
import model.KhachHangVangLai;
import model.TaiKhoan;
import model.Tuyen;
import model.Ve;

public class KhachHangDAOIml implements KhachHangDAO {

	@Override
	public KhachHang checkLogIn(String user, String password) {
		Connection con = ConnectionPool.getInstance().getConnection();
		PreparedStatement pre = null;
		String sql = "SELECT khachhang.idkhachhang,khachhang.cmnd,khachhang.diachi,khachhang.email,khachhang.sdt,khachhang.tenkhachhang,khachhangthuongxuyen.sotien,taikhoan.idtaikhoan,taikhoan.tentk,taikhoan.matkhau FROM khachhang INNER JOIN khachhangthuongxuyen ON khachhang.idkhachhang = khachhangthuongxuyen.idkhachhang INNER JOIN taikhoan ON khachhangthuongxuyen.idtaikhoan = taikhoan.idtaikhoan WHERE taikhoan.matkhau = ? AND taikhoan.tentk = ?";
		ResultSet res;
		KhachHang kh = null;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, password);
			pre.setString(2, user);
			res = pre.executeQuery();
			while (res.next()) {
				kh = new KhachHangThuongXuyen(res.getLong("idkhachhang"),
						res.getString("tenkhachhang"), res.getString("sdt"),
						res.getString("cmnd"), res.getString("diachi"),
						res.getString("email"), res.getLong("sotien"));
				((KhachHangThuongXuyen) kh).setTaiKhoan(new TaiKhoan(res.getString("tentk"), res.getString("matkhau"), true));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return kh;
	}

	@Override
	public KhachHang getKhachHang(String sdt) {
		KhachHang kh = null;
		Connection con = ConnectionPool.getInstance().getConnection();
		PreparedStatement pre = null, pre1 = null, pre2 = null;
		String sql2 = "select idkhachhang , cmnd, diachi, email, tenkhachhang from khachhang where sdt = ?";
		String sql = "SELECT idkhachhang from khachhang WHERE sdt=?";
		String sql1 = "SELECT khachhangthuongxuyen.sotien FROM khachhang INNER JOIN khachhangthuongxuyen ON khachhangthuongxuyen.idkhachhang = khachhang.idkhachhang where sdt=?";
		ResultSet res, res1, res2;
		String tenKhachHang = "", cmnd = "", diaChi = "", email = "";
		long soTien = 0;
		long idkh = -1;
		try {
			pre = con.prepareStatement(sql);
			pre1 = con.prepareStatement(sql1);
			pre2 = con.prepareStatement(sql2);
			pre.setString(1, sdt);
			res = pre.executeQuery();
			if (res.next()) {
				pre2.setString(1, sdt);
				res2 = pre2.executeQuery();
				while (res2.next()) {
					idkh = res2.getLong("idkhachhang");
					cmnd = res2.getString("cmnd");
					diaChi = res2.getString("diachi");
					email = res2.getString("email");
					tenKhachHang = res2.getString("tenkhachhang");
					pre1.setString(1, sdt);
					res1 = pre1.executeQuery();
					if (res1.next()) {
						kh = new KhachHangThuongXuyen(idkh, tenKhachHang, sdt,
								cmnd, diaChi, email, res1.getInt("sotien"));
					} else {
						kh = new KhachHangVangLai(idkh, tenKhachHang, sdt,
								cmnd, diaChi, email);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().closePre(pre1);
			ConnectionPool.getInstance().closePre(pre2);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return kh;
	}

	@Override
	public List<KhachHang> getAllKhachHang() {
		List<KhachHang> listKhachHang = new ArrayList<KhachHang>();
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "select sdt from khachhang";
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql);
			ResultSet res = pre.executeQuery();
			while (res.next()) {
				listKhachHang.add(getKhachHang(res.getString("sdt")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return listKhachHang;

	}

	@Override
	public long addKhachHang(String tenKH, String sdt, String cmnd,
			String diaChi, String email) {
		Connection con = ConnectionPool.getInstance().getConnection();
		PreparedStatement pre = null;
		String sql = "INSERT into khachhang(cmnd,diachi, email, sdt, tenkhachhang) VALUES (?,?,?,?,?)";
		String sql1 = "select idkhachhang from khachhang where sdt = ?";
		ResultSet res;
		long len = -1;
		int size = 0;
		try {
			pre = con.prepareStatement(sql1);
			pre.setString(1, sdt);
			res = pre.executeQuery();
			if (!res.next()) {
				pre.close();
				pre = con.prepareStatement(sql);
				pre.setString(1, cmnd);
				pre.setString(2, diaChi);
				pre.setString(3, email);
				pre.setString(4, sdt);
				pre.setString(5, tenKH);
				size = pre.executeUpdate();
				if (size > 0) {
					pre = con.prepareStatement(sql1);
					pre.setString(1, sdt);
					res = pre.executeQuery();
					len = res.getLong("idkhachhang");
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
	public long addKhachHang(KhachHang kh) {
		Connection con = ConnectionPool.getInstance().getConnection();
		PreparedStatement pre = null;
		String sql = "INSERT into khachhang(cmnd,diachi, email, sdt, tenkhachhang) VALUES (?,?,?,?,?)";
		String sql1 = "select idkhachhang from khachhang where sdt = ?";
		ResultSet res;
		long len = -1;
		int size = 0;
		try {
			pre = con.prepareStatement(sql1);
			pre.setString(1, kh.getSdt());
			res = pre.executeQuery();
			if (!res.next()) {
				pre.close();
				pre = con.prepareStatement(sql);
				pre.setString(1, kh.getCmnd());
				pre.setString(2, kh.getDiaChi());
				pre.setString(3, kh.getEmail());
				pre.setString(4, kh.getSdt());
				pre.setString(5, kh.getTenKhachHang());
				size = pre.executeUpdate();
				if (size > 0) {
					pre = con.prepareStatement(sql1);
					pre.setString(1, kh.getSdt());
					res = pre.executeQuery();
					len = res.getLong("idkhachhang");
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

	// chưa sử dụng
	@Override
	public boolean deleteKhachHang(long id) {
		Connection con = ConnectionPool.getInstance().getConnection();
		PreparedStatement pre = null;
		String sql = "delete from khachhang where idkhachhang = ?";
		ResultSet res;
		try {
			pre = con.prepareStatement(sql);
			pre.setLong(1, id);
			res = pre.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			Database.getInstance().closePre(pre);
			Database.getInstance().closeCon(con);
		}
		return true;
	}

	@Override
	public boolean editKhachHang(long idKH, String value, int columnPosition) {
		Connection con = ConnectionPool.getInstance().getConnection();
		PreparedStatement pre = null;
		ResultSet res;
		List<Ve> list;
		String sql = "update tuyen set ";
		int kq = -1;
		long idDiaDiem;
		switch (columnPosition) {
		case 0:
			sql += "tenkhachhang = " + value;
			try {
				pre = con.prepareStatement(sql);
				kq = pre.executeUpdate();

				if (kq > 0)
					return true;
				else
					return false;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 1:
			list = ((VeDAO) (new FactoryDAOImp().createDAO(FactoryDao.VE_DAO)))
					.searchVe(value);
			if (list.size() > 0)
				return false;
			else {
				sql += "sdt = " + value;
				try {
					pre = con.prepareStatement(sql);
					kq = pre.executeUpdate();
					if (kq > 0)
						return true;
					else
						return false;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		case 2:
			list = ((VeDAO) (new FactoryDAOImp().createDAO(FactoryDao.VE_DAO)))
					.searchVe(value);
			if (list.size() > 0)
				return false;
			else {
				sql += "cmnd = " + value;
				try {
					pre = con.prepareStatement(sql);
					kq = pre.executeUpdate();
					if (kq > 0)
						return true;
					else
						return false;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		case 3:
			sql += "diachi = " + value;
			try {
				pre = con.prepareStatement(sql);
				kq = pre.executeUpdate();
				if (kq > 0)
					return true;
				else
					return false;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 4:
			sql += "email = " + value;
			try {
				pre = con.prepareStatement(sql);
				kq = pre.executeUpdate();
				if (kq > 0)
					return true;
				else
					return false;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;

		}

		return true;
	}

	@Override
	public List<KhachHang> searchKhachHang(String maSearch) {
		List<KhachHang> listKhachHang = new ArrayList<KhachHang>();
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "SELECT idkhachhang, tenkhachhang, sdt, cmnd, diachi, email FROM khachhang WHERE khachhang.sdt like ? OR khachhang.cmnd like ? OR khachhang.tenkhachhang like ? OR khachhang.email like ? OR khachhang.diachi like ? ";
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, "'%" + maSearch + "%'");
			pre.setString(2, "'%" + maSearch + "%'");
			pre.setString(3, "'%" + maSearch + "%'");
			pre.setString(4, "'%" + maSearch + "%'");
			pre.setString(5, "'%" + maSearch + "%'");
			ResultSet res = pre.executeQuery();
			while (res.next()) {
				listKhachHang.add(new KhachHangThuongXuyen(res
						.getLong("idkhachhang"), res.getString("tenkhachhang"),
						res.getString("sdt"), res.getString("cmnd"), res
								.getString("diachi"), res.getString("email")));
				listKhachHang.add(new KhachHangVangLai(res
						.getLong("idkhachhang"), res.getString("tenkhachhang"),
						res.getString("sdt"), res.getString("cmnd"), res
								.getString("diachi"), res.getString("email")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return listKhachHang;
	}

	@Override
	public KhachHang getKhachHang(long id) {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "SELECT idkhachhang FROM khachhangthuongxuyen WHERE idkhachhang = ? ";
		KhachHang khachhang = null;
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql);
			pre.setLong(1, id);
			ResultSet res = pre.executeQuery();
			while (res.next()) {
				khachhang = getKhachHang(res.getString("sdt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return khachhang;
	}

	@Override
	public boolean deleteKhachHang(KhachHang kh) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long upDate(KhachHang kh) {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "update khachhang set tenkhachhang=? , sdt=? , diachi=? , email =? , cmnd=? where idkhachhang =?";
		KhachHang khachhang = null;
		PreparedStatement pre = null;
		long idKhachHang =-1;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, kh.getTenKhachHang());
			pre.setString(2, kh.getSdt());
			pre.setString(3, kh.getDiaChi());
			pre.setString(4, kh.getEmail());
			pre.setString(5, kh.getCmnd());
			pre.setLong(6, kh.getIdKhachHang());
			idKhachHang = pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return idKhachHang;
	}

}
