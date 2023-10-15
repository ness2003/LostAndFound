package command;

import javax.servlet.http.HttpServletRequest;

import resource.ConfigurationManager;

public class InformationAboutProjectCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.aboutproject");

		return page;
	}

}
