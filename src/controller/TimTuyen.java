package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Tuyen;
import util.DuongDan;
import DAO.TuyenDAO;
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;

/**
 * Servlet implementation class TimTuyen
 */
public class TimTuyen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Tuyen tuyenModel;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TimTuyen() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		tuyenModel = new Tuyen();
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
		String idnoidi = request.getParameter("idnoidi");
		String idnoiden = request.getParameter("idnoiden");
		String ngaydi = request.getParameter("ngaydi");
		String ngayve = request.getParameter("ngayve");
		String laKhuHoi = request.getParameter("laKhuHoi");
		String mes = null;
		int typeError = -1;
		long idNoiDi = 0;
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		try {
			idNoiDi = Long.parseLong(idnoidi);
		} catch (NumberFormatException e) {
			mes = "Địa điểm đi không tồn tại!";
			request.setAttribute("mes", mes);
			typeError = 0;
			request.setAttribute("typeError", typeError);
			request.getRequestDispatcher(DuongDan.TRANG_CHU_SVL).forward(
					request, response);
			return;
		}
		long idNoiDen = 0;
		try {
			idNoiDen = Long.parseLong(idnoiden);
		} catch (NumberFormatException e) {
			mes = "Địa điểm đến không tồn tại!";
			request.setAttribute("mes", mes);
			typeError = 1;
			request.setAttribute("typeError", typeError);
			request.getRequestDispatcher(DuongDan.TRANG_CHU_SVL).forward(
					request, response);
			return;
		}
		Date dateNgayDi;
		try {
			dateNgayDi = f.parse(ngaydi);
		} catch (ParseException e) {
			mes = "Ngày đi không đúng định dạng";
			request.setAttribute("mes", mes);
			typeError = 2;
			request.setAttribute("typeError", typeError);
			System.out.println(typeError);
			request.getRequestDispatcher(DuongDan.TRANG_CHU_SVL).forward(
					request, response);
			return;
		}
		boolean laKhuHoi_bool = "on".equals(laKhuHoi);
		session.setAttribute("laKhuHoi", laKhuHoi_bool);
		Date dateNgayVe = null;
		if (laKhuHoi_bool) {
			try {
				dateNgayVe = f.parse(ngayve);
			} catch (ParseException e) {
				mes = "Ngày về không đúng định dạng";
				request.setAttribute("mes", mes);
				typeError = 3;
				request.setAttribute("typeError", typeError);
				request.getRequestDispatcher(DuongDan.TRANG_CHU_SVL).forward(
						request, response);
				return;
			}
		}
		Tuyen tuyen = tuyenModel.getTuyen(idNoiDi, idNoiDen, dateNgayDi);
		if (tuyen == null) {
			mes = "Tuyến Đi không có, xin vui lòng chọn chuyến khác!";
			request.setAttribute("mes", mes);
			request.getRequestDispatcher(DuongDan.TRANG_CHU_SVL).forward(
					request, response);
			return;
		} else{
			System.out.println(tuyen.getTuyenXe());
			session.setAttribute("tuyenDi", tuyen);
		}
		if (laKhuHoi_bool) {
			tuyen = tuyenModel.getTuyen(idNoiDen, idNoiDi, dateNgayVe);
			if (tuyen == null) {
				mes = "Tuyến Về không có, xin vui lòng chọn chuyến khác!";
				request.setAttribute("mes", mes);
				request.getRequestDispatcher(DuongDan.TRANG_CHU_SVL).forward(
						request, response);
				return;
			} else
				session.setAttribute("tuyenVe", tuyen);
		}
		request.getRequestDispatcher(DuongDan.TIM_CHUYEN_SVL).forward(request,
				response);

	}

}
