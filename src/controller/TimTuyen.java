package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.TuyenDAO;
import DAO.TuyenDAOImpl;
import model.Tuyen;

/**
 * Servlet implementation class TimTuyen
 */
public class TimTuyen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TuyenDAO tuyenDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TimTuyen() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		tuyenDAO = new TuyenDAOImpl();
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
		HttpSession session = request.getSession();
		String khuHoi = request.getParameter("laKhuHoi");
		boolean laKhuHoi = false;
		if (khuHoi != null && khuHoi.equalsIgnoreCase("on"))
			laKhuHoi = true;
		else
			laKhuHoi = false;

		session.setAttribute("laKhuHoi", laKhuHoi);
		Tuyen tuyen =  tuyenDAO.getTuyen(request.getParameter("noidi"), request.getParameter("noiden"), request.getParameter("ngaydi"));
				session.setAttribute("tuyenDi", tuyen);
		if (laKhuHoi) {
			session.setAttribute("tuyenVe", tuyen);
		}
		request.getRequestDispatcher("/jsp/timchuyen.jsp").forward(request,
				response);
	}

}
