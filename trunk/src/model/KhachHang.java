package model;
import java.util.ArrayList;
import java.util.List;

import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
public abstract class KhachHang  {
	private long idKhachHang;
	private String tenKhachHang;
	private String sdt;
	private String cmnd;
	private String diaChi;
	private String email;
	private Ve veDi;
	private Ve veVe;
	private List<Ve> danhSachVeDaDat;
	
	public KhachHang(){
	}
	
	public KhachHang(long idKH, String tenKhachHang, String sdt, String cmnd, String diaChi, String email){
		this.idKhachHang = idKH;
		this.tenKhachHang = tenKhachHang;
		this.sdt = sdt;
		this.cmnd = cmnd;
		this.diaChi = diaChi;
		this.email = email;
		danhSachVeDaDat = new ArrayList<>();
	}
	
	public KhachHang(String tenKhachHang, String sdt, String cmnd, String diaChi, String email){
		this.tenKhachHang = tenKhachHang;
		this.sdt = sdt;
		this.cmnd = cmnd;
		this.diaChi = diaChi;
		this.email = email;
		danhSachVeDaDat = new ArrayList<>();
	}
	
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Ve getVeDi() {
		return veDi;
	}
	public void setVeDi(Ve veDi) {
		this.veDi = veDi;
	}
	public Ve getVeVe() {
		return veVe;
	}
	public void setVeVe(Ve veVe) {
		this.veVe = veVe;
	}
	public List<Ve> getDanhSachVeDaDat() {
		return danhSachVeDaDat;
	}
	public void setDanhSachVeDaDat(List<Ve> danhSachVeDaDat) {
		this.danhSachVeDaDat = danhSachVeDaDat;
	}

}
