package datalayer;

import java.util.HashMap;
import java.util.List;

import datalayer.data.SystemUser;

public interface SystemUserDAO {
	List<SystemUser> getSystemUsers();

	List<SystemUser> getClients();

	HashMap<String, String> getLoginsAndPasswds();

	int getGroupIdForLogin(String login);

	int getUserIDforLogin(String login);

	SystemUser getSystemUserForUserID(int userID);

	void UpdateFullnamePhoneEmailForUserId(String fullname, String login, String email, int userId);

	void UpdateUserStatusForUserId(int userId);

	void DeleteUserForUserId(int userId);

	int getUserStatusID(int userId);

	void addNewUser(String fullname, String email, String login, String password, int status, int group);
	void changeUser(int userID, String fullname, String email, String login, String password, int status, int group);
}
