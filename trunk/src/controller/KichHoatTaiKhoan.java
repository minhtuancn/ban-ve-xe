package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.KhachHang;
import model.KhachHangThuongXuyen;
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.TaiKhoanDAO;
import util.DuongDan;

/**
 * Servlet implementation class KichHoatTaiKhoan
 */
public class KichHoatTaiKhoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaiKhoanDAO taiKhoanDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KichHoatTaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		super.init();
		taiKhoanDAO = (TaiKhoanDAO) new FactoryDAOImp()
				.createDAO(FactoryDao.TAI_KHOAN_DAO);
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
		// TODO Auto-generated method stub
	}

	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		KhachHang kh = (KhachHang) session.getAttribute("khachHang");
		if (kh != null) {
			String maOTP = request.getParameter("maOTP");
			String maOTPCheck = (String) request.getSession().getAttribute(
					"maOTP");
			String mes = null;
			if (maOTPCheck.equalsIgnoreCase(maOTP)) {
				if (taiKhoanDAO.kichHoatTaiKhoan(((KhachHangThuongXuyen) kh)
						.getTaiKhoan().getIdTaiKhoan())){
//					response.sendRedirect(DuongDan.KIEM_TRA_VE_SV);
					request.setAttribute("mesSuccess", "Kích hoạt tài khoản thành công");
					request.getRequestDispatcher("KiemTraVe")
					.forward(request, response);
				}
				else
					response.sendRedirect(DuongDan.TRANG_CHU);
			} else {
				mes = "Sai mã OTP, vui lòng kích hoạt lại!!";
				request.setAttribute("mes", mes);
				request.getRequestDispatcher("/jsp/KichHoatTaiKhoan.jsp")
						.forward(request, response);
			}
		} else {
			response.sendRedirect(DuongDan.DANG_NHAP);
		}
	}
}
