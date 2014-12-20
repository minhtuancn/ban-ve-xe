package factory.dao;

public interface FactoryDao {
	public static final int TUYEN_DAO = 1;
	public static final int CHUYEN_DAO = 2;
	public static final int XE_DAO = 3;
	public static final int GHE_DAO = 4;
	public static final int VE_DAO =5;
	public static final int DIA_DIEM_DAO =6;
	public DAO createDAO(int type);
}
