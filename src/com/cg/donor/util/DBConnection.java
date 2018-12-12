package com.cg.donor.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {

		FileInputStream fis = new FileInputStream("resources/MyProp.properties");
		Properties prop = new Properties();
		prop.load(fis);		
		
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,username,password);
		return con;
	}

	


	
	
}
