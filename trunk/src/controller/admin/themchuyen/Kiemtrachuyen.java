package controller.admin.themchuyen;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.NhanVien;
import model.Tuyen;
import util.DuongDan;
import DAO.TuyenDAO;
import DAO.TuyenDAOImpl;

/**
 * Servlet implementation class Kiemtrachuyen
 */
public class KiemTraChuyen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String quyen = "themchuyen";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KiemTraChuyen() {
		super();
		// TODO Auto-generated constructor stub
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
		HttpSession session = request.getSession();
		NhanVien nv = (NhanVien) session.getAttribute("admin");
		String pageFoward = null;
		if (nv != null) {
			if (nv.getQuyen().contains(this.quyen))
				pageFoward = "ListChuyen";
			else
				pageFoward = DuongDan.KHONG_CO_QUYEN;
		} else {
			pageFoward = DuongDan.DANG_NHAP_ADMIN_SVL;
		}
		request.getRequestDispatcher(pageFoward).forward(request, response);
	}

}
