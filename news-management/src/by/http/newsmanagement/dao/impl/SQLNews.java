package by.http.newsmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import by.http.newsmanagement.dao.NewsDao;
import by.http.newsmanagement.dao.pool.ConnectionPool;
import by.http.newsmanagement.entity.News;
import by.http.newsmanagement.exception.DaoException;

public class SQLNews implements NewsDao{
	
	private final ConnectionPool pool = ConnectionPool.getInstance();

	private static final String NEW_NEWS_CREATE_QUARY = "INSERT INTO news(id, title, brief, content, date) VALUES(?,?,?,?,?)";
	
	@Override
	public void createNews(News news) throws DaoException {
		Connection con=null;
		PreparedStatement ps = null;
		try {
		con = pool.takeConnection();
		
		ps = con.prepareStatement (NEW_NEWS_CREATE_QUARY);
		
		ps.setInt(1, news.getId());
		ps.setString(2, news.getTitle());
		ps.setString(3, news.getBrief());
		ps.setString(4, news.getContent());
		ps.setDate(5, java.sql.Date.valueOf(news.getDate()));
		
		ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			pool.closeConnection(con, ps);
		}
	}

	@Override
	public void update(News news) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteNews(int id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public News byId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<News> all() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
