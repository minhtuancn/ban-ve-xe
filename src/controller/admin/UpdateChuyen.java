package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ChuyenDAO;
import DAO.ChuyenDAOImpl;
import model.Chuyen;

/**
 * Servlet implementation class UpdateChuyen
 */
public class UpdateChuyen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateChuyen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int columnPosition = Integer.parseInt(request
				.getParameter("columnPosition"));
		String value = request.getParameter("value");
		ChuyenDAO chuyenDao = new ChuyenDAOImpl();
		if (!chuyenDao.editChuyen(id, value, columnPosition))
			response.getWriter().print("Error - company cannot be found");
		else{
			response.getWriter().print(value);
		}
	}

}
