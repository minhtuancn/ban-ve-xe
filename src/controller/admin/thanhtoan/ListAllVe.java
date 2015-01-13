package controller.admin.thanhtoan;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.VeDAO;
import util.DuongDan;
import model.NhanVien;
import model.Ve;

/**
 * Servlet implementation class ListAllVe
 */
@WebServlet ("/listallve")
public class ListAllVe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String quyen = "xacnhanve";
	private VeDAO veDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListAllVe() {
		super();

	}

	@Override
	public void init() throws ServletException {
		super.init();
		veDAO = (VeDAO) new FactoryDAOImp().createDAO(FactoryDao.VE_DAO);
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
		NhanVien nv = (NhanVien) session.getAttribute("admin");
		String pageFoward = null;
		if (nv != null) {
			if (nv.getQuyen().contains(this.quyen)) {
				pageFoward = DuongDan.XAC_NHAN_THANH_TOAN_SVL;
				List<Ve> listVe = veDAO.getAllVe();
				request.setAttribute("listVe", listVe);
			} else {
				pageFoward = DuongDan.KHONG_CO_QUYEN;
			}
		} else {
			request.setAttribute("pageFoward", DuongDan.XAC_NHAN_THANH_TOAN_SV);
			pageFoward = DuongDan.DANG_NHAP_ADMIN_SVL;
		}
		request.getRequestDispatcher(pageFoward).forward(request, response);
	}

}
