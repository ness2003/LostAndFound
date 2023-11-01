package command;

import javax.servlet.http.HttpServletRequest;

import resource.ConfigurationManager;

public class HomeCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;

		if (request.getParameter("client").equals("user")) {
			page = ConfigurationManager.getProperty("path.page.main_user");
		} else if (request.getParameter("client").equals("admin")) {
			page = ConfigurationManager.getProperty("path.page.main_admin");
		} else if (request.getParameter("client").equals("moderator")) {
			page = ConfigurationManager.getProperty("path.page.main_moderator");
		} else if (request.getParameter("client").equals("receiver")) {
			page = ConfigurationManager.getProperty("path.page.main_receiver");
		}
		return page;
	}

}
