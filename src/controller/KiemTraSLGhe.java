package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DatVe;

/**
 * Servlet implementation class KiemTraSLGhe
 */
public class KiemTraSLGhe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KiemTraSLGhe() {
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
		HttpSession session = request.getSession();
		String idChuyen = request.getParameter("idChuyen");
		String datVeString = "";
		String mes = "";
		if (idChuyen.equalsIgnoreCase("1")) {
			datVeString = "datVeDi";
		} else {
			datVeString = "datVeVe";
		}
		DatVe datVe = (DatVe) session.getAttribute(datVeString);
		if(datVe.getSoLuongGhe()==0){
			mes = "false";
		}else{
			mes = "true";
		}
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(mes);
		response.getWriter().flush();
	}

}
