package _java._ee._01._servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controller() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();//application
		ServletConfig servletConfig = getServletConfig();//servlet
		
		String name;
		String value;
		
		PrintWriter out = response.getWriter();
		
		Enumeration<?> initName = servletConfig.getInitParameterNames();
		out.println("init-params:<br/>" );
		while (initName.hasMoreElements()) {
			name = initName.nextElement().toString();
			value = servletConfig.getInitParameter(name);
			out.println(name + " - " + value + "<br/>");
		}
		
		Enumeration<?> initNameContext = servletContext.getInitParameterNames();
		out.println("<br/>context-params:<br/>" );
		while (initNameContext.hasMoreElements()){
			name = initNameContext.nextElement().toString();
			value = servletContext.getInitParameter(name);
			out.println(name + " - " + value + "<br/>");
		}		
	}
}
