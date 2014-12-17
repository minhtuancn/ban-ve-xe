package model;

import java.util.Date;
import java.util.List;

public class ThongTinVe {
	private String maVe;
	private String chuyen;
	private String ghiChu;
	private Date ngayDatVe;
	private List<Ghe> danhSachGhe;
	private boolean daKhoiHanh;
	private boolean trangThaiThanhToan;
	private Date thoiHanThanhToan;
	public ThongTinVe(String maVe, String chuyen, String ghiChu,
			Date ngayDatVe, List<Ghe> danhSachGhe, boolean daKhoiHanh,
			boolean trangThaiThanhToan, Date thoiHanThanhToan) {
		this.maVe = maVe;
		this.chuyen = chuyen;
		this.ghiChu = ghiChu;
		this.ngayDatVe = ngayDatVe;
		this.danhSachGhe = danhSachGhe;
		this.daKhoiHanh = daKhoiHanh;
		this.trangThaiThanhToan = trangThaiThanhToan;
		this.thoiHanThanhToan = thoiHanThanhToan;
	}
	public String getMaVe() {
		return maVe;
	}
	public void setMaVe(String maVe) {
		this.maVe = maVe;
	}
	public String getChuyen() {
		return chuyen;
	}
	public void setChuyen(String chuyen) {
		this.chuyen = chuyen;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public Date getNgayDatVe() {
		return ngayDatVe;
	}
	public void setNgayDatVe(Date ngayDatVe) {
		this.ngayDatVe = ngayDatVe;
	}
	public List<Ghe> getDanhSachGhe() {
		return danhSachGhe;
	}
	public void setDanhSachGhe(List<Ghe> danhSachGhe) {
		this.danhSachGhe = danhSachGhe;
	}
	public boolean isDaKhoiHanh() {
		return daKhoiHanh;
	}
	public void setDaKhoiHanh(boolean daKhoiHanh) {
		this.daKhoiHanh = daKhoiHanh;
	}
	public boolean isTrangThaiThanhToan() {
		return trangThaiThanhToan;
	}
	public void setTrangThaiThanhToan(boolean trangThaiThanhToan) {
		this.trangThaiThanhToan = trangThaiThanhToan;
	}
	public Date getThoiHanThanhToan() {
		return thoiHanThanhToan;
	}
	public void setThoiHanThanhToan(Date thoiHanThanhToan) {
		this.thoiHanThanhToan = thoiHanThanhToan;
	}
	
	}
