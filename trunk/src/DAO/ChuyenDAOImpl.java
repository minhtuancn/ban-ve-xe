package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.ConnectionPool;
import model.Chuyen;
import model.DiaDiem;
import model.Tuyen;
import model.Xe;

public class ChuyenDAOImpl implements ChuyenDAO {
	private TuyenDAO tuyenDAO;
	private XeDAO xeDAO;
	
	public ChuyenDAOImpl() {
		this.tuyenDAO =new TuyenDAOImpl();
		this.xeDAO = new XeDAOImpl();
	}

	@Override
	public Chuyen getChuyen(long id) {
		Connection con = ConnectionPool.getInstance().getConnection();
		Chuyen chuyen = null;
		String sql1 = "SELECT idTuyen,benxuatphat,giokhoihanh,gia,idxe FROM chuyen WHERE idchuyen = ?";
		PreparedStatement pre= null;
		ResultSet res;
		try {
			pre = con.prepareStatement(sql1);
			pre.setLong(1, id);
			res = pre.executeQuery();
			while (res.next()) {
					chuyen = new Chuyen(res.getLong("idchuyen"),tuyenDAO.getTuyen(res.getLong("idTuyen")), res.getString("giokhoihanh"),xeDAO.getXe(res.getLong("idxe")), res.getString("benxuatphat"), res.getInt("gia"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return chuyen;
	}

	@Override
	public List<Chuyen> getAllChuyen(Tuyen tuyen) {
		ArrayList<Chuyen> list = new ArrayList<Chuyen>();
		Connection con = ConnectionPool.getInstance().getConnection();
		Chuyen chuyen = null;
		String sql1 = "SELECT idChuyen FROM chuyen WHERE idtuyen = ?";
		PreparedStatement pre= null;
		ResultSet res;
		try {
			pre= con.prepareStatement(sql1);
			pre.setLong(1,tuyen.getIdTuyen());
			res = pre.executeQuery();
			while(res.next()){
				list.add(getChuyen(res.getLong("")))
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
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
