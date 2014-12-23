package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.KhachHangDAO;
import DAO.TaiKhoanDAO;
import model.DatVe;
import model.KhachHang;
import model.KhachHangThuongXuyen;
import model.TaiKhoan;
import model.Ve;
import util.DuongDan;
import util.LayMaVe;

/**
 * Servlet implementation class DangKi
 */
public class DangKi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KhachHangDAO khachHangDAO;
	private TaiKhoanDAO taiKhoanDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangKi() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		super.init();
		khachHangDAO = (KhachHangDAO) new FactoryDAOImp()
				.createDAO(FactoryDao.KHACH_HANG_DAO);
		taiKhoanDAO = (TaiKhoanDAO) new FactoryDAOImp().createDAO(FactoryDao.TAI_KHOAN_DAO);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
		// TODO Auto-generated method stub
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
		String scaptcha = null;
		String mes = null;
		KhachHang khachHang = null;
		if (request.getParameter("captcha") != null) {
			scaptcha = request.getParameter("captcha");
			
			String sdt = request.getParameter("sdt");
			khachHang = khachHangDAO.getKhachHang(sdt);
			
			if (khachHang == null) {
				String user = request.getParameter("user");
				String pass = request.getParameter("pass");
				String re_pass = request.getParameter("re-pass");
//				if (!pass.equals(re_pass)) {
//					mes = "Mật khẩu không trùng khớp!";
//					request.setAttribute("mes", mes);
//					request.getRequestDispatcher(DuongDan.DANG_KI_SVL).forward(
//							request, response);
//				} else {
					khachHang = khachHangDAO.checkLogIn(user, pass);
					if (khachHang == null) {
						String tenDangKi = request.getParameter("name");
						String email = request.getParameter("email");
						String cmnd = request.getParameter("cmnd");
						String diaChi = request.getParameter("diachi");
						khachHang = new KhachHangThuongXuyen(0, tenDangKi, sdt, cmnd, diaChi, email);

						System.out.println(khachHang.toString());
						
						khachHangDAO.addKhachHang(khachHang);
						taiKhoanDAO.addTaiKhoan(new TaiKhoan(user, pass, false));
System.out.println(khachHangDAO.addKhachHang(khachHang));
						response.sendRedirect(DuongDan.TRANG_CHU);
					} else {
						mes = "Tài khoản đã tồn tại!";
						request.setAttribute("mes", mes);
						request.getRequestDispatcher(DuongDan.DANG_KI_SVL).forward(
								request, response);
					}

				}
			} else {
				mes = "Số điện thoại đã tồn tại!";
				request.setAttribute("mes", mes);
				request.getRequestDispatcher(DuongDan.DANG_KI_SVL).forward(
						request, response);
			}
		}
	}

