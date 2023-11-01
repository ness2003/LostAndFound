package command;

import javax.servlet.http.HttpServletRequest;

import datalayer.data.Finding;
import resource.ConfigurationManager;
import temporary.data.Findings;

public class ChangeFindingCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String findingID = request.getParameter("findingid");
		if (findingID != null) {
			request.setAttribute("finding", this.getFindingForFindingID(Integer.parseInt(findingID)));
		}
		
		if (request.getParameter("client").equals("moderator")) {
			page = ConfigurationManager.getProperty("path.page.changefinding_moderator");
		}
		
		if (request.getParameter("client").equals("receiver")) {
			page = ConfigurationManager.getProperty("path.page.receiver.change_finding");
			
		}
		
		return page;
	}
	
	private Finding getFindingForFindingID(int findingID) {
		for (Finding finding : Findings.findingsList ) {
			if (finding.getId() == findingID) {
				return finding;
			}
		}
		return Findings.findingsList.get(1);
	}

}
