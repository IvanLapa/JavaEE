package by.http.webapp.dao;

import by.http.webapp.dao.exception.DAOException;

public interface UserDAO {

	void signIn(String login, String password) throws DAOException;
	void registartion(String name, String surname, String login, String password) throws DAOException;
	public boolean userPresenceInSystem(String login, String password) throws DAOException;
	
}
