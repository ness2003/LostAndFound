package command;

import javax.servlet.http.HttpServletRequest;

import logic.FinalQuestionsLogic;
import resource.ConfigurationManager;

public class FinalQuestionsCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		int findingId = Integer.parseInt(request.getParameter("finalquestionid"));

		if (request.getParameter("client").equals("moderator")) {
			request.setAttribute("foundItems", FinalQuestionsLogic.getFinalQuestionsByFindingId(findingId));
			page = ConfigurationManager.getProperty("path.page.finaquestions_moderator");
		}

		if (request.getParameter("client").equals("user")) {
			request.setAttribute("findingId", findingId);
			request.setAttribute("foundQuestionAnswer",
					FinalQuestionsLogic.getQuestionsWithAnswersByFindingId(findingId));
			page = ConfigurationManager.getProperty("path.page.user.final_questions");
		}

		if (request.getParameter("client").equals("receiver")) {
			request.setAttribute("foundItems", FinalQuestionsLogic.getFinalQuestionsByFindingId(findingId));
			page = ConfigurationManager.getProperty("path.page.receiver.finalquestions");
		}

		return page;
	}

}
