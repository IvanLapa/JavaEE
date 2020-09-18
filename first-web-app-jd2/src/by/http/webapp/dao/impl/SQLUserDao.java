package by.http.webapp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import by.http.webapp.dao.UserDAO;
import by.http.webapp.dao.exception.DAOException;
import by.http.webapp.entity.RegistrationUser;
import by.http.webapp.entity.User;

public class SQLUserDao implements UserDAO {
	private static final String URL = "jdbc:mysql://localhost/jd2-first-db?useSSl=false&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String SELECT = "SELECT * FROM `jd2-first-db`.users\r\n" + "WHERE users.login =? AND users.password=?;";
	
	
	
	@Override
	public void signIn(String login, String password) {
		
		
		
	}

	@SuppressWarnings("resource")
	@Override
	public void registartion(String name, String surname, String login, String password) throws DAOException {
		
		
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			ps = con.prepareStatement(SELECT);
			ps.setString(1, login);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			if(!rs.next()) {
				RegistrationUser user = new RegistrationUser();
				user.setName(name);
				user.setSurname(surname);
				user.setLogin(login);
				user.setPassword(password);
				
				String sql = "INSERT INTO users(login, password, name, surname) VALUES(?, ?, ?, ?)";
				ps = con.prepareStatement(sql);
				
				ps.setString(1, login);
				ps.setString(2, password);
				ps.setString(3, name);
				ps.setString(4, surname);
				
				ps.executeUpdate();
			} 			
			
		} catch(Exception e) {
			throw new DAOException(e);
		} finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			}
			
			if(rs!=null) {
				try {
					rs.close();
				} catch(SQLException e) {
					throw new DAOException(e);
				}
			}
			
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			}
		}
		
	}
	
	@Override
	public boolean userPresenceInSystem(String login, String password) throws DAOException {
		
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		boolean flag = false;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			ps = con.prepareStatement(SELECT);
			ps.setString(1, login);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				flag=true;
				return flag;
			} else return flag;
			} catch(SQLException | ClassNotFoundException e) {
				throw new DAOException(e);
			} 
		}

}
