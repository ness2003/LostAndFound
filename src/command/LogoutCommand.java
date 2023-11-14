package command;

import javax.servlet.http.HttpServletRequest;
import resource.ConfigurationManager;
import cache.UserIdInSystem;

//РАБОТАЕТ С БД
public class LogoutCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.index");
		// уничтожение сессии
		request.getSession().invalidate();
		//Logic.getFactory().closeConnection();
		UserIdInSystem.userID = 0;
		return page;
	}

}