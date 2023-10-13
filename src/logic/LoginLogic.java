package logic;

import java.util.HashMap;

public class LoginLogic {

	public static boolean checkLogin(String enterLogin, String enterPass) {
		HashMap<String, String> logsAndPasswds = new HashMap<String, String>();
		logsAndPasswds.put("admin", "Qwe12");
		logsAndPasswds.put("user", "1");

		return logsAndPasswds.containsKey(enterLogin) && logsAndPasswds.get(enterLogin).equals(enterPass);
	}

}
