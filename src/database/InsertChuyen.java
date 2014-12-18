package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.DiaDiem;
import model.Tuyen;
import DAO.TuyenDAOImpl;

public class InsertChuyen {
	
Connection con = Database.getInstance().getConnection();
public int insertChuyen() throws SQLException{
	PreparedStatement pre = con.prepareStatement("select time from testtime where id=?");
	Date now = new Date();
	Date date = null;
	pre.setLong(1, 3);
	ResultSet res = pre.executeQuery();
	while(res.next()){
		date = res.getTimestamp("time");
	}
	con.close();
	return now.compareTo(date);
}

public static void main(String[] args) throws SQLException {
//	System.out.println(new InsertChuyen().insertChuyen());
	TuyenDAOImpl t = new TuyenDAOImpl();
//	/*Tuyen tuyen = t.getTuyen("", "", "2014-12-31");
//	*/System.out.println(tuyen.getTuyenXe());
//	ArrayList<DiaDiem> tuyen = (ArrayList<DiaDiem>) t.getAllDiaDiem();
//	for (DiaDiem tuyen2 : tuyen) {
//		System.out.println(tuyen2.getTenDiaDiem());
//	}
//	t.addTuyen(7, 6);
	System.out.println(t.editTuyen(2, "7", 1));
}
}
