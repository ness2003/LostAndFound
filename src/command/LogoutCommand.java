package command;

import javax.servlet.http.HttpServletRequest;
import resource.ConfigurationManager;
import logic.BlockUserLogic;

//РАБОТАЕТ С БД
public class LogoutCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {

		try {
			if (request.getParameter("blockUser").equals("true")) {
				BlockUserLogic.changeUserStatus((int)request.getSession().getAttribute("userId"));
			}
		} catch (Exception e) {
			//
		}

		String page = ConfigurationManager.getProperty("path.page.index");
		// уничтожение сессии
		request.getSession().invalidate();
		System.out.print("Session invalidate");
		return page;
	}

}