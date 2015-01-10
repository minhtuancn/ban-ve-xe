package model;

import java.util.ArrayList;
import java.util.List;

public class NhanVien {
	public static final int ADMIN = 1;
	public static final int QUAN_LI = 2;
	public static final int NHAN_VIEN = 3;
	
	private long idNhanVien;
	private String hoTen;
	private TaiKhoan taiKhoan;
	private List<String> quyen;
	public NhanVien(long idNhanVien, String hoTen, TaiKhoan taiKhoan) {
		super();
		this.idNhanVien = idNhanVien;
		this.hoTen = hoTen;
		this.taiKhoan = taiKhoan;
		this.quyen = new ArrayList<>();
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

	public List<String> getQuyen() {
		return quyen;
	}

	public void setQuyen(List<String> quyen) {
		this.quyen = quyen;
	}

	public void setIdNhanVien(long idNhanVien) {
		this.idNhanVien = idNhanVien;
	}
	
	
	
}
