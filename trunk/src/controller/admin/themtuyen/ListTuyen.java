package controller.admin.themtuyen;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.LLOAD;

import util.DuongDan;
import DAO.TuyenDAO;
import DAO.TuyenDAOImpl;
import model.DiaDiem;
import model.Tuyen;

/**
 * Servlet implementation class ListTuyen
 */
public class ListTuyen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListTuyen() {
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
		TuyenDAO tuyenDao = new TuyenDAOImpl();
		List<Tuyen> listTuyen = tuyenDao.getAllTuyen();
		List<DiaDiem> listDiaDiem = tuyenDao.getAllDiaDiem();
		String dataDiaDiem = "\"{";
		DiaDiem d;
		int i  = 0;
		for (i = 0; i < listDiaDiem.size() -1; i++) {
			d = listDiaDiem.get(i);
			dataDiaDiem += "'" + d.getIdDiaDiem() + "':'" + d.getTenDiaDiem() +"',";
		}
		d = listDiaDiem.get(i);
		dataDiaDiem += "'" + d.getIdDiaDiem() + "':'" + d.getTenDiaDiem() +"'}\"";
		request.setAttribute("listTuyen", listTuyen);
		request.setAttribute("listDiaDiem", listDiaDiem);
		request.setAttribute("dataDiaDiem", dataDiaDiem);
		request.getRequestDispatcher(DuongDan.THEM_TUYEN_SVL).forward(request, response);
	}

}
