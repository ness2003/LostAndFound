package command;

import javax.servlet.http.HttpServletRequest;
import logic.FinalQuestionsLogic;
import resource.ConfigurationManager;

public class AddFinalQuestionCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		int findingId = Integer.parseInt(request.getParameter("findingId"));
		
		if (request.getParameter("client").equals("receiver")) {
			try {
				if (request.getParameter("addFinalQuestion").equals("true")) {
					FinalQuestionsLogic.addFinalQuestion(request);
				}
			} catch (Exception e) {
				//
			}
			
			request.setAttribute("findingId", findingId);
			page = ConfigurationManager.getProperty("path.page.receiver.add_final_question");
		}
		return page;
	}

}
