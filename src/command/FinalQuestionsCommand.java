package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import resource.ConfigurationManager;
import temporary.data.FinalQuestions;
import temporary.data.QuestionAnswer;
public class FinalQuestionsCommand implements ActionCommand{
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		int finalquestionId = Integer.parseInt(request.getParameter("finalquestionid"));
		
		
		if (request.getParameter("client").equals("moderator")) {
			request.setAttribute("foundItems", FinalQuestions.getQuestionsForFinding(finalquestionId));
			page = ConfigurationManager.getProperty("path.page.finaquestions_moderator");
		}
		
		if (request.getParameter("client").equals("user")) {
			request.setAttribute("foundQuestionAnswer", FinalQuestions.getQuestionsByFinding(finalquestionId));
			page = ConfigurationManager.getProperty("path.page.user.final_questions");
		}
		
		return page;
	}
	

}
