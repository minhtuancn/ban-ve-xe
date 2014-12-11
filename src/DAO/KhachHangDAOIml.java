package DAO;

import model.KhachHang;
import model.KhachHangThuongXuyen;
import model.TaiKhoan;

public class KhachHangDAOIml implements KhachHangDAO{

	@Override
	public KhachHang checkLogIn(String user, String password) {
		return new KhachHangThuongXuyen("Hoang Nhuoc Quy", "1234567890", "123456", "Tay Ninh", "123@gmail.com", new TaiKhoan("hoangnhuocquy", "123", true), 10000000);
	}

}
