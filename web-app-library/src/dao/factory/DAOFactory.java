package dao.factory;

import dao.BookDao;
import dao.UserDAO;
import dao.impl.SQLBookDao;
import dao.impl.SQLUserDAO;

public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();
	private final BookDao sqlBookImpl = new SQLBookDao();
	private final UserDAO sqlUserImpl = new SQLUserDAO();
	private DAOFactory(){}
	public static DAOFactory getInstance(){
	return instance;
	}
	public BookDao getBookDAO(){
	return sqlBookImpl;
	}
	public UserDAO getUserDAO(){
	return sqlUserImpl;
	}
}
