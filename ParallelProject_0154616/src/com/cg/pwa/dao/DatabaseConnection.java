package com.cg.pwa.dao;

import java.sql.DriverManager;
import java.sql.*;

public class DatabaseConnection
{
	public static Connection getConnection()
	{
		Connection connection=null;
		String url="jdbc:mysql://localhost:3306/jdbcdatabase";
		String user="root";
		String psd="Capgemini123";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
			connection = DriverManager.getConnection(url, user, psd);
			System.out.println("DB Conneceted...");
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Driver not loaded");
		}
		catch(SQLException e)
		{
			System.out.println("Error : " +e.getMessage());
		}
		return connection;
	}
	public static void main(String[] args)
	{
		getConnection();
	}
}
