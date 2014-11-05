

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckGhe
 */
public class CheckGhe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckGhe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		String ghe = request.getParameter("id");
		int n_ghe = Integer.parseInt(ghe);
		if(n_ghe>10){
			response.getWriter().write("1");
		}else{
			response.getWriter().write("0");
		}
		response.getWriter().write("ok");
		System.out.println("done");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		String ghe = request.getParameter("id");
		int n_ghe = Integer.parseInt(ghe);
		if(n_ghe>5){
			response.getWriter().print("1");
		}else{
			response.getWriter().print("0");
		}
	}

}
