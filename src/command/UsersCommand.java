package command;

import java.util.ArrayList;
import temporary.data.*;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import datalayer.data.Finding;
import datalayer.data.SystemUser;
import resource.ConfigurationManager;

public class UsersCommand implements ActionCommand {


	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		
		if (request.getParameter("client").equals("admin")) {
			request.setAttribute("foundUsers", SystemUsers.userList);
			page = ConfigurationManager.getProperty("path.page.users_admin");

		} else if (request.getParameter("client").equals("moderator")) {
			page = ConfigurationManager.getProperty("path.page.users_moderator");
			request.setAttribute("foundUsers", SystemUsers.clientsList);
		}
	
		return page;
	}
	
	


	
	



}
