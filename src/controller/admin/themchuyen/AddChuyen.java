package controller.admin.themchuyen;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Tuyen;
import model.Xe;
import DAO.ChuyenDAO;
import DAO.ChuyenDAOImpl;

/**
 * Servlet implementation class AddChuyen
 */
public class AddChuyen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddChuyen() {
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
		HttpSession sesstion = request.getSession();
		Tuyen t = (Tuyen) sesstion.getAttribute("tuyen");
		String gioKhoiHanh = request.getParameter("giokhoihanh");
		String xe = request.getParameter("xe");
		Xe xes = null;
		if(xe.equalsIgnoreCase("xe45"))
			 xes = new Xe("", "", 45);
		xes = new Xe("", "", 16);
		int gia = Integer.parseInt(request.getParameter("gia"));
		ChuyenDAO dao = new ChuyenDAOImpl();
		dao.addChuyen(t, gioKhoiHanh,xes, t.getDiemDi().getTenDiaDiem(), gia);
		response.getWriter().print("1");
	}

}
