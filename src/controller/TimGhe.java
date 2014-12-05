package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Chuyen;
import model.DatVe;
import model.Tuyen;

/**
 * Servlet implementation class TimGhe
 */
public class TimGhe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TimGhe() {
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
		boolean laKhuhoi = (boolean) session.getAttribute("laKhuHoi");

		String ids = request.getParameter("id");
		String chuyens = request.getParameter("chuyen");
		if (ids != null && chuyens != null) {
			int id = Integer.parseInt(ids);
			int chuyen = Integer.parseInt(chuyens);
			session.setAttribute("chuyen", chuyen);
			if (chuyen == 1) {
				Chuyen c = ((Tuyen) session.getAttribute("tuyenDi"))
						.getDanhSachChuyen().get(id);
				session.setAttribute("chuyenDi", c);
				DatVe datVeDi = new DatVe(c);
				session.setAttribute("datVeDi", datVeDi);
				// response.sendRedirect("/jsp/datve.jsp");
				request.getRequestDispatcher("/jsp/datvedi.jsp").forward(
						request, response);
			} else {
				Chuyen c = ((Tuyen) session.getAttribute("tuyenVe"))
						.getDanhSachChuyen().get(id);
				session.setAttribute("chuyenVe", c); 
				DatVe datVeDi = new DatVe(c); 
				session.setAttribute("datVeVe", datVeDi);
				// response.sendRedirect("/jsp/datve.jsp");
				request.getRequestDispatcher("/jsp/datveve.jsp").forward(
						request, response);
			}
		}else{
			response.sendRedirect("/BanVeXe/jsp/body.jsp");
			
		}
	}
}
