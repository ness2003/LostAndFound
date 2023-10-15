package command;

import javax.servlet.http.HttpServletRequest;
import resource.ConfigurationManager;

public class FindingsCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;

//		String client = request.getParameter("client"); // client = user или admin
		// вынести логику в класс logic
		
		String isUserFinds = request.getParameter("isuserfinds");
		if (isUserFinds.isEmpty()) {
			page = ConfigurationManager.getProperty("path.page.finds");
		} else {
			page = ConfigurationManager.getProperty("path.page.userfinds");
		}
		

		return page;
	}

}
