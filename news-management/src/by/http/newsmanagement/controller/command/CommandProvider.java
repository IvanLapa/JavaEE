package by.http.newsmanagement.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.http.newsmanagement.controller.command.impl.ChangeLocalCommand;
import by.http.newsmanagement.controller.command.impl.CreateNewsCommand;
import by.http.newsmanagement.controller.command.impl.DeleteNewsCommand;
import by.http.newsmanagement.controller.command.impl.ToNewsPageCommand;
import by.http.newsmanagement.controller.command.impl.ToViewPageCommand;
import by.http.newsmanagement.controller.command.impl.ViewAllNewsCommand;
import by.http.newsmanagement.controller.command.impl.ViewNewsCommand;

public class CommandProvider {
private Map<ParameterName, Command> commands = new HashMap<>();
	
	public CommandProvider() {
		commands.put(ParameterName.VIEW_ALL_NEWS, new ViewAllNewsCommand());
		commands.put(ParameterName.TO_NEWS_PAGE, new ToNewsPageCommand());
		commands.put(ParameterName.TO_EDIT_PAGE, new ToViewPageCommand());
		commands.put(ParameterName.EDIT_NEWS, new ViewNewsCommand());
		commands.put(ParameterName.DELETE_NEWS, new DeleteNewsCommand());
		commands.put(ParameterName.CREATE_NEWS, new CreateNewsCommand());
		commands.put(ParameterName.CHANGE_LOCALE, new ChangeLocalCommand());
	}
	
	public Command getCommand(String commandName) {
		Command command;
		ParameterName valueName;
		
		commandName = commandName.toUpperCase();
		valueName = ParameterName.valueOf(commandName);
		
		command = commands.get(valueName);
		
		return command;
	}
}
