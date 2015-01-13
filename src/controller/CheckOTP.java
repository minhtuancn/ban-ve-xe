package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.KhachHang;
import util.SendMessageUtil;

/**
 * Servlet implementation class CheckOTP
 */
@WebServlet ("/checkotp")
public class CheckOTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOTP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n = new Random().nextInt(8999)+1000;
		HttpSession session = request.getSession();
		session.setAttribute("maOTP", n+"");
		System.out.println("CheckOTP: "+n);
		SendMessageUtil.getInstance().sendMess(((KhachHang)session.getAttribute("khachHang")).getSdt(),"Ma OTP moi cua quy khach la: "+ n );
//		SendMessageUtil.getInstance().sendMess("01684651354","Ma OTP moi cua quy khach la: "+ n );
		response.setContentType("text/plain");
		response.getWriter().print("ok");
	}
}

