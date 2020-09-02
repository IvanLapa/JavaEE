package _java._ee._02._servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import person.Person;

/**
 * Servlet implementation class ServletForJspElement
 */
@WebServlet("/ServletForJspElement")
public class ServletForJspElement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletForJspElement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
	
		//SimpleBean s = new SimpleBean();
		//s.setName(request.getParameter("name"));
		//s.setSurname(request.getParameter("surname"));
		//Object a = s;
		
		//request.setAttribute("mybean", a);
		
		List<Person> list = new ArrayList<>();
		list.add(new Person(30, "Ivan"));
		list.add(new Person(28, "Dmitriy"));
		
		
		if ("naming".equals(request.getParameter("command"))) request.getRequestDispatcher("jspusebean/usebean.jsp").forward(request, response);

	}

}
