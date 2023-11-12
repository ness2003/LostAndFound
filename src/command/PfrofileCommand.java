package command;
import javax.servlet.http.HttpServletRequest;

import coder.Coder;
import logic.ProfileLogic;
import resource.ConfigurationManager;
import cache.UserIdInSystem;
//РАБОТАЕТ С БД
public class PfrofileCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		if (request.getParameter("data").equals("refresh")) {
			changeUser(request);
			request.setAttribute("saveMessage", "yes");
		}
		request.setAttribute("profileData", ProfileLogic.getSystemUserForID(UserIdInSystem.userID));
		request.setAttribute("saveMessage", "no");
		if (request.getParameter("client").equals("user")) {
			page = ConfigurationManager.getProperty("path.page.userprofile");		
		} else if (request.getParameter("client").equals("admin")) {
			page = ConfigurationManager.getProperty("path.page.adminprofile");
		} else if (request.getParameter("client").equals("moderator")){
			page = ConfigurationManager.getProperty("path.page.moderatorprofile");
		} else if (request.getParameter("client").equals("receiver")){
			page = ConfigurationManager.getProperty("path.page.receiver.profile");
		}
		return page;
	}

	private void changeUser(HttpServletRequest request) {
		ProfileLogic.updateUserProfile((Coder.toUTF8(request.getParameter("name"))), (Coder.toUTF8(request.getParameter("phone"))), (Coder.toUTF8(request.getParameter("email"))), Integer.parseInt(request.getParameter("userid")));
	}

}
