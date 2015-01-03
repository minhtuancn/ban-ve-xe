package factory.dao;

import DAO.ChuyenDAOImpl;
import DAO.DiaDiemDAOImpl;
import DAO.GheDAOImpl;
import DAO.KhachHangDAOIml;
import DAO.NhanVienDAOImpl;
import DAO.TaiKhoanDAOImpl;
import DAO.ThanhToanDAOIpml;
import DAO.TuyenDAOImpl;
import DAO.VeDAOImpl;
import DAO.XeDAOImpl;

public class FactoryDAOImp implements FactoryDao{

	@Override
	public DAO createDAO(int type) {
		switch (type) {
		case TUYEN_DAO:
			return new TuyenDAOImpl();
		case CHUYEN_DAO:
			return new ChuyenDAOImpl();
		case XE_DAO:
			return new XeDAOImpl();
		case GHE_DAO:
			return new GheDAOImpl();
		case VE_DAO:
			return new VeDAOImpl();
		case DIA_DIEM_DAO:
			return new DiaDiemDAOImpl();
		case KHACH_HANG_DAO:
			return new KhachHangDAOIml();
		case THANH_TOAN_DAO:
			return new ThanhToanDAOIpml();
		case TAI_KHOAN_DAO:
			return new TaiKhoanDAOImpl();
		case NHAN_VIEN_DAO:
			return new NhanVienDAOImpl();
		default:
			break;
		}
		return null;
	}

}
