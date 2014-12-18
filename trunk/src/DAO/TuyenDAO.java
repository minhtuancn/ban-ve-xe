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
	
	/**
	 * Phương thức thêm 1 tuyến đi dựa vào id điểm đi và id điểm đến 
	 * @param diemDi: địa điểm đi
	 * @param diemDen
	 * @return là -1 nếu không thêm được do lỗi, là -2 đã tồn tại tuyến, là id tuyến nếu thêm thành công 
	 */
	public long addTuyen(long diemDi, long diemDen);
	/**
	 * Phương thức xóa 
	 * @param id
	 * @return là -1 nếu xóa ko được do lỗi, -2 nếu xóa ko được do đã tồn tại trong bảng phân công, là 1 nếu xóa thành công
	 */
	public int deleteTuyen(long id);
	public boolean editTuyen(int id, String value, int columnPosition);
}	
