package model;

public class TaiKhoan {
	private long idTaiKhoan;
	private String tenTK;
	private String matKhau;
	private boolean daKichHoat;
	public TaiKhoan(String tenTK, String matKhau, boolean daKichHoat) {
		this.tenTK = tenTK;
		this.matKhau = matKhau;
		this.daKichHoat = daKichHoat;
	}
	/**
	 * @return the idTaiKhoan
	 */
	public long getIdTaiKhoan() {
		return idTaiKhoan;
	}
	/**
	 * @param idTaiKhoan the idTaiKhoan to set
	 */
	public void setIdTaiKhoan(long idTaiKhoan) {
		this.idTaiKhoan = idTaiKhoan;
	}
	/**
	 * @return the tenTK
	 */
	public String getTenTK() {
		return tenTK;
	}
	/**
	 * @param tenTK the tenTK to set
	 */
	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}
	/**
	 * @return the matKhau
	 */
	public String getMatKhau() {
		return matKhau;
	}
	/**
	 * @param matKhau the matKhau to set
	 */
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	/**
	 * @return the daKichHoat
	 */
	public boolean isDaKichHoat() {
		return daKichHoat;
	}
	/**
	 * @param daKichHoat the daKichHoat to set
	 */
	public void setDaKichHoat(boolean daKichHoat) {
		this.daKichHoat = daKichHoat;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TaiKhoan [idTaiKhoan=" + idTaiKhoan + ", tenTK=" + tenTK
				+ ", matKhau=" + matKhau + ", daKichHoat=" + daKichHoat + "]";
	}
	
}
