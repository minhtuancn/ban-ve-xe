package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.ConnectionPool;
import database.Database;
import model.Chuyen;
import model.DatVe;
import model.Ghe;

public class GheDAOImpl implements GheDAO {
	
	@Override
	public List<Ghe> getAllGhe(long idChuyen) {
		Connection con = ConnectionPool.getInstance().getConnection();
		ArrayList<Ghe> list = new ArrayList<Ghe>();
		String sql1 = "SELECT idghe,soghe,trangthai,idve, giucho FROM ghe WHERE idchuyen = ?";
		PreparedStatement pre = null;
		ResultSet res;
		Date now = new Date();
		Date dateGiuCho;
		byte trangThai = 0;
		try {
			pre = con.prepareStatement(sql1);
			pre.setLong(1, idChuyen);
			res = pre.executeQuery();
			while (res.next()) {
				switch (res.getByte("trangthai")) {
				case Ghe.CHUA_DAT:
					// khong lam gi het
					break;
				case Ghe.DANG_GIU:
					// kiểm tra thời gian giữ ghế còn hiệu lực không
					dateGiuCho = new Date(res.getTimestamp("giucho").getTime());
					trangThai = dateGiuCho.compareTo(now) < 0? Ghe.CHUA_DAT : Ghe.DA_DAT;
					break;
				case Ghe.DA_DAT:
					trangThai = Ghe.DA_DAT;
					break;
				default:
					break;
				}
				list.add(new Ghe(res.getLong("idghe"), res.getInt("soghe"),
						trangThai));
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
	public String setGiuCho(DatVe datVe) {
		Connection con = ConnectionPool.getInstance().getConnection();
		con.setAutoCommit(false);
		con.setTransactionIsolation(Connection.);
		PreparedStatement pre = null;
		ResultSet res;
		String sqlCheck = "select trangthai, giucho from ghe where idghe=?";
		String sqlSet = "update ghe set trangthai=? where idghe=?";
		try {
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closePre(pre);
			ConnectionPool.getInstance().freeConnection(con);
		}
		return null;
	}

//	public static void main(String[] args) throws SQLException {
//		PreparedStatement pre = Database.getInstance().getConnection()
//				.prepareStatement("select trangthai from ghe");
//		ResultSet res = pre.executeQuery();
//		while(res.next())
//			System.out.println(res.getInt("trangthai"));
//	}

}
