package by.http.newsmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.http.newsmanagement.dao.NewsDao;
import by.http.newsmanagement.dao.pool.ConnectionPool;
import by.http.newsmanagement.entity.News;
import by.http.newsmanagement.exception.DaoException;

public class SQLNews implements NewsDao{
	
	private final ConnectionPool pool = ConnectionPool.getInstance();

	private static final String NEW_NEWS_CREATE_QUARY = "INSERT INTO news(id, title, brief, content, date) VALUES(?,?,?,?,?)";
	private static final String DELETE_NEWS_QUARY = "DELETE FROM news WHERE id = ?";
	private static final String UPDATE_NEWS_QUARY = "UPDATE news SET date = ? , section = ? , author = ? , \"\r\n" + 
			"			 + \"brief = ? , content = ? \"\r\n" + 
			"			 + \"WHERE id = ?\"";
	private static final String SELECT_ALLNEWS = "SELECT * FROM news";
	
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
	public void updateNews(News news) throws DaoException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
		con = pool.takeConnection();
		ps = con.prepareStatement(UPDATE_NEWS_QUARY);
		
		//ps.setDate(1, Date.valueOf(news.getDate()));
		ps.setString(2, news.getTitle());
		ps.setString(3, news.getBrief());
		ps.setString(4, news.getContent());
		ps.setInt(5, news.getId());
		ps.executeUpdate();

		} catch (SQLException e) {
		throw new DaoException(e);
		} finally {
		pool.closeConnection(con, ps);
		}	
	}

	@Override
	public void deleteNews(int id) throws DaoException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = pool.takeConnection();
			ps = con.prepareStatement(DELETE_NEWS_QUARY);

			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			pool.closeConnection(con, ps);
		}
		
	}

	@Override
	public News selectNewsById(int id) throws DaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		News newspaper = new News();;
		
		LocalDate date = null;
		String section = null;
		String author = null;
		String brief = null;
		String content = null;
		
		try {
		con = pool.takeConnection();
		ps = con.prepareStatement(SQL_SELECT_BY_ID);
		
		ps.setInt(1, id);
		rs = ps.executeQuery();
		
		if(rs.next()) {
		
			id = rs.getInt(1);
			date = rs.getDate("date").toLocalDate();
			section = rs.getString(3);
			author = rs.getString(4);
			brief = rs.getString(5);
			content = rs.getString(6);
			
			newspaper.setId(id);
			newspaper.setDate(date);
			newspaper.setSection(section);
			newspaper.setAuthor(author);
			newspaper.setBrief(brief);;
			newspaper.setContent(content);
		
		}
		
//		while(rs.next()) {

			
	//	}	
			
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			pool.closeConnection(con, ps, rs);
		}
		
		return newspaper;
	}
	}

	@Override
	public List<News> all() throws DaoException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		int id = 0;
		LocalDate date = null;
		String section = null;
		String author = null;
		String brief = null;
		String content = null;
		
		List<News> selectAll = new ArrayList<>();
		
		try {
			con = pool.takeConnection();
			st = con.createStatement();
			rs = st.executeQuery(SELECT_ALLNEWS);
			
			
			
			while(rs.next()) {
				
				News news = new News();
				
				id = rs.getInt(1);
				date = rs.getDate("date").toLocalDate();
				section = rs.getString(3);
				author = rs.getString(4);
				brief = rs.getString(5);
				content = rs.getString(6);
				
				news.setId(id);
				news.setDate(date);
				news.setSection(section);
				news.setAuthor(author);
				news.setBrief(brief);;
				news.setContent(content);
				
				selectAll.add(news);
				}
			
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			pool.closeConnection(con, st, rs);
		}
		return selectAll;
	}
}
