package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Chuyen;
import model.Tuyen;
import util.DuongDan;
import DAO.ChuyenDAO;
import DAO.ChuyenDAOImpl;
import DAO.TuyenDAO;
import DAO.TuyenDAOImpl;

/**
 * Servlet implementation class ListChuyen
 */
public class ListChuyen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListChuyen() {
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
		HttpSession session = request.getSession();
		String tenTuyenXe = request.getParameter("tuyen");
		String date = request.getParameter("date");
		
		List<Tuyen> tuyen = (List<Tuyen>) request.getSession().getAttribute("listTuyen");
		ChuyenDAO chuyenDAO = new ChuyenDAOImpl();
		Tuyen t = null;
		System.out.println(tenTuyenXe);
		for (Tuyen tuyen2 : tuyen) {
		if(tuyen2.getTuyenXe().equalsIgnoreCase(tenTuyenXe))
			 t = tuyen2;
		}
		session.setAttribute("tuyen", t);
		List<Chuyen> list = chuyenDAO.getAllChuyen(t);
		request.setAttribute("listChuyen", list);
		request.getRequestDispatcher(DuongDan.THEM_CHUYEN_SVL).forward(request, response);
	}

}
