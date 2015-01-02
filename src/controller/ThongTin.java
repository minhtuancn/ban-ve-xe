package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.ChuyenDAO;
import DAO.KhachHangDAO;
import DAO.VeDAO;
import util.DuongDan;
import util.LayMaVe;
import util.SendMessage;
import util.SendMessageUtil;
import model.Chuyen;
import model.DatVe;
import model.KhachHang;
import model.KhachHangThuongXuyen;
import model.KhachHangVangLai;
import model.Tuyen;
import model.Ve;

/**
 * Servlet implementation class ThongTin
 */
public class ThongTin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VeDAO veDAO;
	private KhachHangDAO khachHangDAO;
	private ChuyenDAO chuyenDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThongTin() {
		super();

	}

	@Override
	public void init() throws ServletException {
		super.init();
		veDAO = (VeDAO) new FactoryDAOImp().createDAO(FactoryDao.VE_DAO);
		chuyenDAO = (ChuyenDAO) new FactoryDAOImp()
				.createDAO(FactoryDao.CHUYEN_DAO);
		khachHangDAO = (KhachHangDAO) new FactoryDAOImp()
				.createDAO(FactoryDao.KHACH_HANG_DAO);

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
		KhachHang kh = null;
		if (session.getAttribute("khachHang") != null)
			kh = (KhachHang) session.getAttribute("khachHang");
		String sghiChu = request.getParameter("ghichu");
		String scaptcha = "";
		if (request.getParameter("captcha") != null)
			scaptcha = request.getParameter("captcha");
		System.out.println("ThongTin " + scaptcha);
		boolean laKhuHoi = (Boolean) session.getAttribute("laKhuHoi");
		if (scaptcha.equals(((String) session.getAttribute("captcha")))) {
			Ve veDi = new Ve(kh, LayMaVe.getInstant().getMaVe(LayMaVe.SO_KY_TU_MAVE),
					(DatVe) session.getAttribute("datVeDi"), sghiChu);
			String luuVe = veDAO.addVe(veDi);
			if (null != luuVe) {
				session.setAttribute("captcha", null);
				request.setAttribute("mes", luuVe);
				request.getRequestDispatcher(DuongDan.TIM_CHUYEN_SVL).forward(
						request, response);
				return;
			}
			Ve veVe = null;
			if (laKhuHoi) {
				veVe = new Ve(kh, LayMaVe.getInstant().getMaVe(LayMaVe.SO_KY_TU_MAVE),
						(DatVe) session.getAttribute("datVeVe"), sghiChu);
				luuVe = veDAO.addVe(veVe);
				if (null != luuVe) {
					request.setAttribute("mes", luuVe);
					request.getRequestDispatcher(DuongDan.TIM_CHUYEN_SVL)
							.forward(request, response);
					return;
				}
			}
			session.setAttribute("veDi", veDi);
			SendMessageUtil.getInstance().sendTicket(
					veDi.getKhachHang().getSdt(), veDi);
			if (laKhuHoi) {
				session.setAttribute("veVe", veVe);
				SendMessageUtil.getInstance().sendTicket(
						veVe.getKhachHang().getSdt(), veVe);
			}
			response.sendRedirect(DuongDan.CHI_TIET_VE);

		} else {
			request.getRequestDispatcher(DuongDan.TIM_CHUYEN_SVL).forward(
					request, response);
		}
	}

}
