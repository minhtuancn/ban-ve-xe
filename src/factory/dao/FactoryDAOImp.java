package factory.dao;

import DAO.ChuyenDAOImpl;
import DAO.GheDAOImpl;
import DAO.TuyenDAOImpl;
import DAO.XeDAOImpl;

public class FactoryDAOImp implements FactoryDao{

	@Override
	public DAO createDAO(int type) {
		switch (type) {
		case TUYEN_DAO:
			return new TuyenDAOImpl();
		case CHUYEN_DAO:
			return new ChuyenDAOImpl();
		case XE_DAO:
			return new XeDAOImpl();
		case GHE_DAO:
			return new GheDAOImpl();
		default:
			break;
		}
		return null;
	}

}