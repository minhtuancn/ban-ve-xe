package factory.dao;

public interface FactoryDao {
	public static final int TUYEN_DAO = 1;
	public static final int CHUYEN_DAO = 2;
	public static final int XE_DAO = 3;
	public static final int GHE_DAO = 4;
	public static final int VE_DAO =5;
	public static final int DIA_DIEM_DAO =6;
	public static final int KHACH_HANG_DAO =7;
	public static final int THANH_TOAN_DAO =8;
	public static final int TAI_KHOAN_DAO =9;
	public static final int NHAN_VIEN_DAO =10;
	public DAO createDAO(int type);
}
