package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DatVe;
import model.KhachHang;

/**
 * Servlet implementation class ThemGhe
 */
public class ThemGhe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemGhe() {
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
		String idGhe = request.getParameter("idGhe");
		String idChuyen = request.getParameter("idChuyen");
		DatVe datVe = null;
		String datVeString = "";
		String mes = "";
		if (idChuyen.equalsIgnoreCase("1")) {
			datVeString = "datVeDi";
		} else {
			datVeString = "datVeVe";
		}
		datVe = (DatVe) session.getAttribute(datVeString);
		KhachHang kh = (KhachHang) session.getAttribute("khachHang");
		if ((kh == null && datVe.getSoLuongGhe() > 1)) {
			mes = "limited-notlogin";
		} else {
			if ((kh != null && datVe.getSoLuongGhe() > 4)) {
				mes = "limited-login";
			} else {
				datVe = (DatVe) session.getAttribute(datVeString);
				datVe.addGhe(Integer.parseInt(idGhe));
				session.setAttribute(datVeString, datVe);
				mes = "ok";
			}
		}
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(mes);
		response.getWriter().flush();
	}

}
