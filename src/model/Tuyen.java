package model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Tuyen {
	private DiaDiem diemDi;
	private DiaDiem diemDen;
	private Date ngayDi;
	private List<Chuyen> danhSachChuyen;
	public Tuyen(DiaDiem diemDi, DiaDiem diemDen, Date ngayDi) {
		this.diemDi = diemDi;
		this.diemDen = diemDen;
		this.ngayDi = ngayDi;
		danhSachChuyen = new ArrayList<>();
	}
	public Tuyen(DiaDiem diemDi, DiaDiem diemDen){
		this.diemDi = diemDi;
		this.diemDen = diemDen;
	}
	public void add(Chuyen chuyen){
		danhSachChuyen.add(chuyen);
	}
	public DiaDiem getDiemDi() {
		return diemDi;
	}
	public void setDiemDi(DiaDiem diemDi) {
		this.diemDi = diemDi;
	}
	public DiaDiem getDiemDen() {
		return diemDen;
	}
	public void setDiemDen(DiaDiem diemDen) {
		this.diemDen = diemDen;
	}
	public Date getNgayDi() {
		return ngayDi;
	}
	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}
	public List<Chuyen> getDanhSachChuyen() {
		return danhSachChuyen;
	}
	public void setDanhSachChuyen(List<Chuyen> danhSachChuyen) {
		this.danhSachChuyen = danhSachChuyen;
	}
	public String getTuyenXe(){
		return diemDi.toString() +" - " +  diemDen.toString();
	}
	
}
