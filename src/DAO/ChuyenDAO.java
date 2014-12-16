package DAO;

import java.util.List;

import model.Chuyen;
import model.Tuyen;
import model.Xe;

public interface ChuyenDAO {
	public Chuyen getChuyen(String gioKhoiHanh, Tuyen tuyen, String benXuatPhat);
	public List<Chuyen> getAllChuyen(Tuyen tuyen);
//	public List<DiaDiem> getAllDiaDiem();
	public int addChuyen(Tuyen tuyen, String gioKhoiHanh, Xe xe, String benXuatPhat, int gia);
	public boolean deleteChuyen(int id);
	public boolean editChuyen(int id, String value, int columnPosition);
}
