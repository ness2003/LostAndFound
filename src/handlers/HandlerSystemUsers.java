package handlers;

import java.util.HashMap;

import datalayer.DAOFactory;
import datalayer.DBType;
import datalayer.SystemUserDAO;

public class HandlerSystemUsers {
	private DAOFactory factory;
	private SystemUserDAO sud;

	public HandlerSystemUsers() {
		this.factory = DAOFactory.getInstance(DBType.ORACLE);
		this.sud = factory.getSystemUserDAO();
	}

	public HashMap<String, String> getHashMapLoginAndPasswd() {
		return this.sud.getLoginsAndPasswds();
	}
}
