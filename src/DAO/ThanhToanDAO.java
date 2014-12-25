package DAO;

import model.ThanhToan;
import factory.dao.DAO;

public interface ThanhToanDAO extends DAO{

	public ThanhToan getThanhToan(long idve );
	public int deleteThanhToan(String maVe);
}
