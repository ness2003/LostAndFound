package command;

import javax.servlet.http.HttpServletRequest;

import cache.UserIdInSystem;
import logic.FindingsLogic;
import resource.ConfigurationManager;
//Требует работы с БД
public class MyFindingsCommand implements ActionCommand{
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		
		try {
			if (request.getParameter("setOwnershipForUser").equals("true")) {
				FindingsLogic.setUserForFinding(Integer.parseInt(request.getParameter("findingId")), UserIdInSystem.userID);
			}
		} catch (Exception e) {
			//
		}
		
		
		request.setAttribute("foundItems", FindingsLogic.getFindingForUser(UserIdInSystem.userID));
		page = ConfigurationManager.getProperty("path.page.myfindings_user");
		return page;
	}
}
