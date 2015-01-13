package controller.admin.themtuyen;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.TuyenDAO;
import DAO.TuyenDAOImpl;

/**
 * Servlet implementation class UpdateTuyen
 */
@WebServlet ("/updatetuyen")
public class UpdateTuyen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TuyenDAO tuyenDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateTuyen() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void init() throws ServletException {
		super.init();
		FactoryDao f = new FactoryDAOImp();
		tuyenDAO = (TuyenDAO) f.createDAO(FactoryDao.TUYEN_DAO);
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
		String value = "";
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			// int columnId =
			// Integer.parseInt(request.getParameter("columnId"));
			int columnPosition = Integer.parseInt(request
					.getParameter("columnPosition"));
			// int rowId = Integer.parseInt(request.getParameter("rowId"));
			value = request.getParameter("value") != null ? request.getParameter("value") : "";
			// String columnName = request.getParameter("columnName");

			int res = tuyenDAO.editTuyen(id, value, columnPosition);
			switch (res) {
			case -1:
				value = "Không tồn tại tuyến!\nUpdate tuyến không thành công!";
				break;
			case -2:
				value = "Tuyến bị trùng sao khi chĩnh sữa!\nUpdate tuyến không thành công!";
				break;
			case -3:
				value = "Điểm đi trùng điểm đến!\nUpdate tuyến không thành công!";
				break;
			case 0:
				value = "Lổi server!\nUpdate tuyến không thành công!";
				break;
			case 1:
				break;
			default:
				break;
			}
		} catch (NumberFormatException e) {
			value = "Lổi định đạng! \nUpdate tuyến không thành công!";
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(value);
	}

}
