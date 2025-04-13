package com.fda.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connections {
	private static String url= "jdbc:mysql://localhost:3306/foodclone";
	private static String username="root";
	private static String password="root";
	
	public static Connection connectToDb() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
