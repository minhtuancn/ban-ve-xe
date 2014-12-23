package model;

public class KhachHangThuongXuyen extends KhachHang{
	private TaiKhoan taiKhoan;
	private long soTien;
	
	public KhachHangThuongXuyen(long idKH, String tenKhachHang, String sdt, String cmnd, String diaChi, String email, long soTien){
		super(idKH, tenKhachHang, sdt, cmnd, diaChi, email);
		this.soTien = soTien;
		}
	public KhachHangThuongXuyen(long idKH, String tenKhachHang, String sdt, String cmnd, String diaChi, String email){
		super(idKH, tenKhachHang, sdt, cmnd, diaChi, email);
		}
	public KhachHangThuongXuyen(String tenKhachHang, String sdt, String cmnd, String diaChi, String email, TaiKhoan taiKhoan, long soTien){
		super(tenKhachHang, sdt, cmnd, diaChi, email);
		this.taiKhoan = taiKhoan;
		this.soTien = soTien;
	}
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public long getSoTien() {
		return soTien;
	}
	public void setSoTien(long soTien) {
		this.soTien = soTien;
	}
	
	
}
