package _java._ee._01._servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		String encodeURL = response.encodeURL(request.getContextPath()) + "/Controller";
		
		request.setAttribute("encodeURL", encodeURL);
		
		System.out.println("encodeURL" + encodeURL);
		System.out.println("sessionID" + session.getId());
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
