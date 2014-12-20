package DAO;

import java.util.Date;
import java.util.List;

import factory.dao.DAO;
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import model.Chuyen;
import model.Tuyen;
import model.Xe;

public interface ChuyenDAO extends DAO{
	FactoryDao factoryDao = new FactoryDAOImp();
	/**
	 * 
	 * @param id
	 * @return: 
	 */
	public Chuyen getChuyen(long id);
	public Chuyen getChuyen(long id, Tuyen tuyen);
	public String getTenChuyen(long idVe);
	
	public List<Chuyen> getAllChuyen(Tuyen tuyen, Date ngayDi);
	public int addChuyen(Tuyen tuyen, String gioKhoiHanh, long idXe, String benXuatPhat, int gia);
	public boolean deleteChuyen(int id);
	public boolean editChuyen(int id, String value, int columnPosition);
}
