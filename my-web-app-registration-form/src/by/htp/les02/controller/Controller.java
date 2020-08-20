package by.htp.les02.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.les02.entity.User;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String first_name=request.getParameter("First name");
		String login=request.getParameter("Login");
		String password=request.getParameter("Password");
		String phone_number=request.getParameter("Phone number");
		String political_view=request.getParameter("Political View");
		
		User user = new User();
		
		user.setFirstName(first_name);
		user.setLogin(login);
		user.setPassword(password);
		user.setPhoneNumder(phone_number);
		user.setPoliticalView(political_view);
		
		request.setAttribute("user", user);
	
		RequestDispatcher requestDispather = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		requestDispather.forward(request, response);
		}
	
}
