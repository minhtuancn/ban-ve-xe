package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import DAO.ChuyenDAO;
import DAO.ChuyenDAOImpl;
import DAO.VeDAO;
import factory.dao.DAO;
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;

public class Ve {
	private long idVe;
	private String maVe;
	private Chuyen chuyen;
	private String ghiChu;
	private Date ngayDatVe;
	private List<Ghe> danhSachGhe;
	private boolean daKhoiHanh;
	private boolean trangThaiThanhToan;
	private ThanhToan phuongThucThanhToan;
	private Date thoiHanThanhToan;
	private int soSMS;
	private boolean trangThaiHuyVe;
	private String liDoHuyVe;
	private SimpleDateFormat formats;
	public static final String FORMAT = "dd/MM/yyyy HH:mm";

	public Ve(String maVe, Chuyen chuyen, String ghiChu, Date ngayDatVe,
			List<Ghe> danhsachGhe, boolean daKhoiHanh,
			boolean trangThaiThanhToan, Date thoiHanThanhToan,
			boolean trangThaiHuyVe, String liDoHuyVe) {
		this.maVe = maVe;
		this.chuyen = chuyen;
		this.ghiChu = ghiChu;
		this.ngayDatVe = ngayDatVe;
		this.danhSachGhe = danhsachGhe;
		this.daKhoiHanh = daKhoiHanh;
		this.trangThaiThanhToan = trangThaiThanhToan;
		this.thoiHanThanhToan = thoiHanThanhToan;
		this.trangThaiHuyVe = trangThaiHuyVe;
		this.liDoHuyVe = liDoHuyVe;
	}

	public Ve(String maVe, String ghiChu, Date ngayDatVe,
			List<Ghe> danhSachGhe, boolean daKhoiHanh,
			boolean trangThaiThanhToan, Date thoiHanThanhToan,
			boolean trangThaiHuyVe, String liDoHuyVe) {
		this.maVe = maVe;
		this.ghiChu = ghiChu;
		this.ngayDatVe = ngayDatVe;
		this.danhSachGhe = danhSachGhe;
		this.daKhoiHanh = daKhoiHanh;
		this.trangThaiThanhToan = trangThaiThanhToan;
		this.thoiHanThanhToan = thoiHanThanhToan;
		this.trangThaiHuyVe = trangThaiHuyVe;
		this.liDoHuyVe = liDoHuyVe;
	}

	public Ve(String mave, DatVe datVe, String ghiChu) {
		this.maVe = mave;
		this.chuyen = datVe.getChuyen();
		this.ghiChu = ghiChu;
		this.ngayDatVe = new Date();
		this.danhSachGhe = datVe.getDanhsachGheDat();
		this.daKhoiHanh = false;
		this.trangThaiThanhToan = false;
		this.thoiHanThanhToan = new Date();
		formats = new SimpleDateFormat(FORMAT);
	}

	public String getNgayDatVe() {
		return formats.format(this.ngayDatVe);
	}

	public String getMaVe() {
		return maVe;
	}

	public void setMaVe(String maVe) {
		this.maVe = maVe;
	}

	public String getTuyenXe() {
		if (chuyen != null)
			return chuyen.getTuyenXe();
		else {
			return ((ChuyenDAO) new FactoryDAOImp()
					.createDAO(FactoryDao.CHUYEN_DAO)).getTenChuyen(idVe);
		}
	}

	public boolean isTrangThaiThanhToan() {
		return trangThaiThanhToan;
	}

	public void setTrangThaiThanhToan(boolean trangThaiThanhToan) {
		this.trangThaiThanhToan = trangThaiThanhToan;
	}

	public String getNgayKhoiHanh() {
		return formats.format(chuyen.getNgayKhoiHanh());
	}

	public String getTenGhe() {
		String res = "";
		int n = danhSachGhe.size();
		for (int i = 0; i < n - 1; i++) {
			res += danhSachGhe.get(i).getSoGhe() + ", ";
		}
		if (danhSachGhe.size() > 0)
			res += danhSachGhe.get(n - 1).getSoGhe();
		return res;
	}

	public int getTongTien() {
		return chuyen.getGia() * danhSachGhe.size();
	}

	public int getSoLuongGhe() {
		return danhSachGhe.size();
	}

	public String getThoiHanThanhToan() {
		return formats.format(thoiHanThanhToan);
	}
}
