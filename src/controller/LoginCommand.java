package controller;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;

		// извлечение из запроса логина и пароля
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);

		// проверка логина и пароля
		if (LoginLogic.checkLogin(login, pass)) {
			if (login.equals("user")) {
				page = ConfigurationManager.getProperty("path.page.main_user");
			} else if (login.equals("admin")) {
				page = ConfigurationManager.getProperty("path.page.main_admin");
			}

		} else {
			request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
			page = ConfigurationManager.getProperty("path.page.login");
		}

		return page;
	}
	
}