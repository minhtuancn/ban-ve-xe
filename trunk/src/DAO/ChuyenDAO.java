package DAO;

import java.util.List;

import model.Chuyen;
import model.Tuyen;
import model.Xe;

public interface ChuyenDAO {
	/**
	 * 
	 * @param id
	 * @return: 
	 */
	public Chuyen getChuyen(long id);
	public List<Chuyen> getAllChuyen(Tuyen tuyen);
	public int addChuyen(Tuyen tuyen, String gioKhoiHanh, Xe xe, String benXuatPhat, int gia);
	public boolean deleteChuyen(int id);
	public boolean editChuyen(int id, String value, int columnPosition);
}
