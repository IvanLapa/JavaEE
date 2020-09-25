package by.http.newsmanagement.dao;

import java.util.List;

import by.http.newsmanagement.entity.News;
import by.http.newsmanagement.exception.DaoException;

public interface NewsDao {

	void createNews(News news) throws DaoException;
	void updateNews (News news) throws DaoException;
	void deleteNews(int id) throws DaoException;
	
	News byId (int id) throws DaoException;
	List<News> all () throws DaoException;	
}
