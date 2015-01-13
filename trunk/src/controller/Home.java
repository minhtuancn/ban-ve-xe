package controller;

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

import model.DiaDiem;
import model.Tuyen;
import util.DuongDan;
import DAO.DiaDiemDAO;
import DAO.TuyenDAO;
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;

/**
 * Servlet implementation class Home
 */
@WebServlet ("/trangchu")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DiaDiemDAO diaDiemDAO;
	private TuyenDAO tuyenDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Home() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		super.init();
		diaDiemDAO = (DiaDiemDAO) new FactoryDAOImp()
				.createDAO(FactoryDao.DIA_DIEM_DAO);
		tuyenDAO = (TuyenDAO) new FactoryDAOImp().createDAO(FactoryDao.TUYEN_DAO);
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
//		try {
			
			List<DiaDiem> listDiaDiem = diaDiemDAO.getAllDiaDiem();
//			List<Tuyen> listTuyen = tuyenDAO.getTuyen(new Date());
			
			SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
			List<Tuyen> listTuyen = null;
			try {
				listTuyen = tuyenDAO.getTuyen(f.parse("16-01-2015"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			request.getSession().setAttribute("listDiaDiem", listDiaDiem);
			request.getSession().setAttribute("listTuyen", listTuyen);
			response.sendRedirect(DuongDan.TRANG_CHU);
//		} catch (NullPointerException e) {
//			throw new ServletException(e);
//		}
	}

}
