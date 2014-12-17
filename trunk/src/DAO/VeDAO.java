package DAO;

import java.util.List;

import model.ThongTinVe;
import model.Ve;

public interface VeDAO {
	public List<ThongTinVe> getVe(String maVe);
	public List<ThongTinVe> getAllVe();
}
