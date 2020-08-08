package com.lti.dao.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnManager {

	public static Connection connect() {
		try {
			Properties dbprops=new Properties();
			//dbprops.load(new FileReader("dev-db.properties"));
			dbprops.load(ConnManager.class.getClassLoader().getResourceAsStream("dev-db.properties"));
			Class.forName(dbprops.getProperty("driver-name"));
			return DriverManager.getConnection(dbprops.getProperty("url"), dbprops.getProperty("user"), dbprops.getProperty("pass"));
		}
		catch(ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace(); //we should rather throw an user defined exception
			return null; //very bad should throw an exception indicating some problem which trying to fetch data
		}
	}
}
