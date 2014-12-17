package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Chuyen;
import model.DiaDiem;
import model.Tuyen;
import model.Xe;

public class ChuyenDAOImpl implements ChuyenDAO {

	static List<Chuyen> list = new ArrayList<Chuyen>();
	
	@Override
	public Chuyen getChuyen(String gioKhoiHanh, Tuyen tuyen, String benXuatPhat) {
		Chuyen chuyen = null;
		for (Chuyen c : list) {
			if(c.getGioKhoiHanh().equalsIgnoreCase(gioKhoiHanh) && c.getBenXuatPhat().equalsIgnoreCase(benXuatPhat) && c.getTuyenXe().equalsIgnoreCase(tuyen.getTuyenXe()))
				chuyen = c;
		}
		return chuyen;
	}

	@Override
	public List<Chuyen> getAllChuyen(Tuyen tuyen) {
		if(list.size()==0){
		Xe xe16 = new Xe("1234", "ghe ngoi", 15);
		Xe xe45 = new Xe("1235", "ghe ngoi", 45);

		Chuyen chuyen1 = new Chuyen(tuyen, "8:00", xe16, tuyen.getDiemDi().getTenDiaDiem(), 500000);
		Chuyen chuyen2 = new Chuyen(tuyen, "8:05", xe45, tuyen.getDiemDi().getTenDiaDiem(), 500000);
		Chuyen chuyen3 = new Chuyen(tuyen, "8:10", xe45, tuyen.getDiemDi().getTenDiaDiem(), 500000);
		Chuyen chuyen4 = new Chuyen(tuyen, "8:15", xe16, tuyen.getDiemDi().getTenDiaDiem(), 500000);
	
		list.add(chuyen4);
		list.add(chuyen3);
		list.add(chuyen2);
		list.add(chuyen1);
		}
		
		return list;
	}

	@Override
	public int addChuyen(Tuyen tuyen, String gioKhoiHanh, Xe xe,
			String benXuatPhat, int gia) {
		list.add(new Chuyen(tuyen, gioKhoiHanh, xe, benXuatPhat, gia));
		return 1;
	}

	@Override
	public boolean deleteChuyen(int id) {
		list.remove(id);
		System.out.println(id);
		return true;
	}

	@Override
	public boolean editChuyen(int id, String value, int columnPosition) {
		Chuyen c = list.get(id);
		Xe xe = null;
		System.out.println(columnPosition);
		switch (columnPosition) {
		case 0:
			c.setGioKhoiHanh(value);;
			break;
		case 1:
			if(value.equalsIgnoreCase("45"))
				xe = new Xe("", "", 45);
			else 
				xe = new Xe("", "", 16);
			c.setXe(xe);
			break;
		case 2:
			c.setBenXuatPhat(value);
			break;
		case 3:
			c.setGia(Integer.parseInt(value));
			break;
		default:
			break;
		}
		return true;
	}

}
