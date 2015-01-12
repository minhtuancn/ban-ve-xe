package controller.admin.dangnhap;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DuongDan;
import model.NhanVien;
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.NhanVienDAO;

/**
 * Servlet implementation class DangNhapAdmin
 */
public class DangNhapAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NhanVienDAO nhanVienDAO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhapAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	nhanVienDAO = (NhanVienDAO) new FactoryDAOImp().createDAO(FactoryDao.NHAN_VIEN_DAO);
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
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("password");
		String pageFoward = request.getParameter("pageFoward");
		HttpSession session = request.getSession();
		NhanVien nv = null;
		nv = nhanVienDAO.checkLoginAdmin(user, pass);
		System.out.println(user);
		System.out.println(pass);
		System.out.println(nv);
		if(nv != null){
			session.setAttribute("admin", nv);
			response.sendRedirect(pageFoward);
		}else{
			String mes = "Thông tin đăng nhập không đúng!!";
			request.setAttribute("mes", mes);
			request.getRequestDispatcher(DuongDan.DANG_NHAP_ADMIN_SVL).forward(request, response);
		}
		
	}
}
