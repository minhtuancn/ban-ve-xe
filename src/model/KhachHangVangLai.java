package model;
public class KhachHangVangLai extends KhachHang  {
	public KhachHangVangLai() {
		super();
	}
	

	public KhachHangVangLai(String tenKhachHang, String sdt, String cmnd,
			String diaChi, String email) {
		super(tenKhachHang, sdt, cmnd, diaChi, email);
		// TODO Auto-generated constructor stub
	}
	public KhachHangVangLai(long idKH, String tenKhachHang, String sdt, String cmnd, String diaChi, String email){
		super(idKH, tenKhachHang, sdt, cmnd, diaChi, email);
		}
}
