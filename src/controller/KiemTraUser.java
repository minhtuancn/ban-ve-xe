package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DuongDan;
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.KhachHangDAO;
import DAO.TaiKhoanDAO;

/**
 * Servlet implementation class KiemTraUser
 */
@WebServlet ("/kiemtrauser")
public class KiemTraUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaiKhoanDAO taiKhoanDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KiemTraUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		super.init();
		taiKhoanDAO = (TaiKhoanDAO) new FactoryDAOImp()
				.createDAO(FactoryDao.TAI_KHOAN_DAO);
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
		String user = request.getParameter("user");
		String mes = null;
		if (taiKhoanDAO.checkUser(user)) {
			mes = "Tên user đã tồn tại!";
		}else{
			mes = "";
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		response.getWriter().print(mes);
	}

}
