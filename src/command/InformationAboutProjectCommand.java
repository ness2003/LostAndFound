package command;

import javax.servlet.http.HttpServletRequest;

import resource.ConfigurationManager;

public class InformationAboutProjectCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		if (request.getParameter("client").equals("user")) {
			page = ConfigurationManager.getProperty("path.page.useraboutproject");
		} else if (request.getParameter("client").equals("moderator")) {
			page = ConfigurationManager.getProperty("path.page.moderatoraboutproject");
		}else if (request.getParameter("client").equals("receiver")) {
			page = ConfigurationManager.getProperty("path.page.receiveraboutproject");
		}

		return page;
	}

}
