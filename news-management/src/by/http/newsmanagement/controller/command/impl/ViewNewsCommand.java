package by.http.newsmanagement.controller.command.impl;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.newsmanagement.controller.command.Command;
import by.http.newsmanagement.entity.News;
import by.http.newsmanagement.service.ServiceException;
import by.http.newsmanagement.service.ServiceProvider;

public class ViewNewsCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String page;
		String name;
		String value;
		
		try {
			News news = new News();
			news.setId(Integer.parseInt(request.getParameter("id")));
			news.setDate(LocalDate.parse(request.getParameter("newsDate")));
			news.setTitle(request.getParameter("newsTitle"));
			news.setBrief(request.getParameter("newsBrief"));
			news.setContent(request.getParameter("newsContent"));
			
			ServiceProvider.getInstance().getNewsService().updateNews(news);
			
			page = Page.CONTROLLER;
			name = "command";
			value = "view_all_news";
		} catch (ServiceException e) {
			page = Page.ERROR_PAGE;
			name = "errorMessage";
			value = "Ooops, something went wrong";
		}
		response.sendRedirect(page + "?" + name + "=" + value);
	}
}
