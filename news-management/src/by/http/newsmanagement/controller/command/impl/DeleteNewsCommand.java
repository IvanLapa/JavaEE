package by.http.newsmanagement.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.newsmanagement.controller.command.Command;
import by.http.newsmanagement.service.NewsService;
import by.http.newsmanagement.service.ServiceException;
import by.http.newsmanagement.service.ServiceProvider;

public class DeleteNewsCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String page;
		String name;
		String value;
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			
			NewsService service = ServiceProvider.getInstance().getNewsService();
			service.deleteNews(id);
			
			page = Page.CONTROLLER;
			name = "command";
			value = "view_all_news";
			
		} catch (ServiceException e) {
			page = Page.ERROR_PAGE;
			name = "errorMessage";
			value = "This news cannot be deleted";
		}
		
		response.sendRedirect(page + "?" + name + "=" + value);
	}
}
