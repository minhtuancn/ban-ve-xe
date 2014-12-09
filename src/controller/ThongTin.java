package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DuongDan;
import model.DatVe;
import model.KhachHang;
import model.KhachHangThuongXuyen;
import model.KhachHangVangLai;
import model.Ve;

/**
 * Servlet implementation class ThongTin
 */
public class ThongTin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThongTin() {
		super();
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
		KhachHang kh;
		if (session.getAttribute("khachHang") != null && ((KhachHang) session.getAttribute("khachHang") instanceof KhachHangThuongXuyen))
			kh = (KhachHang) session.getAttribute("khachHang");
		else
			kh = new KhachHangVangLai();
		String sghiChu = request.getParameter("ghichu");
		String scaptcha = request.getParameter("captcha");
		boolean laKhuHoi = (Boolean) session.getAttribute("laKhuHoi");
		if (((String) session.getAttribute("captcha")).equals(scaptcha)) {
			if(kh instanceof KhachHangVangLai){
			kh.setTenKhachHang(request.getParameter("hoten"));
			kh.setSdt(request.getParameter("didong"));
			kh.setCmnd(request.getParameter("cmnd"));
			kh.setEmail(request.getParameter("email"));
			}
			//
			Ve veDi = new Ve((String) session.getAttribute("maVeDi"),
					(DatVe) session.getAttribute("datVeDi"), sghiChu);
			kh.setVeDi(veDi);
			if (laKhuHoi) {
				Ve veVe = new Ve((String) session.getAttribute("maVeVe"),
						(DatVe) session.getAttribute("datVeVe"), sghiChu);
				kh.setVeVe(veVe);
			}
			session.setAttribute("khachHang", kh);
			response.sendRedirect(DuongDan.CHI_TIET_VE);
			
		} else {
			request.getRequestDispatcher(DuongDan.THANH_TOAN_SVL).forward(request, response);
		}
	}

}
