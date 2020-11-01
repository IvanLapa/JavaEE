package by.http.newsmanagement.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.newsmanagement.controller.command.Command;
import by.http.newsmanagement.entity.News;
import by.http.newsmanagement.service.ServiceException;
import by.http.newsmanagement.service.ServiceProvider;

public class ToNewsPageCommand implements Command{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String page;
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			News news = ServiceProvider.getInstance().getNewsService().selectNewsById(id);
			page = Page.NEWS_PAGE;
			request.setAttribute("news", news);
		} catch (ServiceException e) {
			page = Page.ERROR_PAGE;
			request.setAttribute("errorMessage", "No news");
		}
		request.getRequestDispatcher(page).forward(request, response);
	}
}
