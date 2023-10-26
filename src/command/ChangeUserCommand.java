package command;

import javax.servlet.http.HttpServletRequest;

import datalayer.data.SystemUser;
import resource.ConfigurationManager;
import temporary.data.SystemUsers;

public class ChangeUserCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String userID = request.getParameter("userid");
		if (userID != null) {
			request.setAttribute("user", this.getUserForUserID(Integer.parseInt(userID)));
		}
		page = ConfigurationManager.getProperty("path.page.changeuser");
		return page;
	}
	
	private SystemUser getUserForUserID(int userID) {
		for (SystemUser user : SystemUsers.userList) {
			if (user.getUserID() == userID) {
				return user;
			}
		}
		return null;
	}

}
