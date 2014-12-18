package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
static Connection con;
String user = "root";
String pass = "vertrigo";
private static Database database = new Database();
	private Database(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banvexe",user, pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Database getInstance(){
		return database;
	}
	public Connection getConnection(){
		try {
			return  DriverManager.getConnection("jdbc:mysql://localhost:3306/banvexe",user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return null;
	}
	public void closePre(PreparedStatement pre){
			try {
				if(pre != null)
				pre.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public void closeCon(Connection con){
			try {
				if(con != null)
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
