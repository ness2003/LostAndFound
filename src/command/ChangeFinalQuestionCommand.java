package command;

import javax.servlet.http.HttpServletRequest;

import datalayer.data.FinalQuestion;
import resource.ConfigurationManager;
import temporary.data.FinalQuestions;

public class ChangeFinalQuestionCommand implements ActionCommand{
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String finalQuestionID = request.getParameter("finalquestionid");
		if (finalQuestionID != null) {
			request.setAttribute("finalQuestion", this.getFinalQuestionForFinalQuestionID(Integer.parseInt(finalQuestionID)));
		}
		page = ConfigurationManager.getProperty("path.page.changefinalquestion_moderator");
		System.out.print(ConfigurationManager.getProperty("path.page.changefinalquestion_moderator"));
		return page;
	}
	
	private FinalQuestion getFinalQuestionForFinalQuestionID(int finalQuestionID) {
		for (FinalQuestion finalQuestion : FinalQuestions.finalQuestionsList ) {
			if (finalQuestion.getId() == finalQuestionID) {
				return finalQuestion;
			}
		}
		return null;
	}

}
