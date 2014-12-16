package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DuongDan;
import model.Tuyen;
import DAO.TuyenDAO;
import DAO.TuyenDAOImpl;

/**
 * Servlet implementation class Kiemtrachuyen
 */
public class Kiemtrachuyen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kiemtrachuyen() {
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
		// TODO Auto-generated method stub
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TuyenDAO tuyenDAO = new TuyenDAOImpl();
		List<Tuyen> listTuyen = tuyenDAO.getAllTuyen();
		request.getSession().setAttribute("listTuyen", listTuyen);
		request.getRequestDispatcher(DuongDan.THEM_CHUYEN_SVL).forward(request, response);
	}


}
