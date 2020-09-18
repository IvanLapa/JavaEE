package by.http.webapp.service;

import by.http.webapp.service.impl.LoginService;
import by.http.webapp.service.impl.RegistrationService;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();
	private final Service loginService = new LoginService();
	private final Service registartionService = new RegistrationService();
	
	public static ServiceFactory getInstance() {
		return instance;
	}
	
	public Service getLoginService() {
		return loginService;
	}
	
	public Service getRegistrationService() {
		return registartionService;
	}
}
