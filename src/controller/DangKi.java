package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import util.SendMessageUtil;

/**
 * Servlet implementation class DangKi
 */
@WebServlet ("/dangki")
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
		request.setCharacterEncoding("UTF-8");
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
				if (!pass.equals(re_pass)) {
					mes = "Mật khẩu không trùng khớp!";
					request.setAttribute("mes", mes);
					request.getRequestDispatcher(DuongDan.DANG_KI_SVL).forward(
							request, response);
				} else {
					khachHang = khachHangDAO.checkLogIn(user, pass);
					if (khachHang == null) {
						String tenDangKi = request.getParameter("name");
						String email = request.getParameter("email");
						String cmnd = request.getParameter("cmnd");
						String diaChi = request.getParameter("diachi");
						System.out.println("DangKy " + tenDangKi + " : " + diaChi);
						khachHang = new KhachHangThuongXuyen(0, tenDangKi, sdt,
								cmnd, diaChi, email);

						((KhachHangThuongXuyen) khachHang).setTaiKhoan(new TaiKhoan(user, pass, false));
						khachHangDAO.addKhachHang(khachHang);
//						response.sendRedirect(DuongDan.TRANG_CHU);
						int n = new Random().nextInt(8999)+1000;
						System.out.println("DangKi:" +n);
						HttpSession session = request.getSession();
						session.setAttribute("khachHang", khachHang);
						session.setAttribute("maOTP", n+"");
						SendMessageUtil.getInstance().sendMess(khachHang.getSdt(),"Ma OTP cua quy khach la: "+ n );
						response.sendRedirect(DuongDan.KICH_HOAT_TAI_KHOAN);
						
					} else {
						mes = "Tài khoản đã tồn tại!";
						request.setAttribute("mes", mes);
						request.getRequestDispatcher(DuongDan.DANG_KI_SVL)
								.forward(request, response);
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
}
