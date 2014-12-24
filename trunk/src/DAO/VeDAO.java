package DAO;

import java.util.Date;
import java.util.List;

import factory.dao.DAO;
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import model.Ve;

public interface VeDAO extends DAO {
	FactoryDao factoryDao = new FactoryDAOImp();

	public List<Ve> getVe(String maVe);

	/**
	 * danh cho khach hang
	 * 
	 * @return
	 */
	public List<Ve> getAllVe(long idKhachHang);

	/**
	 * danh cho admin, khach hang
	 */
	public List<Ve> searchVe(String maSearch);
	
	public void deleteVe(Ve ve);
	public void deleteVe(String maVe);
	
	public Ve timVeOfMaVe(String maVe);

//	public String addVe( String ghiChu, String maVe, Date ngayDat,
//			Date thoiHanThanhToan,long idChuyen,
//			long idKhachHang);
	public String addVe(Ve ve);
	/**
	 * Kiểm tra 1 mã vé đã sử dụng hay chưa
	 * @param maVe
	 * @return true nếu đã tồn tài, ngược lại false
	 */
	public boolean checkMaVe(String maVe);
}
