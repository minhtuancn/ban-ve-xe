package DAO;

import java.util.List;

import model.Chuyen;
import model.DiaDiem;
import model.Tuyen;
import model.Xe;

public interface DiaDiemDAO {
	public DiaDiem getDiaDiem(long id);
	public List<DiaDiem> getAllDiaDiem();
	public int addDiaDiem(String tenDiaDiem);
	public boolean deleteDiaDiem(int id);
	public boolean editDiaDiem(int id, String value);
}
