package command;

import javax.servlet.http.HttpServletRequest;

import resource.ConfigurationManager;
//НЕ ТРЕБУЕТ РАБОТЫ С БД - ПРОСТО ПЕРЕХОД НА СТРАНИЦУ
public class AddUserCommand implements ActionCommand{
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		page = ConfigurationManager.getProperty("path.page.adduser");
		return page;
	}
}
