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
		boolean laKhuHoi = true;
		
		HttpSession session = request.getSession();
		session.setAttribute("laKhuHoi", laKhuHoi);
		Tuyen tuyen = new TuyenDAOImpl().getTuyen("", "");
		session.setAttribute("tuyenDi", tuyen);
		session.setAttribute("tuyenVe", tuyen);
//		response.sendRedirect("/BanVeXe/jsp/timchuyen.jsp");
		if(laKhuHoi){
			
		}
		request.getRequestDispatcher("/jsp/timchuyen.jsp").forward(request, response);;
	}
	


}
