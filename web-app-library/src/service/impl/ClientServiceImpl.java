package service.impl;

import bean.User;
import dao.UserDAO;
import dao.exception.DAOException;
import dao.factory.DAOFactory;
import service.ClientService;
import service.exception.ServiceException;

public class ClientServiceImpl implements ClientService{
	@Override
	public void singIn (String login, String password) throws ServiceException{
	// ��������� ���������
	if (login == null || login.isEmpty()) {
		throw new ServiceException("Incorrect login");
	}
	// ��������� ���������� ��������� ������������ � �������
	try {
	DAOFactory daoObjectFactory = DAOFactory.getInstance();
	UserDAO userDAO = daoObjectFactory.getUserDAO();
	userDAO.signIn(login, password);
	} catch (DAOException e) {
		throw new ServiceException(e);
	}
	//....
	}
	@Override
	public void singOut (String login) throws ServiceException{
	}
	
	@Override
	public void registration (User user) throws ServiceException{
	}
}
