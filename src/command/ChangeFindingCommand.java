package command;

import javax.servlet.http.HttpServletRequest;
import logic.ChangeFindingLogic;
import resource.ConfigurationManager;
//РАБОТАЕТ С БД
public class ChangeFindingCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String findingID = request.getParameter("findingid");
		if (findingID != null) {
			request.setAttribute("finding", ChangeFindingLogic.getFindingForUserID(Integer.parseInt(findingID)));
		}
		if (request.getParameter("client").equals("moderator")) {
			page = ConfigurationManager.getProperty("path.page.changefinding_moderator");
		}
		if (request.getParameter("client").equals("receiver")) {
			page = ConfigurationManager.getProperty("path.page.receiver.change_finding");		
		}		
		return page;
	}

}
