package controller;

import javax.servlet.http.HttpServletRequest;

import command.ActionCommand;
import resource.ConfigurationManager;

public class UserProfile implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		request.setAttribute("e_mail", "ivan@example.com");
		String page = ConfigurationManager.getProperty("path.page.myprofile");
		return page;
	}

}
