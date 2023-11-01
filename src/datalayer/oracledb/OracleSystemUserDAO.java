package datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.prutzkow.resourcer.*;

import datalayer.SystemUserDAO;
import datalayer.data.SystemUser;

public class OracleSystemUserDAO implements SystemUserDAO {

	private Connection connection;
	private static Resourcer resourcer = ProjectResourcer.getInstance();

	public OracleSystemUserDAO(Connection connection) {
		this.setConnection(connection);
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<SystemUser> getSystemUsers() {
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<SystemUser> userList = new ArrayList<SystemUser>();
		try {
			System.out.print(resourcer.getString("select.all.system.users"));
			statement = connection.createStatement();
			System.out.print("��� ��1");
			resultSet = statement.executeQuery(resourcer.getString("select.all.system.users"));
			System.out.print("��� ��");
			while (resultSet.next()) {
				System.out.print(resultSet.getString(2));

				int userID = resultSet.getInt(1);
				String fullName = resultSet.getString(2);
				String email = resultSet.getString(3);
				String login = resultSet.getString(4);
				String password = resultSet.getString(5);
				int status = resultSet.getInt(6);
				int group = resultSet.getInt(7);
//				SystemUser newUser = new SystemUser(userID, fullName, email, login, password, status, group);
//				userList.add(newUser);
			}
			if (userList.size() == 0) {
				userList.add(SystemUser.NULL_SYSTEM_USER);
			}
		} catch (SQLException e) {
			System.err.println(resourcer.getString("message.error") + e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;

	}

	@Override
	public HashMap<String, String> getLoginsAndPasswds() {

		HashMap<String, String> loginsAndPasswds = new HashMap<String, String>();
		ArrayList<SystemUser> userList = (ArrayList<SystemUser>) this.getSystemUsers();
		Iterator<SystemUser> iterator = userList.iterator();
		while (iterator.hasNext()) {
			SystemUser user = iterator.next();
			loginsAndPasswds.put(user.getLogin(), user.getPassword());
		}
		return loginsAndPasswds;

	}

}