package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class RetrievedData {

	public static void main(String[] args) throws Exception 
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/edubridge","root","root");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select * from student");
	while(rs.next())
	{
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
	}
	}

}
