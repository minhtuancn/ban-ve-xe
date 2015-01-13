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
import util.DuongDan;
import util.SendMessageUtil;
import DAO.KhachHangDAO;
import DAO.KhachHangDAOIml;
import model.KhachHang;
import model.KhachHangThuongXuyen;

/**
 * Servlet implementation class DangNhap
 */
@WebServlet ("/dangnhap")
public class DangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KhachHangDAO khDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangNhap() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void init() throws ServletException {
		super.init();
		khDao = (KhachHangDAO) new FactoryDAOImp().createDAO(FactoryDao.KHACH_HANG_DAO);
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
		String pageForward = DuongDan.TRANG_CHU;
		String mes = "";
		
		if( request.getSession().getAttribute("khachHang")==null){
		if (request.getParameter("pageFoward") != null)
			pageForward = request.getParameter("pageFoward");
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		//
		if(user.trim().length() == 0){
			mes = "Bạn chưa nhập tên tài khoản!";
			request.setAttribute("mes", mes);
			request.getRequestDispatcher(DuongDan.DANG_NHAP_SVL).forward(request, response);
			return;
		}
		if(password.trim().length() == 0){
			mes = "Bạn chưa nhập mật khẩu!";
			request.setAttribute("mes", mes);
			request.getRequestDispatcher(DuongDan.DANG_NHAP_SVL).forward(request, response);
			return;
		}
		
		KhachHang kh = khDao.checkLogIn(user, password);
		if (kh != null) {
			HttpSession session = request.getSession();
			session.setAttribute("khachHang", kh);
		} else {
			mes = "Tài khoản không đúng, xin vui lòng thử lại!";
			request.setAttribute("mes", mes);
			request.getRequestDispatcher(DuongDan.DANG_NHAP_SVL).forward(request, response);
			return;
		}
		if(((KhachHangThuongXuyen)kh).getTaiKhoan().isDaKichHoat())
		response.sendRedirect(pageForward);
		else{
			int n = new Random().nextInt(8999)+1000;
			System.out.println("DangKi:" +n);
			HttpSession session = request.getSession();
			session.setAttribute("maOTP", n+"");
			SendMessageUtil.getInstance().sendMess(kh.getSdt(),"Ma OTP cua quy khach la: "+ n );
			response.sendRedirect(DuongDan.KICH_HOAT_TAI_KHOAN);
		}
		}else{
			mes = "Bạn đã đăng nhập!";
			request.setAttribute("mes", mes);
			request.getRequestDispatcher("KiemTraVe").forward(request, response);
			return;
		}
	}

}
