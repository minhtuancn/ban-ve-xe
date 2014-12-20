package DAO;

import java.util.List;

import factory.dao.DAO;
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import model.DatVe;
import model.Ghe;

public interface GheDAO extends DAO{
	FactoryDao factoryDao = new FactoryDAOImp();
	public List<Ghe> getAllGhe(long idChuyen);
	public String setGiuCho(DatVe datVe);
	public List<Ghe> getGheOfVe(long idVe);
}
