package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DuongDan;
import model.KhachHang;
import model.KhachHangThuongXuyen;
import model.TaiKhoan;
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.TaiKhoanDAO;

/**
 * Servlet implementation class DoiMatKhau
 */
public class DoiMatKhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaiKhoanDAO taiKhoanDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoiMatKhau() {
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
		// TODO Auto-generated method stub
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
		String pass_old = request.getParameter("pass-old");
		String pass = request.getParameter("pass");
		String re_pass = request.getParameter("re-pass");
		String mes = "";

		KhachHang khachHangDMK = (KhachHang) request.getSession().getAttribute(
				"khachHang");
		TaiKhoan tk = ((KhachHangThuongXuyen) khachHangDMK).getTaiKhoan();
		String passKH = tk.getMatKhau();
		long upDate = -1;

		if (pass_old.equals(passKH)) {
			if (pass.equals(re_pass)) {
				upDate = taiKhoanDAO.upDateMatKhau(tk.getTenTK(), pass);
				tk.setMatKhau(pass);
				request.setAttribute("mesSuccess", "Đổi mật khẩu thành công");
				request.getRequestDispatcher(DuongDan.KIEM_TRA_THONG_TIN_SVL).forward(request, response);
				return;
			} else {
				mes = "Mật khẩu mới nhập không trùng khớp!";
			}
		} else {
			mes = "Mật khẩu cũ nhập sai!";
		}
		request.setAttribute("mes", mes);
		request.getRequestDispatcher(DuongDan.DOI_MAT_KHAU_SVL).forward(
				request, response);

	}
}
