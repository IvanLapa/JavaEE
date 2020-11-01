package by.http.newsmanagement.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.newsmanagement.controller.command.Command;
import by.http.newsmanagement.entity.News;
import by.http.newsmanagement.service.ServiceException;
import by.http.newsmanagement.service.ServiceProvider;

public class ToViewPageCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String page;
		try {
			if(request.getParameter("id")!=null) {
				int id = Integer.parseInt(request.getParameter("id"));
				News news = ServiceProvider.getInstance().getNewsService().selectNewsById(id);
				request.setAttribute("news", news);
			}
			page = Page.EDIT_PAGE;
		} catch (ServiceException e) {
			page = Page.ERROR_PAGE;
			request.setAttribute("errorMessage", "No news");
		}
		request.getRequestDispatcher(page).forward(request, response);
	}
}