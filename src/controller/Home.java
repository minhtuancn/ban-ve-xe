package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DuongDan;
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.DiaDiemDAO;
import model.DiaDiem;

/**
 * Servlet implementation class Home
 */
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DiaDiemDAO diaDiemDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	super.init();
    	diaDiemDAO = (DiaDiemDAO) new FactoryDAOImp().createDAO(FactoryDao.DIA_DIEM_DAO);
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
		List<DiaDiem> listDiaDiem = diaDiemDAO.getAllDiaDiem();
		request.getSession().setAttribute("listDiaDiem", listDiaDiem);
		response.sendRedirect(DuongDan.TRANG_CHU);
	}

}
