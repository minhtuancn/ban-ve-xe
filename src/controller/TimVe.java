package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DuongDan;
import model.Ve;
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.VeDAO;

/**
 * Servlet implementation class TimVe
 */
public class TimVe extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private VeDAO veDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimVe() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
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
		String maVe = request.getParameter("maVe");
		String mes = "";
		Ve ve = null;
		ve =veDAO.timVeOfMaVe(maVe);
		if(ve != null){
			request.getSession().setAttribute("veDi", ve);
			response.sendRedirect(DuongDan.CHI_TIET_VE);
		}else{
			response.setCharacterEncoding("utf-8");
			mes = "Mã vé không tồn tại, vui lòng kiểm tra lại!";
			request.setAttribute("mes", mes);
			request.getRequestDispatcher(DuongDan.TIM_VE_SVL).forward(request, response);
		}
	}
}
