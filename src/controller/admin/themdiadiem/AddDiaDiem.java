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
import DAO.TuyenDAOImpl;

/**
 * Servlet implementation class AddDiaDiem
 */
public class AddDiaDiem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DiaDiemDAO diaDiemDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddDiaDiem() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String tenDiaDiem = request.getParameter("tendiadiem");
		long id = diaDiemDAO.addDiaDiem(tenDiaDiem);
		System.out.println(id);
		if (id > 0)
			response.getWriter().print(id);
		response.getWriter().flush();
//		else
//			response.getWriter().print("Thêm địa điểm không thành công");

	}
}
