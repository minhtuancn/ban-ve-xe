package database;

import java.sql.*;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import DAO.TuyenDAOImpl;


public class ConnectionPool {
	private static ConnectionPool pool = null;
	private static DataSource dataSource = null;

	private ConnectionPool() {
		try {
			InitialContext ic = new InitialContext();
			dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/banvexe");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ConnectionPool getInstance() {
		if (pool == null) {
			pool = new ConnectionPool();
		}
		return pool;
	}

	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void closePre(PreparedStatement pre){
		try {
			if(pre != null)
			pre.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
	
	public void freeConnection(Connection c) {
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void setDefaulAutoCommit(Connection c) {
		try {
			c.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Connection con = getInstance().getConnection();
		System.out.println(new TuyenDAOImpl().getAllTuyen().size());
		getInstance().freeConnection(con);
	}
}
