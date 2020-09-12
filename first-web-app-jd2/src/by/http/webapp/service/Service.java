package by.http.webapp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.http.webapp.service.exception.ServiceException;

public interface Service {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException;
}
