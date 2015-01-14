package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DuongDan;
import model.Ve;
import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.GheDAO;
import DAO.KhachHangDAO;
import DAO.ThanhToanDAO;
import DAO.VeDAO;

/**
 * Servlet implementation class HuyVe
 */
@WebServlet ("/huyve")
public class HuyVe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VeDAO veDAO;
	private KhachHangDAO khachHangDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HuyVe() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		super.init();
		FactoryDao f = new FactoryDAOImp();
		veDAO = (VeDAO) f.createDAO(FactoryDao.VE_DAO);
		khachHangDAO = (KhachHangDAO) f.createDAO(FactoryDao.KHACH_HANG_DAO);
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
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String mave = request.getParameter("mave");
		String otp = request.getParameter("otp");
		String maOTP = (String) request.getSession().getAttribute("maOTP");
		String mes = "";
		String mesSucces = "";
		if(maOTP.equals(otp)){
		Ve ve = (Ve) veDAO.timVeOfMaVe(mave);
		mes = khachHangDAO.huyVe(ve);
		mesSucces = mes == null ? "Hủy Vé thành công!" : null;
		}else{
			mes = "Mã OTP không chính xác, quí khách vui lòng nhập lại!";
		}
		request.setAttribute("mes", mes);
		request.setAttribute("mesSuccess", mesSucces);
		request.getRequestDispatcher("kiemtrave").forward(
				request, response);
	}
}
