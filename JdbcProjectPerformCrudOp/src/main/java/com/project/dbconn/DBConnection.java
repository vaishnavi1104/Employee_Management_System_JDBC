package com.project.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
		public static final String URL ="jdbc:mysql://localhost:3306/jbk";
		public static final String USER = "root";
		public static final String PASSWORD = "";
		
		public static Connection getConnection() throws SQLException {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		}
		
		
}
