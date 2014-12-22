package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import DAO.VeDAO;
import DAO.VeDAOImpl;

public class TestDatabase {
	Connection con;
	String user = "root";
	String pass = "vertrigo";

	public TestDatabase() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/banvexe", user, pass);
	}

	public void inserDate(Date date) throws SQLException {
		PreparedStatement pre = con
				.prepareStatement("insert into testtime (time) value (?)");
		con.setAutoCommit(false);
//		PreparedStatement pre2 = con
//				.prepareStatement("select time from testtime where id=?");

		date.setTime(date.getTime() + 600 * 1000);
		pre.setTimestamp(1, new Timestamp(date.getTime()));
		// pre.setDate(1, new java.sql.Date(new
		// Timestamp(date.getTime()).getTime()));
		System.out.println(pre.executeUpdate());
//		pre2.setLong(1, 3);
//		ResultSet res = pre2.executeQuery();
//		res.next();
//		System.out.println(res.getTimestamp("time"));
		synchronized (pre) {
			
		}
		con.commit();
		con.rollback();
		pre.close();
//		pre2.close();
		con.close();
	}

	public int check() throws SQLException {
		PreparedStatement pre = con
				.prepareStatement("select time from testtime where id=?");
		Date now = new Date();
		Date date = null;
		pre.setLong(1, 3);
		ResultSet res = pre.executeQuery();
		while (res.next()) {
			date = res.getTimestamp("time");
		}
		con.close();
		return now.compareTo(date);
	}
	public int inert(){
		PreparedStatement pre;
		int t = 0;
		try {
			pre = con.prepareStatement("INSERT INTO ghe (soghe,trangthai,idchuyen)VALUES(?,?,?)");
			for(int i=39; i<64; i++ ){
				pre.setLong(3, i);
			for (int j = 1; j < 12; j++) {
				pre.setInt(1, j);
				pre.setByte(2, (byte) 0);
				pre.executeUpdate();
				t++;
			}
			}			
		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		
	}
}
