package by.http.newsmanagement.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.newsmanagement.controller.command.Command;

public class ChangeLocalCommand implements Command{

	@Override
	public void execute (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String page = Page.ERROR_PAGE;
				
		request.getSession(true).setAttribute("local", request.getParameter("local"));
		
		String fromPage = request.getParameter("fromPage").toLowerCase();
				
		if(fromPage.equalsIgnoreCase(Page.NEWS_LIST_PAGE)) {
			page = Page.CONTROLLER + "?command=view_all_news";
		}
		
		if (fromPage.equalsIgnoreCase(Page.NEWS_PAGE)) {
			int id = Integer.parseInt(request.getParameter("id"));
			page = Page.CONTROLLER +"?command=to_news_page&id=" + id;
		}
		
		if (fromPage.equalsIgnoreCase(Page.EDIT_PAGE)) {
			if (!("").equals(request.getParameter("id"))) {
				int id = Integer.parseInt(request.getParameter("id"));
				page = Page.CONTROLLER +"?command=to_edit_page&id=" + id;
			} else {
				page = "controller?command=to_edit_page";
			}
		}
		response.sendRedirect(page);
	}
}