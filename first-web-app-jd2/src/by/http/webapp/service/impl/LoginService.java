package by.http.webapp.service.impl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.http.webapp.dao.DAOFactory;
import by.http.webapp.dao.UserDAO;
import by.http.webapp.dao.exception.DAOException;
import by.http.webapp.service.Service;
import by.http.webapp.service.exception.ServiceException;

public class LoginService implements Service{
	private static final DAOFactory instance = DAOFactory.getInstance();
	private final UserDAO sqlUserDAO = instance.getUserDAO();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		try {
			if(sqlUserDAO.userPresenceInSystem(login, password)) {
				sqlUserDAO.signIn(login, password);
				response.setContentType("text/html");
				response.getWriter().write("<h1>Succsesfull logination, hello!!</h1>");
			} else {
				request.getRequestDispatcher("WEB-INF/jsp/registration.jsp").forward(request, response);
			}
		} catch (DAOException | IOException | ServletException e) {
			throw new ServiceException(e);
		}
	}
}
