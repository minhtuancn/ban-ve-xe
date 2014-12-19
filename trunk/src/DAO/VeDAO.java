package DAO;

import java.util.List;

import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import model.ThongTinVe;
import model.Ve;

public interface VeDAO {
	FactoryDao factoryDao = new FactoryDAOImp();
	public List<ThongTinVe> getVe(String maVe);
	public List<ThongTinVe> getAllVe();
}
