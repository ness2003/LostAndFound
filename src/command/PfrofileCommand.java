package command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import coder.Coder;
import datalayer.data.Finding;
import datalayer.data.SystemUser;
import resource.ConfigurationManager;
import temporary.data.Findings;
import temporary.data.SystemUsers;

public class PfrofileCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;

		request.setAttribute("profileData", SystemUsers.userList.get(0));
		request.setAttribute("saveMessage", "no");

		if (request.getParameter("client").equals("user")) {
			page = ConfigurationManager.getProperty("path.page.userprofile");
			
			if (request.getParameter("data").equals("refresh")) {
				changeUser(request);
				request.setAttribute("saveMessage", "yes");
			}
			
		} else if (request.getParameter("client").equals("admin")) {
			page = ConfigurationManager.getProperty("path.page.adminprofile");
		} else if (request.getParameter("client").equals("moderator")){
			page = ConfigurationManager.getProperty("path.page.moderatorprofile");
		}
		return page;
	}

	private void changeUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("userid"));
		for (SystemUser user : SystemUsers.userList) {
			if (user.getUserID() == userId) {
				user.setFullName((Coder.toUTF8(request.getParameter("name"))));
				user.setPhone((Coder.toUTF8(request.getParameter("phone"))));
				user.setEmail((Coder.toUTF8(request.getParameter("email"))));
			}
		}
	}

}
