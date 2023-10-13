package command;

import javax.servlet.http.HttpServletRequest;

import resource.ConfigurationManager;

public class LogoutCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.index");
		// уничтожение сессии
		request.getSession().invalidate();
		return page;
	}

}