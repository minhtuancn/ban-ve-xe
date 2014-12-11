package DAO;

import model.KhachHang;

public interface KhachHangDAO {
	public KhachHang checkLogIn(String user, String password);
}
