package _java._ee._01._servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServletConfig config;

	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String param = (String) config.getServletContext().getAttribute(
				"myparam");
		if (param == null) {
			config.getServletContext().setAttribute("myparam", "servlet2");
			response.getWriter().println("myparam = servlet2 set first<br/>");
		}
		response.getWriter().println(
				"From Servlet2 - "
						+ config.getServletContext().getAttribute("myparam"));
	}

}


