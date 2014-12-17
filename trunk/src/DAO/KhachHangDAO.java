package DAO;

import java.util.List;

import model.DiaDiem;
import model.KhachHang;
import model.Ve;

public interface KhachHangDAO {
	public KhachHang checkLogIn(String user, String password);
	public KhachHang getKhachHang(String sdt);
	public List<KhachHang> getAllKhachHang();
	public int addKhachHang(String tenKH, String sdt, String cmnd, String diaChi, String email);
	public boolean deleteKhachHang(int id);
	public boolean editKhachHang(int id, String value, int columnPosition);
}
