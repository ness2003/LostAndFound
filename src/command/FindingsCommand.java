package command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import datalayer.data.*;
import resource.ConfigurationManager;

public class FindingsCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		List<Finding> findingsList = new ArrayList<>();

		if ("1".equals(request.getAttribute("command"))) {

			// Загрузить список находок с ID 1
			findingsList.add(new Finding(1, "Наименование1", "Описание1", "Дата1", "Место1", "Категория1"));
		} else if ("2".equals(request.getAttribute("command"))) {
			// Загрузить список находок с ID 2
			findingsList.add(new Finding(2, "Наименование2", "Описание2", "Дата2", "Место2", "Категория2"));
		}
		// Другие операции

		request.setAttribute("findingsList", findingsList);
		// List<Finding> findingsList = new ArrayList<>();
		// findingsList.add(new Finding(1,"fwe", "fer","eferf","ererf,","ferfe"));
		// request.setAttribute("findingsList", findingsList);
		page = ConfigurationManager.getProperty("path.page.findings");
		return page;
	}

}
