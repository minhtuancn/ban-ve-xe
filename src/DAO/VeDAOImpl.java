package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.DatVe;
import model.ThongTinVe;
import model.Ve;

public class VeDAOImpl implements VeDAO{
	static List<ThongTinVe> listVe;
	@Override
	public List<ThongTinVe> getVe(String maVe) {
		for (ThongTinVe v : listVe) {
			if(v.getMaVe().equals(maVe))
				 listVe.add(v);
		}
		return listVe;
	}

	@Override
	public List<ThongTinVe> getAllVe() {
		if(listVe == null){
			listVe = new ArrayList<>();
			
			listVe.add(new ThongTinVe("1", "Tay Ninh-An Suong", "aaaaa", new Date(), null, true, true, new Date()));
			listVe.add(new ThongTinVe("2", "Tay Ninh-An Suong", "aaaaa", new Date(), null, true, false, new Date()));
			listVe.add(new ThongTinVe("3", "Tay Ninh-An Suong", "aaaaa", new Date(), null, false, true, new Date()));
			listVe.add(new ThongTinVe("4", "Binh Thuan-An Suong", "aaaaa", new Date(), null, false, true, new Date()));
			listVe.add(new ThongTinVe("5", "Khanh Hoa-An Suong", "aaaaa", new Date(), null, true, true, new Date()));
		}
		return listVe;
	}

}
