package controller.admin.themchuyen;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.NhanVien;
import model.Tuyen;
import util.DuongDan;
import DAO.TuyenDAO;
import DAO.TuyenDAOImpl;

/**
 * Servlet implementation class Kiemtrachuyen
 */
public class Kiemtrachuyen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kiemtrachuyen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		NhanVien nv = (NhanVien) session.getAttribute("admin");
		if(nv!=null){
		// TODO Auto-generated method stub
		TuyenDAO tuyenDAO = new TuyenDAOImpl();
		List<Tuyen> listTuyen = tuyenDAO.getAllTuyen();
		session.setAttribute("listTuyen", listTuyen);
		//
		String idTuyenSelected = "0";
		if(request.getParameter("idTuyenSelected") != null)
			idTuyenSelected = request.getParameter("idTuyenSelected");
		//
		String date = "17-12-2014";
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		if(request.getParameter("date") != null)
			date = request.getParameter("date");
		Date selectedDate ;
		if(date.equals(""))
			selectedDate = new Date();
		else
			try {
				selectedDate = f.parse(date);
			} catch (ParseException e) {
				selectedDate = new Date();
			}
		
		Tuyen tuyen = listTuyen.get(Integer.parseInt(idTuyenSelected));
		System.out.println(tuyen);
		request.setAttribute("tuyen", tuyen);
		
		request.getRequestDispatcher(DuongDan.DSCHUYEN_SVL).forward(request, response);
	}else{
		request.setAttribute("pageFoward", DuongDan.KIEM_TRA_CHUYEN_SV);
		request.getRequestDispatcher(DuongDan.DANG_NHAP_ADMIN_SVL).forward(request, response);
	}

	}

}
