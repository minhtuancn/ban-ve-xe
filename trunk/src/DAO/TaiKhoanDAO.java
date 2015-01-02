package DAO;

import factory.dao.DAO;
import model.TaiKhoan;

public interface TaiKhoanDAO extends DAO{
	public TaiKhoan getTaiKhoan(long idTk);
	public long addTaiKhoan(TaiKhoan tk);
	public boolean checkUser(String user);
	public long upDateMatKhau(String tk, String pass);
	public TaiKhoan layMatKhau(String tk);
	public boolean kichHoatTaiKhoan(long idTk);
}
