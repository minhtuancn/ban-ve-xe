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
import model.Chuyen;
import model.DatVe;
import model.Tuyen;

/**
 * Servlet implementation class TimGhe
 */
public class TimGhe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ChuyenDAO chuyenDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TimGhe() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void init() throws ServletException {
		super.init();
		chuyenDAO = (ChuyenDAO) new FactoryDAOImp().createDAO(FactoryDao.CHUYEN_DAO);
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
		boolean laKhuhoi = (boolean) session.getAttribute("laKhuHoi");
		
		String ids = request.getParameter("id");
		String chuyens = request.getParameter("chuyen");
		if (ids != null && chuyens != null) {
			int id = Integer.parseInt(ids);
			int chuyen = Integer.parseInt(chuyens);
			session.setAttribute("chuyen", chuyen);
			if (chuyen == 1) {
//				Chuyen c = ((Tuyen) session.getAttribute("tuyenDi"))
//						.getDanhSachChuyen().get(id);
				Tuyen tuyen  = (Tuyen) session.getAttribute("tuyenDi");
				Chuyen c = chuyenDAO.getChuyen(tuyen.getDanhSachChuyen().get(id).getIdChuyen(), tuyen);
				session.setAttribute("chuyenDi", c);
				DatVe datVeDi = new DatVe(c);
				session.setAttribute("datVeDi", datVeDi);
				// response.sendRedirect("/jsp/datve.jsp");
				request.getRequestDispatcher("/jsp/datvedi.jsp").forward(
						request, response);
			} else {
//				Chuyen c = ((Tuyen) session.getAttribute("tuyenVe"))
//						.getDanhSachChuyen().get(id);
				Tuyen tuyen  = (Tuyen) session.getAttribute("tuyenVe");
				Chuyen c = chuyenDAO.getChuyen(tuyen.getDanhSachChuyen().get(id).getIdChuyen(), tuyen);
				session.setAttribute("chuyenVe", c); 
				DatVe datVeDi = new DatVe(c); 
				session.setAttribute("datVeVe", datVeDi);
				// response.sendRedirect("/jsp/datve.jsp");
				request.getRequestDispatcher("/jsp/datveve.jsp").forward(
						request, response);
			}
		}else{
			response.sendRedirect("/BanVeXe/jsp/body.jsp");
			
		}
	}
}
