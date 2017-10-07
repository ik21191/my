package com.ecom.db.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionFactory {
	public static Logger log = Logger.getLogger(ConnectionFactory.class);
	// static reference to itself
	private static ConnectionFactory instance = new ConnectionFactory();

	private ConnectionFactory() {
		try {
			Class.forName(DbConstants.DRIVER);
		} catch (ClassNotFoundException e) {
			log.error("Problem while loading driver " + e);
		}
	}

	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DbConstants.URL, DbConstants.USERNAME, DbConstants.PASSWORD);
		} catch (SQLException e) {
			log.error("ERROR: Unable to Connect to Database." + e);
		}
		return connection;
	}

	public static Connection getConnection() {
		return instance.createConnection();
	}

}
