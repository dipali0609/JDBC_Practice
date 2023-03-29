package com.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseConnection {

	public static Connection getConnection()throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/edubridge","root","root");
	
		if(con==null)
		{
			System.out.println("Error in getting Conncetion");
		}
			
		return con;
		
	}

}
