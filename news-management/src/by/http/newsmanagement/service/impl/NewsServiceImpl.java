package by.http.newsmanagement.service.impl;

import java.time.LocalDate;
import java.util.List;

import by.http.newsmanagement.dao.DaoProvider;
import by.http.newsmanagement.dao.NewsDao;
import by.http.newsmanagement.entity.News;
import by.http.newsmanagement.exception.DaoException;
import by.http.newsmanagement.service.NewsService;
import by.http.newsmanagement.service.ServiceException;

public class NewsServiceImpl implements NewsService{
	private DaoProvider provider = DaoProvider.getInstance();
	private NewsDao newsDao = provider.getNewsDao();
	@Override
	public void createNews(News news) throws ServiceException {
		if (("").equals(news.getTitle())) {
			news.setTitle("Title");
		}
		if (("").equals(news.getBrief())) {
			news.setBrief("Brief");
		}
		
		try {
			newsDao.createNews(news);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void updateNews(News news) throws ServiceException {
		try {
			if(news.getDate()==null) {
			news.setDate(LocalDate.now());
			}
			newsDao.updateNews(news);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void deleteNews(int id) throws ServiceException {
		try {
			newsDao.deleteNews(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}		
	}

	@Override
	public News selectNewsById(int id) throws ServiceException {
		try {
			if(id == 0) {
				throw new ServiceException("No such news");
			}
			News news = newsDao.selectNewsById(id);
			return news;
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<News> allNews() throws ServiceException {
		try {
			List<News> newsList = newsDao.allNews();
			return newsList;
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
}
