package command;

import javax.servlet.http.HttpServletRequest;
import logic.DeleteUserLogic;
import logic.UsersLogic;
import resource.ConfigurationManager;
import cache.UserIdInSystem;
//РАБОТАЕТ С БД
public class DeleteUserCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {

		int userID = Integer.parseInt(request.getParameter("userid"));
		if ((userID != 0) && (userID != UserIdInSystem.userID)) {
			DeleteUserLogic.deleteUserForUserID((userID));
		}
		String page = null;
		if (request.getParameter("client").equals("admin")) {
			request.setAttribute("foundUsers", UsersLogic.getUsersForAdmin());
			page = ConfigurationManager.getProperty("path.page.users_admin");
		} else if (request.getParameter("client").equals("moderator")) {
			request.setAttribute("foundUsers", UsersLogic.getUsersForModerator());
			page = ConfigurationManager.getProperty("path.page.users_moderator");
		}
		return page;
	}
}
