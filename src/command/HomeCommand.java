package command;

import javax.servlet.http.HttpServletRequest;

import resource.ConfigurationManager;

public class HomeCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		
		if (request.getParameter("client").equals("user")) {
			page = ConfigurationManager.getProperty("path.page.main_user");
		} else {
			// иначе страничка админа!!
			page = ConfigurationManager.getProperty("path.page.main_admin");
		}

		return page;
	}

}
