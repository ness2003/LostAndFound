package datalayer;

import java.util.HashMap;
import java.util.List;

import datalayer.data.SystemUser;

public interface SystemUserDAO {
	List<SystemUser> getSystemUsers();

	HashMap<String, String> getLoginsAndPasswds();
}
