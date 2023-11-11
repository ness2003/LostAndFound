package command;

import javax.servlet.http.HttpServletRequest;

import resource.ConfigurationManager;
import temporary.data.FinalQuestions;

public class CheckAnswerCommand implements ActionCommand{
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;

		if (request.getParameter("client").equals("user")) {
			request.setAttribute("foundItems", FinalQuestions.getQuestionsForFinding(1));
			page = ConfigurationManager.getProperty("path.page.user.final_questions");
		}
		
		return page;
	}

}
