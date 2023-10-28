package command;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import datalayer.data.SystemUser;
import resource.ConfigurationManager;
import temporary.data.SystemUsers;
import coder.Coder;

public class RefreshUsersCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		if (request.getParameter("client").equals("admin")) {
			if (request.getParameter("act").equals("add")) {
				SystemUsers.userList.add(createNewUser(request));
			}
			if (request.getParameter("act").equals("change")) {
				changeUser(request);
			}
			request.setAttribute("foundUsers", SystemUsers.userList);
			page = ConfigurationManager.getProperty("path.page.users_admin");

		} else if (request.getParameter("client").equals("moderator")) {
			page = ConfigurationManager.getProperty("path.page.users_moderator");
		}
		return page;
	}

	private SystemUser createNewUser(HttpServletRequest request) {
		int userID = getNextID();
		String fullName = Coder.toUTF8(request.getParameter("fullName"));
		String phone = Coder.toUTF8(request.getParameter("phoneNumber"));
		String email = Coder.toUTF8(request.getParameter("email"));
		String login = Coder.toUTF8(request.getParameter("login"));
		String password = Coder.toUTF8(request.getParameter("password"));
		String status = Coder.toUTF8(request.getParameter("status"));
		String group = Coder.toUTF8(request.getParameter("group"));
		return new SystemUser(userID, fullName, phone, email, login, password, status, group);

	}

	private void changeUser(HttpServletRequest request) {
		int userID = Integer.parseInt(request.getParameter("userid"));
		for (SystemUser user : SystemUsers.userList) {
			if (user.getUserID() == userID) {
				user.setFullName(Coder.toUTF8(request.getParameter("fullName")));
				user.setPhone(Coder.toUTF8(request.getParameter("phoneNumber")));
				user.setEmail(Coder.toUTF8(request.getParameter("email")));
				user.setLogin(Coder.toUTF8(request.getParameter("login")));
				user.setPassword(Coder.toUTF8(request.getParameter("password")));
				user.setStatus(Coder.toUTF8(request.getParameter("status")));
				user.setGroup(Coder.toUTF8(request.getParameter("group")));
			}
		}
	}

	private static int getNextID() {
		int maxId = 0;
		for (SystemUser user : SystemUsers.userList) {
			int userId = user.getUserID();

			if (userId >= maxId) {
				maxId = userId;
			}
		}
		return ++maxId;
	}

}
