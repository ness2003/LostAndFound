package command;

import javax.servlet.http.HttpServletRequest;
import coder.Coder;
import datalayer.data.FinalQuestion;
import logic.FinalQuestionsLogic;
import resource.ConfigurationManager;
import temporary.data.FinalQuestions;

public class RefreshFinalQuestion implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;

		FinalQuestionsLogic.refreshFinalQuestion(request);

		int findingId = Integer.parseInt(request.getParameter("findingId"));
		request.setAttribute("foundItems", FinalQuestionsLogic.getFinalQuestionsByFindingId(findingId));

		if (request.getParameter("client").equals("moderator")) {
			page = ConfigurationManager.getProperty("path.page.finaquestions_moderator");
		}
		if (request.getParameter("client").equals("receiver")) {
			page = ConfigurationManager.getProperty("path.page.receiver.finalquestions");
		}
		
		return page;
	}

}
