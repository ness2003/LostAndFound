package datalayer.oracledb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import datalayer.*;

public class OracleDBDAOFactory extends DAOFactory {
	private static volatile OracleDBDAOFactory instance;
	private Connection connection;

	private OracleDBDAOFactory() {
	}

	public static OracleDBDAOFactory getInstance() throws ClassNotFoundException, SQLException, NamingException {
		OracleDBDAOFactory factory = instance;
		if (instance == null) {
			synchronized (OracleDBDAOFactory.class) {
				instance = factory = new OracleDBDAOFactory();
				factory.connected();
			}
		}
		return factory;
	}

	private void connected() throws ClassNotFoundException, SQLException, NamingException {
//		Class.forName("oracle.jdbc.driver.OracleDriver");
		Context envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
		DataSource ds = (DataSource) envCtx.lookup("jdbc/LOST_AND_FOUND");
//		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//		String user = "SYS AS SYSDBA";
//		String password = "1";
//		connection = DriverManager.getConnection(url, user, password);
		connection = ds.getConnection();
		System.out.println("Connected to oracle DB!");
	}

	public void closeConnection() {
		if (this.connection != null) {
			try {
				this.connection.close();
			} catch (SQLException e) {
				System.err.println("Сonnection close error: " + e);
			}
		}
	}

	@Override
	public SystemUserDAO getSystemUserDAO() {
		return new OracleSystemUserDAO(connection);
	}

	@Override
	public UserGroupDAO getUserGroupDAO() {
		return new OracleUserGroupDAO(connection);
	}
	
	@Override
	public UserStatusDAO getUserStatusDAO() {
		return new OracleUserStatusDAO(connection);
	}

	@Override
	public FindingDAO getFindingDAO() {
		return new OracleFindingDAO(connection);
	}

	@Override
	public FindingStatusDAO getFindingStatusDAO() {
		return new OracleFindingStatusDAO(connection);
	}

	@Override
	public FindingCategoryDAO getFindingCategoryDAO() {
		return new OracleFindingCategoryDAO(connection);
	}
	
	@Override
	public FinalQuestionDAO getFinalQuestionDAO() {
		return new OracleFinalQuestionDAO(connection);
	}

}
