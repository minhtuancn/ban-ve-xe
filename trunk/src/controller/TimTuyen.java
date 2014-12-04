package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.TuyenDAOImpl;
import model.Tuyen;

/**
 * Servlet implementation class TimTuyen
 */
public class TimTuyen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimTuyen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tuyen tuyen = new TuyenDAOImpl().getTuyen("", "");
		HttpSession session = request.getSession();
		session.setAttribute("tuyenDi", tuyen);
//		request.getRequestDispatcher("./jsp/timchuyen.jsp").forward(request, response);;
		response.sendRedirect("./jsp/timchuyen.jsp");
	}
	


}
