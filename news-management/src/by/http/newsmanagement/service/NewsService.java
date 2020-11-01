package by.http.newsmanagement.service;

import java.util.List;

import by.http.newsmanagement.entity.News;

public interface NewsService {
	
	public void createNews(News news) throws ServiceException;
	
	public void updateNews(News news) throws ServiceException;
	
	public void deleteNews(int id) throws ServiceException;
	
	public News selectNewsById (int id) throws ServiceException;
	
	public List<News> allNews() throws ServiceException;	
}
