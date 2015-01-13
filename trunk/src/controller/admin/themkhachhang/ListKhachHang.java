package controller.admin.themkhachhang;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DuongDan;
import model.KhachHang;
import model.NhanVien;
import DAO.KhachHangDAO;
import DAO.KhachHangDAOIml;

/**
 * Servlet implementation class ListKhachHang
 */
@WebServlet("/listkhachhang")
public class ListKhachHang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListKhachHang() {
		super();
		// TODO Auto-generated constructor stub
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
		NhanVien nv = (NhanVien) session.getAttribute("admin");
		if (nv != null) {
			KhachHangDAO kh = new KhachHangDAOIml();
			List<KhachHang> listKH = kh.getAllKhachHang();
			request.setAttribute("listKH", listKH);
			request.getRequestDispatcher(DuongDan.THEM_KHACHHANG_SVL).forward(
					request, response);
		} else {
			request.setAttribute("pageFoward", DuongDan.LIST_KHACH_HANG_SV);
			request.getRequestDispatcher(DuongDan.DANG_NHAP_ADMIN_SVL).forward(
					request, response);
		}
	}

}
