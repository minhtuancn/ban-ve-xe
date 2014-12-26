package DAO;

import model.ThanhToan;
import factory.dao.DAO;

public interface ThanhToanDAO extends DAO{

	public ThanhToan getThanhToan(String mave);
	public int deleteThanhToan(String maVe);
}
