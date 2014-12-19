package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.ConnectionPool;
import model.DatVe;
import model.DiaDiem;
import model.ThongTinVe;
import model.Ve;

public class VeDAOImpl implements VeDAO{
	 List<ThongTinVe> listVe;
	@Override
	public List<ThongTinVe> getVe(String maVe) {
//		for (ThongTinVe v : listVe) {
//			if(v.getMaVe().equals(maVe))
//				 listVe.add(v);
//		}
		
		return listVe;
	}

	@Override
	public List<ThongTinVe> getAllVe() {
//		listVe = new ArrayList<>();
//		Connection con = ConnectionPool.getInstance().getConnection();
//		String sql = "SELECT diadiem.iddiadiem,diadiem.tendiadiem FROM diadiem";
//		PreparedStatement pre = null;
//		try {
//			pre = con.prepareStatement(sql);
//			ResultSet res = pre.executeQuery();
//			while (res.next()) {
//				listDiaDiem.add(new DiaDiem(res.getLong("iddiadiem"), res
//						.getString("tendiadiem")));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			ConnectionPool.getInstance().closePre(pre);
//			ConnectionPool.getInstance().freeConnection(con);
//		}
			return listVe;
	}

}
