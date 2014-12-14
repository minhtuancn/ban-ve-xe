package controller.admin.themtuyen;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TuyenDAO;
import DAO.TuyenDAOImpl;
import util.DataTablesParamUtility;
import util.JQueryDataTableParamModel;

/**
 * Servlet implementation class ListTuyenData
 */
public class ListTuyenData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListTuyenData() {
		super();
		// TODO Auto-generated constructor stub
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
		JQueryDataTableParamModel param = DataTablesParamUtility
				.getParam(request);

		String sEcho = param.sEcho;
		
		int iTotalRecords; // total number of records (unfiltered)
		int iTotalDisplayRecords; // value will be set when code filters
									// companies by keyword
		
		TuyenDAO tuyenDao = new TuyenDAOImpl();
		iTotalRecords = tuyenDao.getAllTuyen().size();
	}

}
