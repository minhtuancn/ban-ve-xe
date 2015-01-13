package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.KhachHangDAO;
import DAO.TaiKhoanDAO;
import model.KhachHang;
import model.KhachHangThuongXuyen;
import model.TaiKhoan;
import util.DuongDan;

/**
 * Servlet implementation class SuaThongTin
 */
@WebServlet ("/suathongtin")
public class SuaThongTin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KhachHangDAO khachHangDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuaThongTin() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		super.init();
		khachHangDAO = (KhachHangDAO) new FactoryDAOImp()
				.createDAO(FactoryDao.KHACH_HANG_DAO);
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
		response.setCharacterEncoding("UTF-8");
		String mes = null;
		String mesSuccess = null;
		KhachHang khachHang = (KhachHang) request.getSession().getAttribute(
				"khachHang");

		String tenDangKi = request.getParameter("name");
		System.out.println(tenDangKi);
		String email = request.getParameter("email");
		String sdt = request.getParameter("sdt");
		String cmnd = request.getParameter("cmnd");
		String diaChi = request.getParameter("diachi");
		
		KhachHang kh = new KhachHangThuongXuyen(khachHang.getIdKhachHang(), tenDangKi, sdt, cmnd, diaChi, email);
		long len = khachHangDAO.upDate(kh);
		
		if(len>0){
			khachHang.setTenKhachHang(tenDangKi);
			khachHang.setCmnd(cmnd);
			khachHang.setSdt(sdt);
			khachHang.setDiaChi(diaChi);
			khachHang.setEmail(email);
			request.getSession().setAttribute("khachHang", khachHang);
			
			mesSuccess = "Cập nhật thành công!";
			request.setAttribute("mesSuccess", mesSuccess);
			request.getRequestDispatcher(DuongDan.KIEM_TRA_THONG_TIN_SVL).forward(request, response);
		}
		else{
			 mes = "Không thể cập nhật, vui lòng nhập lại!";
			 request.setAttribute("mes", mes);
			 request.getRequestDispatcher(DuongDan.KIEM_TRA_THONG_TIN_SVL).forward(request, response);
		}
		
	}
}
