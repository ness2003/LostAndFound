package command;

import javax.servlet.http.HttpServletRequest;

import datalayer.data.SystemUser;
import resource.ConfigurationManager;
import temporary.data.SystemUsers;

public class BlockUserCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {

		String userID = request.getParameter("userid");
		if (userID != null) {

			this.changeUserStatus(Integer.parseInt(userID));
		}
		String page = null;
		if (request.getParameter("client").equals("admin")) {
			request.setAttribute("foundUsers", SystemUsers.userList);
			page = ConfigurationManager.getProperty("path.page.users_admin");

		} else if (request.getParameter("client").equals("moderator")) {
			request.setAttribute("foundUsers", SystemUsers.clientsList);
			page = ConfigurationManager.getProperty("path.page.users_moderator");
		}

		return page;
	}

	private void changeUserStatus(int userID) {
		for (SystemUser user : SystemUsers.userList) {
			if (user.getUserID() == userID) {
				if (user.getStatus().equals("Активен")) {
					user.setStatus("Заблокирован");
				} else {
					user.setStatus("Активен");
				}
				break;
			}
		}
	}

}
