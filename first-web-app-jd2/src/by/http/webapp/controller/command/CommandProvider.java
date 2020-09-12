package by.http.webapp.controller.command;

import java.util.HashMap;
import java.util.Map;
import by.http.webapp.controller.command.impl.LoginCommand;
import by.http.webapp.controller.command.impl.RegistrationCommand;

public class CommandProvider {
	private static final CommandProvider instance = new CommandProvider();
	private Map<ParameterName, Command> commands = new HashMap<ParameterName, Command>();
	
	public CommandProvider() {
		commands.put(ParameterName.LOGIN, new LoginCommand());
		commands.put(ParameterName.REGISTRATION, new RegistrationCommand());
	}
	
	public Command getCommand(String commandName) {
		Command command;
		ParameterName valueName;
		
		commandName = commandName.toUpperCase();
		valueName = ParameterName.valueOf(commandName);
		
		command = commands.get(valueName);
		return command;
	}
	
	
	public static CommandProvider getInstance(){
		return instance;
	}
}
