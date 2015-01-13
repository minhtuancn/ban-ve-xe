package controller.admin.themdiadiem;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DiaDiemDAO;
import DAO.DiaDiemDAOImpl;
import DAO.TuyenDAO;
import DAO.TuyenDAOImpl;

/**
 * Servlet implementation class UpdateDiaDiem
 */
@WebServlet ("/updatediadiem")
public class UpdateDiaDiem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDiaDiem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String value = request.getParameter("value");
		try{
			int id = Integer.parseInt(request.getParameter("id"));
			DiaDiemDAO diaDiemDAO = new DiaDiemDAOImpl();
			if (!diaDiemDAO.editDiaDiem(id, value))
				value = "Update địa điểm không thành công";
			else{
				request.getSession().setAttribute("listDiaDiem", diaDiemDAO.getAllDiaDiem());
			}
			
		}catch (NumberFormatException e){
			value = "Lổi định dạng";
		}
		response.getWriter().print(value);
	}
}
