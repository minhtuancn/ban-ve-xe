package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GenerateCaptcha
 */
@WebServlet ("/generatecaptcha")
public class GenerateCaptcha extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateCaptcha() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int w = 100;
		int h = 40;
		BufferedImage im = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = im.createGraphics();
		int n = new Random().nextInt(8999)+1000;
		g.setColor(Color.white);
		g.fillRect(0, 0, w, h);
		g.setFont(new Font("Colonna MT",Font.BOLD, 30));
		g.setColor(Color.red);
		g.drawString(n + "", 10, 30);
		response.setContentType("image/jpg");
		ImageIO.write(im, "jpg", response.getOutputStream());
		g.dispose();
		HttpSession session = request.getSession();
		session.setAttribute("captcha", n+"");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
