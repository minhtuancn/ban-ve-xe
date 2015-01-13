package controller.admin.themchuyen;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Chuyen;
import model.Tuyen;
import util.DuongDan;
import DAO.ChuyenDAO;
import DAO.TuyenDAO;
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;

/**
 * Servlet implementation class ListChuyen
 */
@WebServlet ("/listchuyen")
public class ListChuyen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ChuyenDAO chuyenDAO;
	private TuyenDAO tuyenDAO;
	private SimpleDateFormat format;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListChuyen() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		FactoryDao f = new FactoryDAOImp();
		chuyenDAO = (ChuyenDAO) f.createDAO(FactoryDao.CHUYEN_DAO);
		tuyenDAO = (TuyenDAO) f.createDAO(FactoryDao.TUYEN_DAO);
		format = new SimpleDateFormat("yyyy-MM-dd");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		List<Tuyen> listTuyen = tuyenDAO.getAllTuyen();
		session.setAttribute("listTuyen", listTuyen);
		String pageFoward = null;
		//
		// if (nv != null) {
		// if (nv.getQuyen().contains(this.quyen)) {
		String tuyen = "";
		if (request.getParameter("tuyen") != null)
			tuyen = request.getParameter("tuyen");
		String date = "";
		if (request.getParameter("date") != null)
			date = request.getParameter("date");
		if (!date.equals("") && !tuyen.equals("")) {
			String mes = "";
			long idTuyen = 1;
			try {
				idTuyen = Long.parseLong(tuyen);
				Date dateS = format.parse(date);
				Tuyen t = tuyenDAO.getTuyen(idTuyen);
				t.setNgayDi(dateS);
				List<Chuyen> listChuyen = chuyenDAO
						.getAllChuyen(t, dateS, true);
				session.setAttribute("date", date);
				session.setAttribute("idTuyen", idTuyen);
				session.setAttribute("listChuyen", listChuyen);
				session.setAttribute("tuyen", t);
			} catch (ParseException e) {
				mes = "Ngày sai định dạng!";
			} catch (NumberFormatException e) {
				mes = "Mã tuyến phải là số";
			}
			request.setAttribute("mes", mes);
		}
		request.getRequestDispatcher(DuongDan.DSCHUYEN_SVL).forward(request,
				response);
	}
	// }else{
	// pageFoward = DuongDan.KHONG_CO_QUYEN;
	// }

}
