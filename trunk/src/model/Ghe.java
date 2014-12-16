package model;
public class Ghe implements Comparable<Ghe>{
	private long idGhe;
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

	public long getIdGhe() {
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
		return (int) (idGhe - o.idGhe);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + idGhe);
		result = prime * result + soGhe;
		result = prime * result + trangThai;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ghe other = (Ghe) obj;
		if (idGhe != other.idGhe)
			return false;
		if (soGhe != other.soGhe)
			return false;
		if (trangThai != other.trangThai)
			return false;
		return true;
	}
	
	
	
	
}
