package controller.admin.themdiadiem;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DuongDan;
import model.DiaDiem;
import model.NhanVien;
import DAO.DiaDiemDAO;
import DAO.DiaDiemDAOImpl;

/**
 * Servlet implementation class ListDiaDiem
 */
@WebServlet ("/listdiadiem")
public class ListDiaDiem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String quyen = "themdiadiem";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListDiaDiem() {
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
		HttpSession session = request.getSession();
		NhanVien nv = (NhanVien) session.getAttribute("admin");
		String pageForward = null;
		if (nv != null) {
			if (nv.getQuyen().contains(this.quyen)) {
				DiaDiemDAO diadiem = new DiaDiemDAOImpl();
				List<DiaDiem> listDiaDiem = diadiem.getAllDiaDiem();
				request.setAttribute("listDiaDiem", listDiaDiem);
				pageForward =  DuongDan.THEM_DIADIEM_SVL;
			}else{
				pageForward = DuongDan.KHONG_CO_QUYEN;
			}
		} else {
			request.setAttribute("pageFoward", DuongDan.LIST_DIA_DIEM_SV);
			pageForward = DuongDan.DANG_NHAP_ADMIN_SVL; 
		}
		request.getRequestDispatcher(pageForward).forward(
				request, response);
	}
}
