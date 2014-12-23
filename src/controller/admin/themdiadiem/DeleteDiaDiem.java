package controller.admin.themdiadiem;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.DiaDiemDAO;
import DAO.DiaDiemDAOImpl;
import DAO.TuyenDAO;
import DAO.TuyenDAOImpl;

/**
 * Servlet implementation class DeleteDiaDiem
 */
public class DeleteDiaDiem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DiaDiemDAO diaDiemDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteDiaDiem() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		super.init();
		diaDiemDAO = (DiaDiemDAO) new FactoryDAOImp()
				.createDAO(FactoryDao.DIA_DIEM_DAO);
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
		int id = Integer.parseInt(request.getParameter("id"));
		int kq = diaDiemDAO.deleteDiaDiem(id);
		response.setCharacterEncoding("UTF-8");
		switch (kq) {
		case -3:
			response.getWriter().print("Lổi server");
			break;
		case -2:
			response.getWriter().print("Địa điểm không tồn tại");
			break;
		case -1:
			response.getWriter().print("Địa điểm đã được sữ dụng cho tuyến");
			break;
		default:
			break;
		}
	}
}
