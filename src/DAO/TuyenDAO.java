package DAO;

import java.util.List;

import model.DiaDiem;
import model.Tuyen;

public interface TuyenDAO {
	/**
	 * Phương thức rút trích tuyến đi dựa vào địa điểm đi và địa điểm đến
	 * @param diemDi: địa điểm đi
	 * @param diemDen: địa điểm đến
	 * @return: tuyến xe
	 */
	public Tuyen getTuyen(String diemDi, String diemDen, String date);
	public List<Tuyen> getAllTuyen();
	public List<DiaDiem> getAllDiaDiem();
	public int addTuyen(String diemDi, String diemDen);
	public boolean deleteTuyen(int id);
	public boolean editTuyen(int id, String value, int columnPosition);
}	
