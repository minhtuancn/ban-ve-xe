package DAO;

import java.util.List;

import factory.dao.DAO;
import model.DiaDiem;
import model.KhachHang;
import model.Ve;

public interface KhachHangDAO extends DAO{
	public KhachHang checkLogIn(String user, String password);
	public KhachHang getKhachHang(String sdt);
	public KhachHang getKhachHang(long id);
	public List<KhachHang> getAllKhachHang();
	/**
	 * 
	 * @param tenKH
	 * @param sdt
	 * @param cmnd
	 * @param diaChi
	 * @param email
	 * @return là -1 nếu không thêm được do lỗi, là -2 đã tồn
	 *         tại khách hàng, là id tuyến nếu thêm thành công
	 */
	public long addKhachHang(String tenKH, String sdt, String cmnd, String diaChi, String email);
	public long addKhachHang(KhachHang kh);
	public List<KhachHang> searchKhachHang(String maSearch);
	public boolean deleteKhachHang(long id);
	public boolean deleteKhachHang(KhachHang kh);
	public boolean editKhachHang(long idKH, String value, int columnPosition);
}
