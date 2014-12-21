package model;


public class Xe {
	private long idXe;
	private String bienSoXe;
	private String loaiGhe;
	private int soGhe;
	
	public Xe(long idXe,String bienSoXe, String loaiGhe, int soGhe) {
		this.idXe = idXe;
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
	public long getIdXe() {
		return idXe;
	}
	public void setIdXe(long idXe) {
		this.idXe = idXe;
	}

}
