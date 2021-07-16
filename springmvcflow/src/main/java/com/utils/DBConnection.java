package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static final String user ="root";
	public static final String pass = "root";
	public static final String url = "jdbc:mysql://localhost:3306/company";
	
	public static Connection con = null;
	
	public static Connection getConnection()
	{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con  = DriverManager.getConnection(url,user,pass);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return con;
	}
	
	public static void main(String args[])
	{
		System.out.println(DBConnection.getConnection());
	}
}
