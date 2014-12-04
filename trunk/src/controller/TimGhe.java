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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		Chuyen chuyen = ((Tuyen) session.getAttribute("tuyenDi")).getDanhSachChuyen().get(id);
		session.setAttribute("chuyenDi", chuyen);
		DatVe datVeDi = new DatVe(chuyen);
		datVeDi.addGhe(chuyen.getGhe(6));
		datVeDi.addGhe(chuyen.getGhe(7));
		datVeDi.addGhe(chuyen.getGhe(8));
		session.setAttribute("datVeDi", datVeDi);
		response.sendRedirect("./jsp/datve.jsp");
	}

}
