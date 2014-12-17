package DAO;

import java.util.ArrayList;
import java.util.List;

import model.DiaDiem;
import model.KhachHang;
import model.KhachHangThuongXuyen;
import model.KhachHangVangLai;
import model.TaiKhoan;
import model.Tuyen;
import model.Ve;

public class KhachHangDAOIml implements KhachHangDAO{
	private static List<KhachHang> listKhachHang;
	@Override
	public KhachHang checkLogIn(String user, String password) {
		return new KhachHangThuongXuyen("Hoang Nhuoc Quy", "1234567890", "123456", "Tay Ninh", "123@gmail.com", new TaiKhoan("hoangnhuocquy", "123", true), 10000000);
	}

	@Override
	public KhachHang getKhachHang(String sdt) {
		for (KhachHang kh : listKhachHang) {
			if(kh.getSdt().equals(sdt))
				return kh;
		}
		return null;
	
	}

	@Override
	public List<KhachHang> getAllKhachHang() {
		if(listKhachHang == null){
			listKhachHang = new ArrayList<>();
			listKhachHang.add(new KhachHangThuongXuyen("Hoang Nhuoc Quy", "1234567890", "123456", "Tay Ninh", "123@gmail.com"));
			listKhachHang.add(new KhachHangThuongXuyen("a", "123", "1", "abc", "a@gmail.com"));
			listKhachHang.add(new KhachHangThuongXuyen("b", "234", "2", "abcd", "b@gmail.com"));
			listKhachHang.add(new KhachHangThuongXuyen("c", "345", "3", "abce", "c@gmail.com"));
			listKhachHang.add(new KhachHangVangLai("d", "456", "4", "abcf", "d@gmail.com"));
			listKhachHang.add(new KhachHangVangLai("e", "567", "5", "abcg", "e@gmail.com"));
			listKhachHang.add(new KhachHangVangLai("f", "678", "6", "abcgf", "f@gmail.com"));
			
			
			}
			return listKhachHang;
	
	}

	@Override
	public int addKhachHang(String tenKH,String sdt, String cmnd, String diaChi, String email) {
		listKhachHang.add(new KhachHangThuongXuyen(tenKH, sdt, cmnd, diaChi, email));
		listKhachHang.add(new KhachHangVangLai(tenKH, sdt, cmnd, diaChi, email));
		return listKhachHang.size();
	}

	@Override
	public boolean deleteKhachHang(int id) {
		listKhachHang.remove(id);
		return true;
	}

	@Override
	public boolean editKhachHang(int id, String value, int columnPosition) {
		KhachHang kh = listKhachHang.get(id);
		switch (columnPosition) {
		case 0:
			kh.setTenKhachHang(value);
			break;
		case 1:
			kh.setSdt(value);
			break;
		case 2:
			kh.setSdt(value);
			break;
		case 3:
			kh.setCmnd(value);;
			break;
		case 4:
			kh.setDiaChi(value);
			break;
		case 5:
			kh.setEmail(value);
			break;
		default:
			break;
		}
		return true;
	}

}
