package command;

import javax.servlet.http.HttpServletRequest;

import datalayer.data.FinalQuestion;
import logic.FinalQuestionsLogic;
import resource.ConfigurationManager;
import temporary.data.FinalQuestions;

public class ChangeFinalQuestionCommand implements ActionCommand{
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		
		String finalQuestionID = request.getParameter("finalquestionid");		
		request.setAttribute("finalQuestion", FinalQuestionsLogic.getFinalQuestionById(Integer.parseInt(finalQuestionID)));
		
		if (request.getParameter("client").equals("moderator")) {
			page = ConfigurationManager.getProperty("path.page.changefinalquestion_moderator");
		}
		
		if (request.getParameter("client").equals("receiver")) {
			page = ConfigurationManager.getProperty("path.page.receiver.change_final_question");
		}
		
		return page;
	}

}
