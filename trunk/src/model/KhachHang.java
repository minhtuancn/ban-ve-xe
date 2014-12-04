package model;
import java.util.List;
public abstract class KhachHang  {
	private String tenKhachHang;
	private String sdt;
	private String cmnd;
	private String diaChi;
	private String email;
	private DatVe datVeDi;
	private DatVe datVeKhuHoi;
	private List<Ve> danhSachVeDaDat;
}
