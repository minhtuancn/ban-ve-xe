package controller;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TaiKhoan;
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.TaiKhoanDAO;

/**
 * Servlet implementation class LayMatKhau
 */
public class LayMatKhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaiKhoanDAO taiKhoanDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LayMatKhau() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	super.init();
    	taiKhoanDAO = (TaiKhoanDAO) new FactoryDAOImp().createDAO(FactoryDao.TAI_KHOAN_DAO);
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
		String tentk = request.getParameter("tentk");
		String captcha = request.getParameter("captcha");
		System.out.println(tentk + " : " + captcha);
		HttpSession session = request.getSession();
		String mes = null;
		if(((String )session.getAttribute("captcha")).equals(captcha)){
			TaiKhoan tk = taiKhoanDAO.layMatKhau(tentk);
			if(tk != null){
				mes = "ok";
			}else{
				mes = "Tài khoản không tồn tại, quí khách vui lòng kiểm tra lại!";
			}
		}else{
			mes = "Nhập sai mã xác thực!";
		}
		
		System.out.println(mes);
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(mes);
		response.getWriter().flush();
	}
}
