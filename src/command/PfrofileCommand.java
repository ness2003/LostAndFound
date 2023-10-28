package command;

import javax.servlet.http.HttpServletRequest;

import datalayer.data.SystemUser;
import resource.ConfigurationManager;

public class PfrofileCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;

		request.setAttribute("profileData",
				new SystemUser("Титов Антон Максимович", "89008001234", "titovanton@gmail.com"));

		if (request.getParameter("client").equals("user")) {
			page = ConfigurationManager.getProperty("path.page.userprofile");
		} else if (request.getParameter("client").equals("admin")) {
			page = ConfigurationManager.getProperty("path.page.adminprofile");
		} else if (request.getParameter("client").equals("moderator")){
			page = ConfigurationManager.getProperty("path.page.moderatorprofile");
		}
		return page;
	}

}
