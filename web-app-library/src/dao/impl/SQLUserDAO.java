package dao.impl;

import bean.User;
import dao.UserDAO;
import dao.exception.DAOException;

public class SQLUserDAO implements UserDAO{
	@Override
	public void signIn(String login, String password) throws DAOException{
		// ������ � ���� ������ �� ����������� � ����� ������ � ��������� ������������ ������ � ������
	}
	@Override
	public void registration(User user) throws DAOException{
	}
}
