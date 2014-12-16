package DAO;

import java.util.ArrayList;
import java.util.List;

import model.DiaDiem;
import model.Tuyen;

public class DiaDiemDAOImpl implements DiaDiemDAO {
	private static List<DiaDiem> listDiaDiem;

	@Override
		public DiaDiem getDiaDiem(String tenDiaDiem){
			for (DiaDiem d : listDiaDiem) {
				if(d.getTenDiaDiem().equals(tenDiaDiem))
					return d;
			}
			return null;
		}

	@Override
	public List<DiaDiem> getAllDiaDiem() {
		if(listDiaDiem == null){
			listDiaDiem = new ArrayList();
			listDiaDiem.add(new DiaDiem(1, "Tay Ninh"));
			listDiaDiem.add(new DiaDiem(2, "An Suong"));
			listDiaDiem.add(new DiaDiem(3, "Khanh Hoa"));
			listDiaDiem.add(new DiaDiem(4, "Binh Thuan"));
			listDiaDiem.add(new DiaDiem(5, "Binh Phuoc"));
			}
			return listDiaDiem;
	}

	@Override
	public int addDiaDiem(String tenDiaDiem) {
		listDiaDiem.add(new DiaDiem(tenDiaDiem));
		return listDiaDiem.size();
	}

	@Override
	public boolean deleteDiaDiem(int id) {
		listDiaDiem.remove(id);
		return true;
	}

	@Override
	public boolean editDiaDiem(int id, String value) {
		DiaDiem t = listDiaDiem.get(id);
		t.setTenDiaDiem(value);
		return true;
	}
}
