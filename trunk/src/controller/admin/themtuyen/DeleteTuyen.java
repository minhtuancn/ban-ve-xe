package controller.admin.themtuyen;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.TuyenDAO;
import DAO.TuyenDAOImpl;
import model.Tuyen;

/**
 * Servlet implementation class DeleteTuyen
 */
@WebServlet ("/deletetuyen")
public class DeleteTuyen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TuyenDAO tuyenDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteTuyen() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void init() throws ServletException {
		super.init();
		FactoryDao f = new FactoryDAOImp();
		tuyenDAO = (TuyenDAO) f.createDAO(FactoryDao.TUYEN_DAO);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String mes = null;
		try{
		int id = Integer.parseInt(request.getParameter("id"));
		tuyenDAO = new TuyenDAOImpl();
		int res = tuyenDAO.deleteTuyen(id);
		switch (res) {
		case -1:
			mes = "Server Lổi!\nXóa tuyến không thành công!";
			break;
		case -2:
			mes = "Tuyến bị đã được phân công chuyến đi!\nKhông thể xóa!";
			break;
		case 1:
			mes = null;
			break;
		default:
			break;
		}
		}catch(NumberFormatException e){
			mes = "Lổi định dạng!";
		}
		if(mes!= null){
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(mes);
		}
			
	}
}
