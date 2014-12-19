package DAO;

import factory.dao.DAO;
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import model.Xe;

public interface XeDAO extends DAO{
	FactoryDao factoryDao = new FactoryDAOImp();
	public abstract Xe getXe(long idXe);
}
