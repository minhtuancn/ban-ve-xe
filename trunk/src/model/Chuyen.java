package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.ChuyenDAO;

public class Chuyen {
	private long idChuyen;
	private Tuyen tuyen;
	private String gioKhoiHanh;
	private Xe xe;
	private String benXuatPhat;
	private int gia;
	private boolean chuaKhoiHanh;
	private List<Ghe> danhSachGheNgoi;
	private ChuyenDAO chuyenDAO;
	
	//tương tác database
	public Chuyen(){
		chuyenDAO = (ChuyenDAO) new FactoryDAOImp().createDAO(FactoryDao.CHUYEN_DAO);
	}
	public Chuyen getChuyen(long id){
		return chuyenDAO.getChuyen(id);
	}
	public Chuyen getChuyen(long id, Tuyen tuyen){
		return chuyenDAO.getChuyen(id, tuyen);
	}
	public String getTenChuyen(long idVe){
		return chuyenDAO.getTenChuyen(idVe);
	}
	public List<Chuyen> getAllChuyen(Tuyen tuyen, Date ngayDi){
		return chuyenDAO.getAllChuyen(tuyen, ngayDi);
	}
	public int addChuyen(Tuyen tuyen, String gioKhoiHanh, long idXe, String benXuatPhat, int gia){
		return chuyenDAO.addChuyen(tuyen, gioKhoiHanh, idXe, benXuatPhat, gia);
	}
	public boolean deleteChuyen(int id){
		return chuyenDAO.deleteChuyen(id);
	}
	public boolean editChuyen(int id, String value, int columnPosition){
		return chuyenDAO.editChuyen(id, value, columnPosition);
	}
//
	public Chuyen(long idChuyen, Tuyen tuyen, String gioKhoiHanh, Xe xe, String benXuatPhat, int gia) {
		this.idChuyen = idChuyen;
		this.tuyen = tuyen;
		this.gioKhoiHanh = gioKhoiHanh;
		this.xe = xe;
		this.benXuatPhat = benXuatPhat;
		this.chuaKhoiHanh = false;
		this.gia = gia;
		this.danhSachGheNgoi = new ArrayList<>();
		setGhe(xe.getSoGhe());
	}

	public void setGhe(int n) {
		for (int i = 1; i <= n; i++) {
			if (i < 6)
				danhSachGheNgoi.add(new Ghe(i, i, (byte) 2));

			else
				danhSachGheNgoi.add(new Ghe(i, i, (byte) 0));
		}
	}

	public Tuyen getTuyen() {
		return tuyen;
	}

	public void setTuyen(Tuyen tuyen) {
		this.tuyen = tuyen;
	}

	public String getGioKhoiHanh() {
		return gioKhoiHanh;
	}

	public void setGioKhoiHanh(String gioKhoiHanh) {
		this.gioKhoiHanh = gioKhoiHanh;
	}

	public Xe getXe() {
		return xe;
	}

	public void setXe(Xe xe) {
		this.xe = xe;
	}

	public String getBenXuatPhat() {
		return benXuatPhat;
	}

	public void setBenXuatPhat(String benXuatPhat) {
		this.benXuatPhat = benXuatPhat;
	}

	public boolean isChuaKhoiHanh() {
		return chuaKhoiHanh;
	}

	public void setChuaKhoiHanh(boolean chuaKhoiHanh) {
		this.chuaKhoiHanh = chuaKhoiHanh;
	}

	public List<Ghe> getDanhSachGheNgoi() {
		return danhSachGheNgoi;
	}

	public void setDanhSachGheNgoi(List<Ghe> danhSachGheNgoi) {
		this.danhSachGheNgoi = danhSachGheNgoi;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public String getLoaiGhe() {
		return xe.getLoaiGhe();
	}

	public int getSLGheChuaDat() {
		int sum = 0;
		for (Ghe g : danhSachGheNgoi) {
			if (g.getTrangThai() == Ghe.CHUA_DAT)
				sum++;
		}
		return sum;
	}

	public int getLoaiXe() {
		return xe.getSoGhe();
	}
	public Date getNgayKhoiHanh(){
		return tuyen.getNgayDi();
	}
	public String getTuyenXe(){
		return tuyen.getTuyenXe();
	}
	public Ghe getGhe(int i){
		return danhSachGheNgoi.get(i);
	}
	/**
	 * @return the idChuyen
	 */
	public long getIdChuyen() {
		return idChuyen;
	}
	
	
}
