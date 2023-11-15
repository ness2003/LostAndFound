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
		
		if (request.getParameter("setOwnershipForUser").equals("true")) {
			//System.out.println("ues!!!");
			//FindingsLogic.setUserForFinding(UserIdInSystem.userID))
		}
		
		request.setAttribute("foundItems", FindingsLogic.getFindingForUser(UserIdInSystem.userID));
		page = ConfigurationManager.getProperty("path.page.myfindings_user");
		return page;
	}
}
