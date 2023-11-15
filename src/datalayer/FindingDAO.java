package datalayer;
import java.sql.Date;
import java.util.List;

import datalayer.data.Finding;

public interface FindingDAO {
	List<Finding> getFindings();
	List<Finding> getFreeFindings();
	List<Finding> getFindingsForReceiver(int receiverID);
	List<Finding> getFindingsForUser(int userId);
	Finding getFindingForFindingID(int findingId);
	void changeFinding(int findingID, String findingName, Date findingDate, String findingPlace, String findingDescription, int category);
	void addNewFinding(String findingName, Date findingDate, String findingPlace, String findingDescription,int receiver, int category);
}
