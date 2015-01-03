package DAO;

import factory.dao.DAO;
import model.NhanVien;

public interface NhanVienDAO extends DAO{
	
	
	public NhanVien checkLoginAdmin(String name, String pass);
}
