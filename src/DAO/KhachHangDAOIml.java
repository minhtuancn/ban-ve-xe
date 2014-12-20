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
import model.KhachHang;
import model.KhachHangThuongXuyen;
import model.KhachHangVangLai;
import model.TaiKhoan;
import model.Tuyen;
import model.Ve;

public class KhachHangDAOIml implements KhachHangDAO {
	private static List<KhachHang> listKhachHang;

	@Override
	public KhachHang checkLogIn(String user, String password) {
		// return new KhachHangThuongXuyen("Hoang Nhuoc Quy", "1234567890",
		// "123456", "Tay Ninh", "123@gmail.com", new TaiKhoan("hoangnhuocquy",
		// "123", true), 10000000);
		Connection con = ConnectionPool.getInstance().getConnection();
		PreparedStatement pre = null;
		String sql = "SELECT taikhoan.idkhachhang,khachhang.idkhachhang,khachhang.cmnd,khachhang.diachi,khachhang.email,khachhang.sdt,khachhang.tenkhachhang,khachhangthuongxuyen.sotien FROM khachhangthuongxuyen INNER JOIN taikhoan ON taikhoan.idkhachhang = khachhangthuongxuyen.idkhachhang INNER JOIN khachhang ON khachhangthuongxuyen.idkhachhang = khachhang.idkhachhang WHEREtaikhoan.matkhau = ? AND taikhoan.tentk = ?";
		ResultSet res;
		KhachHang kh = null;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, password);
			pre.setString(2, user);
			res = pre.executeQuery();
			while (res.next()) {
				return new KhachHangThuongXuyen(res.getLong("idkhachhang"),
						res.getString("tenkhachhang"), res.getString("sdt"),
						res.getString("cmnd"), res.getString("diachi"),
						res.getString("email"), res.getLong("sotien"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		String sql1 = "SELECT idkhachhang from khachhangthuongxuyen WHERE idkhachhang=?";
		String sql = "SELECT khachhang.idkhachhang, khachhang.cmnd, khachhang.diachi, khachhang.email, khachhangthuongxuyen.sotien, khachhang.tenkhachhang FROM khachhang INNER JOIN khachhangthuongxuyen ON khachhangthuongxuyen.idkhachhang = khachhang.idkhachhang where sdt=?";
		ResultSet res, res1, res2;
		String tenKhachHang = "", cmnd = "", diaChi = "", email = "";
		long soTien = 0;
		long idkh = -1;
		try {
			pre = con.prepareStatement(sql1);
			pre1 = con.prepareStatement(sql);
			pre2 = con.prepareStatement(sql2);
			pre.setLong(1, idkh);
			res = pre.executeQuery();
			if (res.next()) {
				pre1.setString(1, sdt);
				res1 = pre1.executeQuery();
				while (res1.next()) {
					idkh = res1.getLong("idkhachhang");
					cmnd = res1.getString("cmnd");
					diaChi = res1.getString("diachi");
					email = res1.getString("email");
					tenKhachHang = res1.getString("tenkhachhang");
					soTien = res1.getLong("sotien");
				}
			kh = new KhachHangThuongXuyen(idkh,tenKhachHang, sdt,
						cmnd, diaChi, email, soTien);

			} else {
				pre2.setString(1, sdt);
				res2 = pre2.executeQuery();
				while (res2.next()) {
					idkh = res2.getLong("idkhachhang");
					cmnd = res2.getString("cmnd");
					diaChi = res2.getString("diachi");
					email = res2.getString("email");
					tenKhachHang = res2.getString("tenkhachhang");
					kh = new KhachHangVangLai(idkh,tenKhachHang, sdt,
							cmnd, diaChi, email);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return kh;
	}
	@Override
	public List<KhachHang> getAllKhachHang() {
		listKhachHang = new ArrayList<>();
		Connection con = ConnectionPool.getInstance().getConnection();
		PreparedStatement pre = null, pre1 = null, pre2 = null;
		String sql2 = "select idkhachhang , cmnd, diachi, email, sdt, tenkhachhang from khachhang";
		String sql1 = "SELECT idkhachhang from khachhangthuongxuyen WHERE idkhachhang=?";
		String sql = "SELECT khachhang.idkhachhang, khachhang.cmnd, khachhang.diachi, khachhang.email, khachhang.sdt, khachhangthuongxuyen.sotien, khachhang.tenkhachhang FROM khachhang INNER JOIN khachhangthuongxuyen ON khachhangthuongxuyen.idkhachhang = khachhang.idkhachhang";
		ResultSet res, res1, res2;
		String tenKhachHang = "", sdt = "", cmnd = "", diaChi = "", email = "";
		long soTien = 0;
		long idkh = -1;
		try {
			pre = con.prepareStatement(sql1);
			pre1 = con.prepareStatement(sql);
			pre2 = con.prepareStatement(sql2);
			pre.setLong(1, idkh);
			res = pre.executeQuery();
			if (res.next()) {
				res1 = pre1.executeQuery();
				while (res1.next()) {
					idkh = res1.getLong("idkhachhang");
					cmnd = res1.getString("cmnd");
					diaChi = res1.getString("diachi");
					email = res1.getString("email");
					sdt = res1.getString("sdt");
					tenKhachHang = res1.getString("tenkhachhang");
					soTien = res1.getLong("sotien");
				}
				listKhachHang.add(new KhachHangThuongXuyen(idkh,tenKhachHang, sdt,
						cmnd, diaChi, email, soTien));

			} else {
				res2 = pre2.executeQuery();
				while (res2.next()) {
					idkh = res2.getLong("idkhachhang");
					cmnd = res2.getString("cmnd");
					diaChi = res2.getString("diachi");
					email = res2.getString("email");
					sdt = res2.getString("sdt");
					tenKhachHang = res2.getString("tenkhachhang");
					listKhachHang.add(new KhachHangVangLai(idkh,tenKhachHang, sdt,
							cmnd, diaChi, email));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	public boolean deleteKhachHang(long id) {
		Connection con = ConnectionPool.getInstance().getConnection();
		PreparedStatement pre = null;
		String sql = "delete from khachhang where id = ?";
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
		String sql = "update khachhang set ";
		// KhachHang kh = listKhachHang.get(idKH);
		// switch (columnPosition) {
		// case 0:
		// kh.setTenKhachHang(value);
		// break;
		// case 1:
		// kh.setSdt(value);
		// break;
		// case 2:
		// kh.setSdt(value);
		// break;
		// case 3:
		// kh.setCmnd(value);
		// ;
		// break;
		// case 4:
		// kh.setDiaChi(value);
		// break;
		// case 5:
		// kh.setEmail(value);
		// break;
		// default:
		// break;
		// }
		return true;
	}

}
