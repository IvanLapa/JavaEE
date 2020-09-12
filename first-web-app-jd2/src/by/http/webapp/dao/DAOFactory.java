package by.http.webapp.dao;

import by.http.webapp.dao.impl.SQLUserDao;

public class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();
	private final UserDAO sqlUserImpl = new SQLUserDao();
	
	public static DAOFactory getInstance() {
		return instance;
	}
	
	public UserDAO getUserDAO() {
		return sqlUserImpl;
	}
}
