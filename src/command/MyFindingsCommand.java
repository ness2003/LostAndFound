package command;

import javax.servlet.http.HttpServletRequest;

import resource.ConfigurationManager;
import temporary.data.Findings;

public class MyFindingsCommand implements ActionCommand{
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		page = ConfigurationManager.getProperty("path.page.myfindings_user");
		return page;
	}
}
