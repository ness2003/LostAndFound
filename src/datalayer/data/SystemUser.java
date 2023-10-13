package datalayer.data;

public class SystemUser {
	private int userID;
	private String fullName;
	private String email;
	private String login;
	private String password;
	private int status;
	private int group;

	public static final SystemUser NULL_SYSTEM_USER = new SystemUser() {
	};

	public SystemUser(int userID, String fullName, String email, String login, String password, int status, int group) {
		this.setUserID(userID);
		this.setFullName(fullName);
		this.setEmail(email);
		this.setLogin(login);
		this.setPassword(password);
		this.setStatus(status);
		this.setGroup(group);
	}

	private SystemUser() {

	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

}
