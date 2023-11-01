package command;

import javax.servlet.http.HttpServletRequest;

import coder.Coder;
import datalayer.data.Finding;
import resource.ConfigurationManager;
import temporary.data.Findings;
import java.sql.Date;

public class RefreshFindingsCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {

		String page = null;

		if (request.getParameter("client").equals("user")) {
			page = ConfigurationManager.getProperty("path.page.findings_user");
		} else if (request.getParameter("client").equals("moderator")) {
			page = ConfigurationManager.getProperty("path.page.findings_moderator");
			if (request.getParameter("act").equals("edit")) {
				changeFinding(request);
			}
		} else if (request.getParameter("client").equals("receiver")) {
			page = ConfigurationManager.getProperty("path.page.receiver.findings");
			if (request.getParameter("act").equals("edit")) {
				changeFinding(request);
			}
			if (request.getParameter("act").equals("add")) {
				addFinding(request);
			}
		}

		request.setAttribute("foundItems", Findings.findingsList);
		return page;
	}

	private void changeFinding(HttpServletRequest request) {
		int findingID = Integer.parseInt(request.getParameter("findingid"));
		for (Finding finding : Findings.findingsList) {
			if (finding.getId() == findingID) {
				finding.setName((Coder.toUTF8(request.getParameter("findingName"))));
				finding.setDescription((Coder.toUTF8(request.getParameter("findingDescription"))));
				finding.setDate(Date.valueOf(Coder.toUTF8(request.getParameter("findingDate"))));
				finding.setPlace((Coder.toUTF8(request.getParameter("findingLocation"))));
				finding.setCategory(Coder.toUTF8(request.getParameter("findingCategory")));
			}
		}
	}
	
	private void addFinding(HttpServletRequest request) {
		Finding newFinding = new Finding();
		newFinding.setId(Findings.findingsList.size()+1);
		newFinding.setName((Coder.toUTF8(request.getParameter("findingName"))));
		newFinding.setDescription((Coder.toUTF8(request.getParameter("findingDescription"))));
		newFinding.setDate(Date.valueOf(Coder.toUTF8(request.getParameter("findingDate"))));
		newFinding.setPlace((Coder.toUTF8(request.getParameter("findingLocation"))));
		newFinding.setCategory((Coder.toUTF8(request.getParameter("findingCategory"))));
		Findings.findingsList.add(newFinding);
	}

}
