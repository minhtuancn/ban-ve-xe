package DAO;

import java.util.List;

import model.Ghe;
import model.Ve;
import factory.dao.DAO;
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;

public interface GheDAO extends DAO{
	FactoryDao factoryDao = new FactoryDAOImp();
	public List<Ghe> getAllGhe(long idChuyen);
	public String setGiuCho(Ve datVe, byte trangThai);
	public String setNonGiuCho(Ve datVe);
	public List<Ghe> getGheOfVe(long idVe);
}
