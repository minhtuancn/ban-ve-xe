package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DatVe;

/**
 * Servlet implementation class HuyGhe
 */
public class HuyGhe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HuyGhe() {
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
		String idGhe = request.getParameter("idGhe");
		String idChuyen = request.getParameter("idChuyen");
		DatVe datVe  = null;
		HttpSession session = request.getSession();
		String datVeString = "";
		if(idChuyen.equalsIgnoreCase("1")){
			datVeString = "datVeDi";
		}else{
			datVeString = "datVeVe";
		}
		
		datVe = (DatVe) session.getAttribute(datVeString);
		datVe.removeGhe(Integer.parseInt(idGhe));
		session.setAttribute(datVeString, datVe);
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println("ok"); 
		response.getWriter().flush();
	}

}
