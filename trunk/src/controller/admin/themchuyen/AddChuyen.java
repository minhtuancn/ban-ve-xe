package controller.admin.themchuyen;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import model.Tuyen;
import model.Xe;
import DAO.ChuyenDAO;
import DAO.ChuyenDAOImpl;
import DAO.TuyenDAO;

/**
 * Servlet implementation class AddChuyen
 */
public class AddChuyen extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private ChuyenDAO chuyenDAO;
      private TuyenDAO tuyenDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddChuyen() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	super.init();
    	FactoryDao f = new FactoryDAOImp();
    	chuyenDAO = (ChuyenDAO) f.createDAO(FactoryDao.CHUYEN_DAO);
    	tuyenDAO = (TuyenDAO) f.createDAO(FactoryDao.TUYEN_DAO);
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
		Long idTuyen = (Long) sesstion.getAttribute("idTuyen");
		String gioKhoiHanh = request.getParameter("giokhoihanh");
		String xe = request.getParameter("xe");
		long idXe = Long.parseLong(xe);
		int gia = Integer.parseInt(request.getParameter("gia"));
		Tuyen tuyen = tuyenDAO.getTuyen(idTuyen);
		chuyenDAO.addChuyen(tuyen,gioKhoiHanh,idXe,tuyen.getDiemDi().getTenDiaDiem(), gia);
		response.getWriter().print("1");
	}

}
