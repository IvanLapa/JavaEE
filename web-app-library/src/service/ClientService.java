package service;

import bean.User;
import service.exception.ServiceException;

public interface ClientService {
	void singIn(String login, char[] password) throws ServiceException;
	void singOut(String login)throws ServiceException;
	void registration(User user)throws ServiceException;
}
