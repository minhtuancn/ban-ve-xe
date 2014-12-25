package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DuongDan;
import util.SendMessageUtil;
import model.KhachHang;
import model.Ve;
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.VeDAO;

/**
 * Servlet implementation class ThanhToan
 */
public class ThanhToan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VeDAO veDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThanhToan() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		super.init();
		veDAO = (VeDAO) new FactoryDAOImp().createDAO(FactoryDao.VE_DAO);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// String maVe = (String) request.getAttribute("maVeThanhToan");
		String maVe = (String) request.getParameter("mave");
//		String pageFoward = request.getParameter("pageFoward");
		KhachHang kh = (KhachHang) request.getSession().getAttribute(
				"khachHang");
		if (kh == null) {
//			request.getRequestDispatcher(
//					DuongDan.DANG_NHAP_SVL)
//					.forward(request, response);
			response.sendRedirect(DuongDan.DANG_NHAP);
		} else {
			String mes = "";
			Ve ve = veDAO.timVeOfMaVe(maVe);
			if (ve != null) {
				request.setAttribute("veThanhToan", ve);
				request.getRequestDispatcher(DuongDan.THANH_TOAN_VE_SVL)
						.forward(request,
				 response);
				 int n = new Random().nextInt(8999)+1000;
					HttpSession session = request.getSession();
					session.setAttribute("maOTP", n+"");
					SendMessageUtil.getInstance().sendMess(((KhachHang)session.getAttribute("khachHang")).getSdt(),"Ma OTP cua quy khach la: "+ n );
//				response.sendRedirect(DuongDan.CHI_TIET_VE);
			} else {
				mes = "Vé đã bị hủy do quá thời hạn thanh toán!";
				request.setAttribute("mes", mes);
				request.getRequestDispatcher(DuongDan.TIM_VE_SVL).forward(request,
						response);
			}
		}
	}
}
