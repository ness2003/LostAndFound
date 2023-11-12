package command;

import javax.servlet.http.HttpServletRequest;
import resource.ConfigurationManager;
//НЕ ТРЕБУЕТ РАБОТЫ С БД - ПРОСТО ПЕРЕХОД НА СТРАНИЦУ
public class MyFindingsCommand implements ActionCommand{
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		page = ConfigurationManager.getProperty("path.page.myfindings_user");
		return page;
	}
}
