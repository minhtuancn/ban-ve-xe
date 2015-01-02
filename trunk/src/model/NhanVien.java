package model;

public class NhanVien {
	public static final int ADMIN = 1;
	public static final int QUAN_LI = 2;
	public static final int NHAN_VIEN = 3;
	
	private long idNhanVien;
	private String hoTen;
	private TaiKhoan taiKhoan;
	private int chucVu;
	
	public NhanVien(long idNhanVien, String hoTen, TaiKhoan taiKhoan, int chucVu) {
		super();
		this.idNhanVien = idNhanVien;
		this.hoTen = hoTen;
		this.taiKhoan = taiKhoan;
		this.chucVu = chucVu;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public long getIdNhanVien() {
		return idNhanVien;
	}
	
	
	
}
