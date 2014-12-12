package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TuyenDAO;
import DAO.TuyenDAOImpl;

/**
 * Servlet implementation class UpdateTuyen
 */
public class UpdateTuyen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateTuyen() {
		super();
		// TODO Auto-generated constructor stub
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
		int id = Integer.parseInt(request.getParameter("id"));
		// int columnId = Integer.parseInt(request.getParameter("columnId"));
		int columnPosition = Integer.parseInt(request
				.getParameter("columnPosition"));
		// int rowId = Integer.parseInt(request.getParameter("rowId"));
		String value = request.getParameter("value");
		// String columnName = request.getParameter("columnName");
		TuyenDAO tuyenDao = new TuyenDAOImpl();
		if (!tuyenDao.editTuyen(id, value, columnPosition))
			response.getWriter().print("Error - company cannot be found");
		else{
			response.getWriter().print(value);
		}
	}

}
