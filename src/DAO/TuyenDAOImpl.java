package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Chuyen;
import model.DiaDiem;
import model.Tuyen;
import model.Xe;

public class TuyenDAOImpl implements TuyenDAO {

	@Override
	public Tuyen getTuyen(String diemDi, String diemDen) {
		DiaDiem diemDii = new DiaDiem(1, "Ho Chi Minh");
		DiaDiem diemDeen = new DiaDiem(2, "Nha Trang");
		Date ngayDi = new Date();
		Tuyen tuyen = new Tuyen(diemDii, diemDeen, ngayDi);
		Xe xe16 = new Xe("1234", "ghe ngoi", 15);
		Xe xe45 = new Xe("1235", "ghe ngoi", 45);
		
		Chuyen chuyen1 = new Chuyen(tuyen, "8:00", xe16, "HCM", 500000);
		Chuyen chuyen2 = new Chuyen(tuyen, "8:05", xe45, "HCM", 500000);
		Chuyen chuyen3 = new Chuyen(tuyen, "8:10", xe45, "HCM", 500000);
		Chuyen chuyen4 = new Chuyen(tuyen, "8:15", xe16, "HCM", 500000);
		
		tuyen.add(chuyen1);
		tuyen.add(chuyen2);
		tuyen.add(chuyen3);
		tuyen.add(chuyen4);
		return tuyen;
	}

}