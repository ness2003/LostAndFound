package command;

import javax.servlet.http.HttpServletRequest;

import logic.LoginLogic;
import resource.ConfigurationManager;
import resource.MessageManager;
import cache.UserIdInSystem;

//РАБОТАЕТ С БД
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
			UserIdInSystem.userID = LoginLogic.getUserIdForLogin(login);
			System.out.println("ID текущего пользователя = " + UserIdInSystem.userID);
			int groupID = LoginLogic.getGroupIdForLogin(login);
			if (groupID == LoginLogic.getGroupIdForGroupName("Клиент")) {
				page = ConfigurationManager.getProperty("path.page.main_user");
			} else if (groupID == LoginLogic.getGroupIdForGroupName("Администратор")) {
				page = ConfigurationManager.getProperty("path.page.main_admin");
			} else if (groupID == LoginLogic.getGroupIdForGroupName("Модератор")) {
				page = ConfigurationManager.getProperty("path.page.main_moderator");
			} else if (groupID == LoginLogic.getGroupIdForGroupName("Приемщик")) {
				page = ConfigurationManager.getProperty("path.page.main_receiver");
			}
		} else {
			request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
			page = ConfigurationManager.getProperty("path.page.login");
		}

		return page;
	}

}