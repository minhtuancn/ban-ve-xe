package model;

public class Xe {
	private String bienSoXe;
	private String loaiGhe;
	private int soGhe;
	public Xe(String bienSoXe, String loaiGhe, int soGhe) {
		this.bienSoXe = bienSoXe;
		this.loaiGhe = loaiGhe;
		this.soGhe = soGhe;
	}
	public String getBienSoXe() {
		return bienSoXe;
	}
	public void setBienSoXe(String bienSoXe) {
		this.bienSoXe = bienSoXe;
	}
	public String getLoaiGhe() {
		return loaiGhe;
	}
	public void setLoaiGhe(String loaiGhe) {
		this.loaiGhe = loaiGhe;
	}
	public int getSoGhe() {
		return soGhe;
	}
	public void setSoGhe(int soGhe) {
		this.soGhe = soGhe;
	}
	
}
