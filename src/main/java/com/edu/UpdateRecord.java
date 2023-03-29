package com.edu;

import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.*;
public class UpdateRecord 
{
public static void main(String[] args) throws Exception
{
Class.forName("com.mysql.cj.jdbc.Driver");	
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/edubridge","root","root");
Statement st=con.createStatement();

Scanner sc=new Scanner(System.in);
System.out.println("Enter Id to Udate");
int id=sc.nextInt();
ResultSet rs=st.executeQuery("Select * from employeee where eid="+id);
if(rs.next())
{
	System.out.println("Enter Reocords for Update ");
	System.out.println("enter the ename");
	String ename=sc.next();
	System.out.println("enter the email");
	String email=sc.next();
	System.out.println("enter the ephone");
	String ephone=sc.next();
	System.out.println("enter the edob");
	String edob=sc.next();
   String str="update employeee set ename='"+ename+"',email='"+email+"',ephone='"+ephone+"',edob='"+edob+"' where eid="+id;
   System.out.println(str);
   int k=st.executeUpdate(str);
   if(k>0)
   {
	   System.out.println("Record Updated Succesfully");
   }
}
else
{
	System.out.println(id+" eId Not Exits");
}
}
}
