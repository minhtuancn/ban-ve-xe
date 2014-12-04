package model;
public class Ghe implements Comparable<Ghe>{
	private int idGhe;
	private int soGhe;
	private byte trangThai;
	//
	public static byte CHUA_DAT = 0;
	public static byte DANG_GIU = 1;
	public static byte DA_DAT = 2;
	
	public Ghe(int idGhe, int soGhe, byte trangThai) {
		this.idGhe = idGhe;
		this.soGhe = soGhe;
		this.trangThai = trangThai;
	}

	public int getIdGhe() {
		return idGhe;
	}

	public void setIdGhe(int idGhe) {
		this.idGhe = idGhe;
	}

	public int getSoGhe() {
		return soGhe;
	}

	public void setSoGhe(int soGhe) {
		this.soGhe = soGhe;
	}

	public byte getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(byte trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public int compareTo(Ghe o) {
		return idGhe - o.idGhe;
	}
	
	
	
	
	
}
