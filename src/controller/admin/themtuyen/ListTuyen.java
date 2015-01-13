package controller.admin.themtuyen;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.generic.LLOAD;

import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import util.DuongDan;
import DAO.DiaDiemDAO;
import DAO.TuyenDAO;
import DAO.TuyenDAOImpl;
import model.DiaDiem;
import model.NhanVien;
import model.Tuyen;

/**
 * Servlet implementation class ListTuyen
 */
@WebServlet ("/listtuyen")
public class ListTuyen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TuyenDAO tuyenDAO;
	private DiaDiemDAO diaDiemDAO;
	private final String quyen = "themtuyen";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListTuyen() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		super.init();
		FactoryDao f = new FactoryDAOImp();
		tuyenDAO = (TuyenDAO) f.createDAO(FactoryDao.TUYEN_DAO);
		diaDiemDAO = (DiaDiemDAO) f.createDAO(FactoryDao.DIA_DIEM_DAO);
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
		String pageFoward = null;
		if (nv != null) {
			if (nv.getQuyen().contains(this.quyen)) {
				List<Tuyen> listTuyen = tuyenDAO.getAllTuyen();
				List<DiaDiem> listDiaDiem = diaDiemDAO.getAllDiaDiem();
				String dataDiaDiem = "\"{";
				DiaDiem d;
				int i = 0;
				for (i = 0; i < listDiaDiem.size() - 1; i++) {
					d = listDiaDiem.get(i);
					dataDiaDiem += "'" + d.getIdDiaDiem() + "':'"
							+ d.getTenDiaDiem() + "',";
				}
				d = listDiaDiem.get(i);
				dataDiaDiem += "'" + d.getIdDiaDiem() + "':'"
						+ d.getTenDiaDiem() + "'}\"";
				request.setAttribute("listTuyen", listTuyen);
				request.setAttribute("listDiaDiem", listDiaDiem);
				request.setAttribute("dataDiaDiem", dataDiaDiem);
				 pageFoward = DuongDan.THEM_TUYEN_SVL;
			}else{
				pageFoward = DuongDan.KHONG_CO_QUYEN;
			}
		} else {
			request.setAttribute("pageFoward", DuongDan.LIST_TUYEN_SV);
			 pageFoward = DuongDan.DANG_NHAP_ADMIN_SVL;
		}
		request.getRequestDispatcher(pageFoward).forward(
				request, response);
	}
}
