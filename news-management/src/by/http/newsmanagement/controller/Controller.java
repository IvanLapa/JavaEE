package by.http.newsmanagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.newsmanagement.controller.command.Command;
import by.http.newsmanagement.controller.command.CommandProvider;

public class Controller extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private final CommandProvider commandProvider = new CommandProvider();
	private static final String COMMAND_NAME = "command";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String currentCommandName;
		Command command;
		
		request.setCharacterEncoding("UTF-8");
		
		currentCommandName = request.getParameter(COMMAND_NAME);
		
		command = commandProvider.getCommand(currentCommandName);
		command.execute(request, response);
	}

}
