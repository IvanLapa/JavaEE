package by.http.webapp.service;

import by.http.webapp.service.impl.LoginService;
import by.http.webapp.service.impl.RegistrationService;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();
	private final LoginService loginService = new LoginService();
	private final RegistrationService registartionService = new RegistrationService();
	
	public static ServiceFactory getInstance() {
		return instance;
	}
	
	public LoginService getLoginService() {
		return loginService;
	}
	
	public RegistrationService getRegistrationService() {
		return registartionService;
	}
}
