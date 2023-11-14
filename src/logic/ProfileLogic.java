package logic;

import datalayer.data.SystemUser;

public class ProfileLogic {
	public static SystemUser getSystemUserForID(int id) {
		SystemUser foundedUser = Logic.getSystemUser().getSystemUserForUserID(id);
		return foundedUser;
	}
	
	public static void updateUserProfile(String fullname, String phone, String email, int userId) {
		Logic.getSystemUser().UpdateFullnamePhoneEmailForUserId(fullname, phone, email, userId);;
	}

}
