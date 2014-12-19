package DAO;

import java.util.List;

import model.DiaDiem;
import model.Tuyen;

public interface TuyenDAO {
	/**
	 * Phương thức rút trích tuyến đi dựa vào địa điểm đi và
	 * địa điểm đến
	 * 
	 * @param diemDi
	 *            : địa điểm đi
	 * @param diemDen
	 *            : địa điểm đến
	 * @return: tuyến xe
	 */
	public Tuyen getTuyen(String diemDi, String diemDen, String date);
	
	public Tuyen getTuyen(long idTuyen);

	public List<Tuyen> getAllTuyen();

	/**
	 * Phương thức thêm 1 tuyến đi dựa vào id điểm đi và id
	 * điểm đến
	 * 
	 * @param diemDi
	 *            : địa điểm đi
	 * @param diemDen
	 * @return là -1 nếu không thêm được do lỗi, là -2 đã tồn
	 *         tại tuyến, là id tuyến nếu thêm thành công
	 */
	public long addTuyen(long diemDi, long diemDen);

	/**
	 * Phương thức xóa
	 * 
	 * @param id
	 * @return là -1 nếu xóa ko được do lỗi, -2 nếu xóa ko được
	 *         do đã tồn tại trong bảng phân công, là 1 nếu xóa
	 *         thành công
	 */
	public int deleteTuyen(long idTuyen);

	/**
	 * 
	 * @param idTuyen
	 * @param value
	 * @param columnPosition
	 * @return là -1 nếu không tồn tại tuyến, -2 là tuyến sau khi
	 *         update bị trùng, -3 điểm đi trùng điểm đến, 0 nếu
	 *         bị lổi, 1 nếu thành công
	 */
	public int editTuyen(long idTuyen, String value, int columnPosition);
}
