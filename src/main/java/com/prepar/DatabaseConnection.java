package com.prepar;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection 
{
public static Connection getConnection() throws Exception
{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/edubridge","root","root");
if(con==null)
{
	System.out.println("Error getting");
}
 return con;

}
}
