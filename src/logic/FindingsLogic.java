package logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import coder.Coder;
import datalayer.data.Finding;

public class FindingsLogic {
	public static List<Finding> getAllFindings() {
		List<Finding> lst = Logic.getFinding().getFindings();
		return lst;
	}

	public static List<Finding> getFreeFindings() {
		List<Finding> lst = Logic.getFinding().getFreeFindings();
		return lst;
	}

	public static List<Finding> getFindingsForReceiver(int receiverID) {
		List<Finding> lst = Logic.getFinding().getFindingsForReceiver(receiverID);
		return lst;
	}

	public static List<Finding> getFindingForUser(int userId) {
		List<Finding> list = Logic.getFinding().getFindingsForUser(userId);
		return list;
	}

	public void setUserForFinding(HttpServletRequest request, int userID) {

		// Logic.getFinding().setUserForFinding(questionId, question, rightAnswer,
		// alternativeAnswer1, alternativeAnswer2);
	}
}
