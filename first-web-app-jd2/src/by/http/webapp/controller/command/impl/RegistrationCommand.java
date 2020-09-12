package by.http.webapp.controller.command.impl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.http.webapp.controller.command.Command;
import by.http.webapp.service.Service;
import by.http.webapp.service.ServiceFactory;
import by.http.webapp.service.exception.ServiceException;

public class RegistrationCommand implements Command{
	
	private final ServiceFactory factory = ServiceFactory.getInstance();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service service = factory.getRegistrationService();
		try {
			service.execute(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
