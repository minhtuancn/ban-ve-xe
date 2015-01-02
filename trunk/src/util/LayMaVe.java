package util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.VeDAO;

public class LayMaVe {
	private static LayMaVe instant = new LayMaVe();
	private Set<String> listMaVe;
	private Random random;
	private VeDAO veDAO;
	public static final int SO_KY_TU_MAVE = 6;

	private LayMaVe() {
		listMaVe = new HashSet<>();
		random = new Random();
	}

	public static LayMaVe getInstant() {
		return instant;
	}
/**
 * Phương thức trả về mã vé được tạo ngẫu nhiên và duy nhất.
 * @return 1 mã vé có kiểu dữ liêu String và length = 6.
 */
	public synchronized String getMaVe(int soKyTu) {
		String s = "";
		do {
			s = "";
			for (int i = 0; i < soKyTu; i++) {
				s += random();
			}
			System.out.println("LayMaVe " + s);
		} while (!kiemTraTontaiMaVe(s));
		listMaVe.add(s);
		return s;
	}
	/**
	 * phương thước tạo ngẫu nhiên 1 ký tự char [0..9] hoặc [A..Z]
	 * @return 1 ký tự trong khoản [0..9] hoặc [A..Z]
	 */
	public char random() {
		int i = 0;
		while (!((i >= 48 && i <= 57) || (i >= 65 && i <= 90))) {
			i = random.nextInt(50) + 40;
		}
		return (char) i;
	}

	/**
	 * phương thức kiểm tra xem mã vé đã tồn tại hay chưa!
	 * 
	 * @param maVe
	 *            : mã vé cần kiểm tra
	 * @return true: nếu vé chưa tồn tại, false: nếu vé đã tồn tại!
	 */
	public boolean kiemTraTontaiMaVe(String maVe) {
		return checkMaVeDB(maVe) && !listMaVe.contains(maVe);
	}

	/**
	 * phương thức kiểm tra xem mã vé có sử dung được khi so sánh với database
	 * hay không!
	 * 
	 * @param maVe
	 *            : mã vé cần kiểm tra
	 * @return true: nếu vé chưa tồn tại, false: nếu vé đã tồn tại!
	 */
	public boolean checkMaVeDB(String maVe) {
		return !getVeDAO().checkMaVe(maVe);
	
	}
	/**
	 * phương thức thu hồi 1 mã vé không sữ dụng
	 * @param maVe: String mã vé.
	 */
	public void ungetMaVe(String maVe){
		listMaVe.remove(maVe);
	}

	/**
	 * @return the veDAO
	 */
	public VeDAO getVeDAO() {
		veDAO = (VeDAO) (veDAO == null ? new FactoryDAOImp().createDAO(FactoryDao.VE_DAO): veDAO);
		return veDAO;
	}
	
}
