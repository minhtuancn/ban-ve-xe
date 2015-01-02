package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.KhachHangDAO;
import util.DuongDan;
import model.KhachHang;

/**
 * Servlet implementation class KiemTraVe
 */
public class KiemTraVe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KhachHangDAO khachHangDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KiemTraVe() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		super.init();
		khachHangDAO = (KhachHangDAO) new FactoryDAOImp().createDAO(FactoryDao.KHACH_HANG_DAO);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String pageFoward = DuongDan.TRANG_CHU;
		String mesSuccess = (String) request.getAttribute("mesSuccess");
		if (request.getParameter("pageFoward") != null)
			pageFoward = request.getParameter("pageFoward");
		KhachHang kh = (KhachHang) session.getAttribute("khachHang");
		if (kh == null) {
			response.sendRedirect(DuongDan.DANG_NHAP + "?pageFoward="+pageFoward);
		} else {
			kh = khachHangDAO.getKhachHang(kh.getIdKhachHang());
			session.setAttribute("khachHang", kh);
			if(mesSuccess!= null)
				request.setAttribute("mesSuccess", mesSuccess);
			request.getRequestDispatcher(DuongDan.KIEM_TRA_THONG_TIN_SVL).forward(request, response);;
		}
	}
}
