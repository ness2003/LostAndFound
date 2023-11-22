package command;

import javax.servlet.http.HttpServletRequest;

import logic.FinalQuestionsLogic;
import resource.ConfigurationManager;

public class FinalQuestionsCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		int findingId = Integer.parseInt(request.getParameter("findingId"));

		if (request.getParameter("client").equals("moderator")) {
			request.setAttribute("foundItems", FinalQuestionsLogic.getFinalQuestionsByFindingId(findingId));
			page = ConfigurationManager.getProperty("path.page.finaquestions_moderator");
		}

		if (request.getParameter("client").equals("user")) {
			page = ConfigurationManager.getProperty("path.page.user.final_questions");
			request.setAttribute("findingId", findingId);
			request.setAttribute("foundQuestionAnswer",
					FinalQuestionsLogic.getQuestionsWithAnswersByFindingId(findingId));
		
			
		}

		if (request.getParameter("client").equals("receiver")) {
			try {
				if (request.getParameter("addFinalQuestion").equals("true")) {
					FinalQuestionsLogic.addFinalQuestion(request);
				}
			} catch (Exception e) {
				//
			}
			request.setAttribute("findingId", findingId);
			request.setAttribute("foundItems", FinalQuestionsLogic.getFinalQuestionsByFindingId(findingId));
			page = ConfigurationManager.getProperty("path.page.receiver.finalquestions");
		}

		return page;
	}

}
