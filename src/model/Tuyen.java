package model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.TuyenDAO;


public class Tuyen {
	private long idTuyen;
	private DiaDiem diemDi;
	private DiaDiem diemDen;
	private Date ngayDi;
	private List<Chuyen> danhSachChuyen;
	private TuyenDAO tuyenDAO;
	
	//tương tác database
	public Tuyen(){
		tuyenDAO = (TuyenDAO) new FactoryDAOImp()
		.createDAO(FactoryDao.TUYEN_DAO);
	}
	
	public Tuyen getTuyen(long idNoiDi,long idNoiDen,Date dateNgayDi){
		return tuyenDAO.getTuyen(idNoiDi,idNoiDen,ngayDi);
	}
	
	public Tuyen getTuyen(long idTuyen){
		return tuyenDAO.getTuyen(idTuyen);
	}

	public List<Tuyen> getAllTuyen(){
		return tuyenDAO.getAllTuyen();
	}
	
	public long addTuyen(long diemDi, long diemDen){
		return tuyenDAO.addTuyen(diemDi, diemDen);
	}
	
	public int deleteTuyen(long idTuyen){
		return tuyenDAO.deleteTuyen(idTuyen);
	}
	
	public int editTuyen(long idTuyen, String value, int columnPosition){
		return tuyenDAO.editTuyen(idTuyen, value, columnPosition);
	}
	//
	
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
	
	public Tuyen(long idtuyen, DiaDiem diemDi, DiaDiem diemDen) {
		this.idTuyen = idtuyen;
		this.diemDi = diemDi;
		this.diemDen = diemDen;
		danhSachChuyen = new ArrayList<>();
	}
	
	public void add(Chuyen chuyen){
		danhSachChuyen.add(chuyen);
	}
	public long getIdTuyen() {
		return idTuyen;
	}
	public void setIdTuyen(long idTuyen) {
		this.idTuyen = idTuyen;
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
