package DAO;

import factory.dao.DAO;
import model.TaiKhoan;

public interface TaiKhoanDAO extends DAO{
	public long addTaiKhoan(TaiKhoan tk);
	public boolean checkUser(String user);
	public long upDateMatKhau(String tk);
}
