package command;

import javax.servlet.http.HttpServletRequest;

import resource.ConfigurationManager;
//НЕ ТРЕБУЕТ РАБОТЫ С БД - ПРОСТО ПЕРЕХОД НА СТРАНИЦУ
public class AddFindingCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		if (request.getParameter("client").equals("receiver")) {
			page = ConfigurationManager.getProperty("path.page.receiver.add_finding");
		}
		return page;
	}
	
}
