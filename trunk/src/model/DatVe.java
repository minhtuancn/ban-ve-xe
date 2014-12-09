package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DatVe {
	private Date ngayDatVe;
	private Chuyen chuyen;
	private List<Ghe> danhsachGheDat;
	public DatVe(Chuyen chuyen) {
		this.chuyen = chuyen;
		this.ngayDatVe = new Date();
		this.danhsachGheDat = new ArrayList<>();
	}
	public String getTenGhe(){
		String res = "";
		int n = danhsachGheDat.size();
		for (int i = 0; i < n - 1; i++) {
			res += danhsachGheDat.get(i).getSoGhe() + ", ";
		}
		if(danhsachGheDat.size() > 0)
			res += danhsachGheDat.get(n-1).getSoGhe();
		return res;
	}
	public int getTongTien(){
		return chuyen.getGia()*danhsachGheDat.size();
	}
	public int getSoLuongGhe(){
		return danhsachGheDat.size();
	}
	public Date getNgayDatVe() {
		return ngayDatVe;
	}
	public void setNgayDatVe(Date ngayDatVe) {
		this.ngayDatVe = ngayDatVe;
	}
	public Chuyen getChuyen() {
		return chuyen;
	}
	public void setChuyen(Chuyen chuyen) {
		this.chuyen = chuyen;
	}
	public String getTuyenXe(){
		return chuyen.getTuyenXe();
	}
	public Date getNgayKhoiHanh(){
		return chuyen.getNgayKhoiHanh();
	}
	public String getGioKhoiHanh(){
		return chuyen.getGioKhoiHanh();
	}
	public String getBenXuatPhat(){
		return chuyen.getBenXuatPhat();
	}
	public int getGia(){
		return chuyen.getGia();
	}
	
	public List<Ghe> getDanhsachGheDat() {
		return danhsachGheDat;
	}
	public void addGhe(int i){
		danhsachGheDat.add(chuyen.getGhe(i));
		Collections.sort(danhsachGheDat);
	}
	public void removeGhe(int i){
		danhsachGheDat.remove(chuyen.getGhe(i));
	}
	public void addGhe(Ghe ghe){
		danhsachGheDat.add(ghe);
		Collections.sort(danhsachGheDat);
	}
}
