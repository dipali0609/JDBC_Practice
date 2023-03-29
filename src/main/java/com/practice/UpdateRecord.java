package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateRecord {

	public static void main(String[] args) throws Exception 
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/edubridge","root","root");
	Statement st=con.createStatement();
	Scanner sc=new Scanner(System.in);
	int sid=sc.nextInt();
	ResultSet rs=st.executeQuery("select * from student where sid="+sid);
	if(rs.next())
	{
		System.out.println("Enter the sname to update:");
		String sname=sc.next();
		int k=st.executeUpdate("update student set sname='"+sname+"' where sid="+sid);
		if(k>0)
		{
			System.out.println("insert");
		}
		else
		{
			System.out.println("Not");
		}
	}
	else
	{
		System.out.println("ID not present");
	}
	}

}
