package DAO;

import java.util.List;

import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import model.ThongTinVe;
import model.Ve;

public interface VeDAO {
	FactoryDao factoryDao = new FactoryDAOImp();
	
	public List<ThongTinVe> getVe(String maVe);
	/**
	 * danh cho khach hang
	 * @return
	 */
	public List<Ve> getAllVe(long idKhachHang);
	
	/**
	 * danh cho admin, khach hang
	 */
	public List<Ve> searchVe(String maSearch);
}
