package command;

import javax.servlet.http.HttpServletRequest;
import logic.FinalQuestionsLogic;
import resource.ConfigurationManager;


public class RefreshFinalQuestion implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		if (request.getParameter("actiontype").equals("saverefresh")){
			FinalQuestionsLogic.refreshFinalQuestion(request);
		}else if (request.getParameter("actiontype").equals("delete")) {
			FinalQuestionsLogic.deleteFinalQuestion(request);
		}
		

		int findingId = Integer.parseInt(request.getParameter("findingId"));
		request.setAttribute("foundItems", FinalQuestionsLogic.getFinalQuestionsByFindingId(findingId));

		if ((int)request.getSession().getAttribute("role") ==(int)request.getSession().getAttribute("moderatorID")) {
			page = ConfigurationManager.getProperty("path.page.finaquestions_moderator");
		}
		if ((int)request.getSession().getAttribute("role") ==(int)request.getSession().getAttribute("receiverID")) {
			page = ConfigurationManager.getProperty("path.page.receiver.finalquestions");
		}
		
		return page;
	}

}
