package command;

import javax.servlet.http.HttpServletRequest;

import resource.ConfigurationManager;

public class AddUserCommand implements ActionCommand{

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		page = ConfigurationManager.getProperty("path.page.adduser");
		return page;
	}

}
