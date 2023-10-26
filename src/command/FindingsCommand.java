package command;

import javax.servlet.http.HttpServletRequest;

import resource.ConfigurationManager;
import temporary.data.Findings;

public class FindingsCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;

		request.setAttribute("foundItems", Findings.findingsList);
		if (request.getParameter("client").equals("user")) {
			page = ConfigurationManager.getProperty("path.page.findings_user");
		}else if (request.getParameter("client").equals("moderator")) {
			page = ConfigurationManager.getProperty("path.page.findings_moderator");
		}

		return page;
	}

}
