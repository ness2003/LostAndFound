package command;

import javax.servlet.http.HttpServletRequest;
import logic.BlockUserLogic;
import logic.UsersLogic;
import resource.ConfigurationManager;
//РАБОТАЕТ С БД
public class BlockUserCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {

		String userID = request.getParameter("userid");
		if (userID != null) {
			BlockUserLogic.changeUserStatus((Integer.parseInt(userID)));
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
