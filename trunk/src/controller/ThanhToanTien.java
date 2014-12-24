package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ve;
import util.DuongDan;
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.VeDAO;

/**
 * Servlet implementation class ThanhToanTien
 */
public class ThanhToanTien extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VeDAO veDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThanhToanTien() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	veDAO = (VeDAO) new FactoryDAOImp().createDAO(FactoryDao.VE_DAO);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doAction(request, response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maVe = request.getParameter("maVeThanhToan");
		String mes = veDAO.thanhToanVe(maVe);
		if(mes == null){
			Ve ve = veDAO.timVeOfMaVe(maVe);
			request.getSession().setAttribute("veDi",ve );
			request.getRequestDispatcher(DuongDan.CHI_TIET_VE_SVL).forward(request, response);
		}else{
		request.setAttribute("mes", mes);
		request.getRequestDispatcher(DuongDan.CHI_TIET_VE_SVL).forward(request, response);
		}
		
	}

}
