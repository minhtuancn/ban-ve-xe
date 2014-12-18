package controller.admin.themtuyen;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TuyenDAOImpl;

/**
 * Servlet implementation class AddTuyen
 */
public class AddTuyen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTuyen() {
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
			long diemDi = Long.parseLong(request.getParameter("diemDi"));
			long diemDen = Long.parseLong(request.getParameter("diemDen"));
			System.out.println(diemDi +" - "+ diemDen);
			new TuyenDAOImpl().addTuyen(diemDi, diemDen);
			response.getWriter().print("1");
	}

}
