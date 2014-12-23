package DAO;

import java.util.List;

import model.Chuyen;
import model.DiaDiem;
import model.Tuyen;
import model.Xe;

public interface DiaDiemDAO {
	public DiaDiem getDiaDiem(long id);
	public List<DiaDiem> getAllDiaDiem();
	/**
	 * 
	 * @param tenDiaDiem
	 * @return -1 nếu thêm không thành công, -2 nếu không tìm thấy địa điểm và trả về iddiadiem nếu thêm thành công
	 */
	public long addDiaDiem(String tenDiaDiem);
	/**
	 * 
	 * @param id
	 * @return -2 nếu không tồn tại, -1 địa điểm đã được sử dụng, -3 lổi server , 1 thành công
	 */
	public int deleteDiaDiem(long id);
	public boolean editDiaDiem(long id, String value);
}
