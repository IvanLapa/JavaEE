package by.http.webapp.service.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.webapp.dao.DAOFactory;
import by.http.webapp.dao.UserDAO;
import by.http.webapp.dao.exception.DAOException;
import by.http.webapp.entity.RegistrationUser;
import by.http.webapp.service.Service;
import by.http.webapp.service.ServiceFactory;
import by.http.webapp.service.exception.ServiceException;

public class RegistrationService implements Service{
	private final DAOFactory instance = DAOFactory.getInstance();
	private final UserDAO sqlUserDAO = instance.getUserDAO();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");

		try {
			if(sqlUserDAO.userPresenceInSystem(login,password)) {
				try {
					request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					throw new ServiceException(e);
				}
			} else {
				sqlUserDAO.registartion(name, surname, login, password);
				RegistrationUser regUser = new RegistrationUser(name, surname, login, password);
				
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
