package command;

import javax.servlet.http.HttpServletRequest;

import resource.ConfigurationManager;

public class MyTasksCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		System.out.print("rfe");
		if (request.getParameter("client").equals("admin")) {
			page = ConfigurationManager.getProperty("path.page.admintasks");
		} else if (request.getParameter("client").equals("moderator")) {
			page = ConfigurationManager.getProperty("path.page.moderatortasks");
		} 

		return page;
	}

}
