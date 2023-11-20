package command;

import javax.servlet.http.HttpServletRequest;

import resource.ConfigurationManager;

public class AddFinalQuestionCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		int findingId = Integer.parseInt(request.getParameter("findingId"));
		
		if (request.getParameter("client").equals("receiver")) {
			page = ConfigurationManager.getProperty("path.page.receiver.add_final_question");
		}
		return page;
	}

}
