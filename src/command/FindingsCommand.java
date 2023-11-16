package command;

import javax.servlet.http.HttpServletRequest;

import logic.FindingsLogic;
import resource.ConfigurationManager;
import cache.UserIdInSystem;
//РАБОТАЕТ С БД
public class FindingsCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;	
		if (request.getParameter("client").equals("user")) {
			if (request.getParameter("setOwnershipForUser").equals("true")) {
				FindingsLogic.setUserForFinding(Integer.parseInt(request.getParameter("findingId")), UserIdInSystem.userID);
			}
			
			request.setAttribute("foundItems", FindingsLogic.getFreeFindings());
			page = ConfigurationManager.getProperty("path.page.findings_user");
		} else if (request.getParameter("client").equals("moderator")) {
			request.setAttribute("foundItems", FindingsLogic.getAllFindings());
			page = ConfigurationManager.getProperty("path.page.findings_moderator");
		} else if (request.getParameter("client").equals("receiver")) {
			request.setAttribute("foundItems", FindingsLogic.getFindingsForReceiver(UserIdInSystem.userID));
			page = ConfigurationManager.getProperty("path.page.receiver.findings");
		}
		return page;
	}
}
