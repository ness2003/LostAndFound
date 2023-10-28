package command;

import javax.servlet.http.HttpServletRequest;

import resource.ConfigurationManager;
import temporary.data.FinalQuestions;
public class FinalQuestionsCommand implements ActionCommand{
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		int finalquestionid = Integer.parseInt(request.getParameter("finalquestionid"));
		
		if (request.getParameter("client").equals("moderator")) {
			request.setAttribute("foundItems", FinalQuestions.getQuestionsForFinding(finalquestionid));
			page = ConfigurationManager.getProperty("path.page.finaquestions_moderator");

		}
	
		return page;
	}
	

}
