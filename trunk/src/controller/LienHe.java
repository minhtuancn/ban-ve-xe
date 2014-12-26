package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DuongDan;
import util.SendEmail;


/**
 * Servlet implementation class LienHe
 */
public class LienHe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LienHe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String tenKh = request.getParameter("name");
		String email = request.getParameter("email");
		String tieuDe = request.getParameter("tieude");
		String noiDung = request.getParameter("message");
		String check = request.getParameter("checkbox");
		String mes = null;
		if (check != null) {
			SendEmail.getInstant().guiMailLienHe(tenKh, email, noiDung);
		}
		SendEmail.getInstant().guiMailLienHeAdmin(tenKh, email, noiDung);
		mes = "Email của quý khách đã gửi thành công!";
		request.setAttribute("mes", mes);
		request.getRequestDispatcher(DuongDan.LIEN_HE_SVL).forward(request,
				response);
	}

}
