package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData {

	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/edubridge","root","root");
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Id to insert ");
		int sid=sc.nextInt();
		ResultSet rs=st.executeQuery("select * from student where sid="+sid);
		if(!rs.next())
		{
			System.out.println("Enter the name to insert");
			String sname=sc.next();
			int k=st.executeUpdate("insert into student values("+sid+",'"+sname+"')");
			if(k>0)
			{
				System.out.println("Record is inserted");
			}
			else
			{
				System.out.println("reconrd not inserted");
			}
		}

	}

}
