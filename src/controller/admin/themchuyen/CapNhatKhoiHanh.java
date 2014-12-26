package controller.admin.themchuyen;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.ChuyenDAO;

/**
 * Servlet implementation class CapNhatKhoiHanh
 */
public class CapNhatKhoiHanh extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private ChuyenDAO chuyenDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CapNhatKhoiHanh() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	super.init();
    	chuyenDAO = (ChuyenDAO) new FactoryDAOImp().createDAO(FactoryDao.CHUYEN_DAO);
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
		String idChuyen = request.getParameter("idChuyen");
		long id = Long.parseLong(idChuyen);
		if(chuyenDAO.capNhatKhoiHanh(id)){
			response.getWriter().print("ok");
		}else{
			response.getWriter().print("error");
		}
	}

}
