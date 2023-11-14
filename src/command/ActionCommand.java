package command;

import javax.servlet.http.HttpServletRequest;
//НЕ ТРЕБУЕТ РАБОТЫ С БД - ИНТЕРФЕЙС
public interface ActionCommand {
	String execute(HttpServletRequest request);	
}
