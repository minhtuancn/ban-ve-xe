package controller;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import util.SendMessage;
import util.SendMessageUtil;
import model.KhachHang;
import model.TaiKhoan;
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.KhachHangDAO;
import DAO.TaiKhoanDAO;

/**
 * Servlet implementation class LayMatKhau
 */
public class LayMatKhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaiKhoanDAO taiKhoanDAO;
    private KhachHangDAO khachHangDAO;
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
    	FactoryDao f = new FactoryDAOImp();
    	taiKhoanDAO = (TaiKhoanDAO) f.createDAO(FactoryDao.TAI_KHOAN_DAO);
    	khachHangDAO = (KhachHangDAO) f.createDAO(FactoryDao.KHACH_HANG_DAO);
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
				KhachHang kh = khachHangDAO.checkLogIn(tk.getTenTK(), DigestUtils.md5Hex(tk.getMatKhau()));
				SendMessageUtil.getInstance().sendMess(kh.getSdt(), "Mật khẩu mới của quí khách là: " + tk.getMatKhau());
				System.out.println(kh);
			}else{
				mes = "Tài khoản không tồn tại, quí khách vui lòng kiểm tra lại!";
			}
		}else{
			mes = "Nhập sai mã xác thực!";
		}
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(mes);
		response.getWriter().flush();
	}
}
