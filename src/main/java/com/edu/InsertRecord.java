package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
public class InsertRecord 
{
public static void main(String[] args) throws Exception 
{
	
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/edubridge","root","root");
Statement st=con.createStatement();
String ename,eemail;
float esalary;
Scanner sc=new Scanner(System.in);
System.out.println("Enter the emp id");
int eid=sc.nextInt();

ResultSet rs=st.executeQuery("select * from employee where eid="+eid);
if(!rs.next())
{
	System.out.println("enter the empName");
	ename=sc.next();
	System.out.println("Enter the Email id ");
	eemail=sc.next();
	System.out.println("enter the esalary");
	esalary=sc.nextFloat();
	
	String ins="insert into employee values("+eid+",'"+ename+"','"+eemail+"',"+esalary+")";
	System.out.println(ins);
	int i=st.executeUpdate(ins);
	if(i>0)
	{
		System.out.println("Record Insert");
	}
}
else
{
	System.out.println("eid Is already exits");
}
}
}
