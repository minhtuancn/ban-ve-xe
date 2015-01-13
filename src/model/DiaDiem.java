package model;

import java.io.Serializable;
import java.util.List;


public class DiaDiem implements Comparable<DiaDiem>, Serializable{
	private static final long serialVersionUID = 1L;
	private long idDiaDiem;
	private String tenDiaDiem;
	
	public DiaDiem(long idDiaDiem, String tenDiaDiem) {
		this.idDiaDiem = idDiaDiem;
		this.tenDiaDiem = tenDiaDiem;
	}
	public DiaDiem(String tenDiaDiem){
		idDiaDiem = 1000;
		this.tenDiaDiem = tenDiaDiem;
	}
	public long getIdDiaDiem() {
		return idDiaDiem;
	}
	public void setIdDiaDiem(int idDiaDiem) {
		this.idDiaDiem = idDiaDiem;
	}
	public String getTenDiaDiem() {
		return tenDiaDiem;
	}
	public void setTenDiaDiem(String tenDiaDiem) {
		this.tenDiaDiem = tenDiaDiem;
	}
	@Override
	public String toString() {
		return this.tenDiaDiem;
	}
	@Override
	public int compareTo(DiaDiem o) {
		return this.tenDiaDiem.compareTo(o.tenDiaDiem);
	}
	
}
