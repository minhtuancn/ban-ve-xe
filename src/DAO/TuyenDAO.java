package DAO;

import model.Tuyen;

public interface TuyenDAO {
	/**
	 * Phương thức rút trích tuyến đi dựa vào địa điểm đi và địa điểm đến
	 * @param diemDi: địa điểm đi
	 * @param diemDen: địa điểm đến
	 * @return: tuyến xe
	 */
	public Tuyen getTuyen(String diemDi, String  diemDen);
}	
