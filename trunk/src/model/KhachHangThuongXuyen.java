package model;

public class KhachHangThuongXuyen extends KhachHang{
	private TaiKhoan taiKhoan;
	private long soTien;
	public KhachHangThuongXuyen(String tenKhachHang, String sdt, String cmnd, String diaChi, String email, TaiKhoan taiKhoan, long soTien){
		super(tenKhachHang, sdt, cmnd, diaChi, email);
		this.taiKhoan = taiKhoan;
		this.soTien = soTien;
	}
}
