package controller.admin.themtuyen;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.DiaDiemDAO;
import DAO.TuyenDAO;
import DAO.TuyenDAOImpl;

/**
 * Servlet implementation class AddTuyen
 */
@WebServlet ("/addtuyen")
public class AddTuyen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TuyenDAO tuyenDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTuyen() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
		super.init();
		FactoryDao f = new FactoryDAOImp();
		tuyenDAO = (TuyenDAO) f.createDAO(FactoryDao.TUYEN_DAO);
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
		long id = -1;
		try{
			long diemDi = Long.parseLong(request.getParameter("diemDi"));
			long diemDen = Long.parseLong(request.getParameter("diemDen"));
			id = tuyenDAO.addTuyen(diemDi, diemDen);
		}catch (NumberFormatException e){
			
		}
			response.getWriter().print(id);
	}

}
