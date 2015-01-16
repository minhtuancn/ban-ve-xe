package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet("/timtuyen")
public class TimTuyen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TuyenDAO tuyenDAO;

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
		tuyenDAO = (TuyenDAO) new FactoryDAOImp()
				.createDAO(FactoryDao.TUYEN_DAO);
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
		String idTuyen = request.getParameter("idTuyen");
		String mes = null;
		int typeError = -1;
		long idNoiDi = 0;
		// lay ngay hien tai
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date now = cal.getTime();
		System.out.println(now);
		if (idTuyen == null) {
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
				if (ngaydi == null)
					throw new ParseException("", 0);
				dateNgayDi = f.parse(ngaydi);
				System.out.println(dateNgayDi);
				System.out.println(dateNgayDi.compareTo(now));
				if (dateNgayDi.compareTo(now) < 0) {
					mes = "Ngày đi không được nhỏ hơn ngày hiện tại";
					request.setAttribute("mes", mes);
					typeError = 2;
					request.setAttribute("typeError", typeError);
					request.getRequestDispatcher(DuongDan.TRANG_CHU_SVL)
							.forward(request, response);
					return;
				}
			} catch (ParseException e) {
				mes = "Ngày đi không đúng định dạng";
				request.setAttribute("mes", mes);
				typeError = 2;
				request.setAttribute("typeError", typeError);
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
					if (dateNgayVe.compareTo(now) < 0) {
						mes = "Ngày về không được nhỏ hơn ngày hiện tại";
						request.setAttribute("mes", mes);
						typeError = 2;
						request.setAttribute("typeError", typeError);
						request.getRequestDispatcher(DuongDan.TRANG_CHU_SVL)
								.forward(request, response);
						return;
					}
				} catch (ParseException e) {
					mes = "Ngày về không đúng định dạng";
					request.setAttribute("mes", mes);
					typeError = 3;
					request.setAttribute("typeError", typeError);
					request.getRequestDispatcher(DuongDan.TRANG_CHU_SVL)
							.forward(request, response);
					return;
				}
			}
			Tuyen tuyen = tuyenDAO.getTuyen(idNoiDi, idNoiDen, dateNgayDi,
					false);
			if (tuyen == null) {
				mes = "Tuyến Đi không có, xin vui lòng chọn chuyến khác!";
				request.setAttribute("mes", mes);
				request.getRequestDispatcher(DuongDan.TRANG_CHU_SVL).forward(
						request, response);
				return;
			} else {
				session.setAttribute("tuyenDi", tuyen);
			}
			if (laKhuHoi_bool) {
				tuyen = tuyenDAO.getTuyen(idNoiDen, idNoiDi, dateNgayVe, false);
				if (tuyen == null) {
					mes = "Tuyến Về không có, xin vui lòng chọn chuyến khác!";
					request.setAttribute("mes", mes);
					request.getRequestDispatcher(DuongDan.TRANG_CHU_SVL)
							.forward(request, response);
					return;
				} else
					session.setAttribute("tuyenVe", tuyen);
			}
		} else {
			// Tuyen tuyen = tuyenDAO.getTuyen();
			Tuyen tuyen = null;
			long idTuyeni = Long.parseLong(idTuyen);
			// System.out.println("TimChuyen " + tuyen);
			List<Tuyen> list = (List<Tuyen>) session.getAttribute("listTuyen");
			for (Tuyen t : list) {
				if (t.getIdTuyen() == idTuyeni) {
					tuyen = t;
					break;
				}
			}
			session.setAttribute("laKhuHoi", false);
			session.setAttribute("tuyenDi", tuyen);
		}
		request.getRequestDispatcher(DuongDan.TIM_CHUYEN_SVL).forward(request,
				response);
		// response.sendRedirect(DuongDan.TIM_CHUYEN);

	}
}
