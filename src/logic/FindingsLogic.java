package logic;

import java.util.List;
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
}
