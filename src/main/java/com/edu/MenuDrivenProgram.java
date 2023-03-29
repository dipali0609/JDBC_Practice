package com.edu;

import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.*;
public class MenuDrivenProgram 
{
public static void main(String[] args) throws Exception 
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/edubridge","root","root");
	Statement st=con.createStatement();
	
	Scanner sc=new Scanner(System.in);
	int choice;
	do
	{
	System.out.println("________________________________________________________________________");
	System.out.println("1-Insert \n2-Update \n3-Delete \n4-Search \n5-show All Record \n6-Program Exit");
	System.out.println("________________________________________________________________________");
	System.out.println("Enter the choice:");
	choice=sc.nextInt();
	switch(choice)
	{
	case 1:
		System.out.println("Enter Records for Insert");
	System.out.println("Enter the eid:");
	int eid=sc.nextInt();
	ResultSet rs=st.executeQuery("select * from employee where eid="+eid);
	if(!rs.next())
	{
		System.out.println("Enter the ename:");
		String ename=sc.next();
		System.out.println("Enter the Email:");
		String email=sc.next();
		System.out.println("Enter the Esalary:");
		float esalary=sc.nextFloat();
		String str="insert into employee values("+eid+",'"+ename+"','"+email+"',"+esalary+")";
		System.out.println(str);
		int k=st.executeUpdate(str);
		if(k>0)
		{
			System.out.println("Record Insert successfully");
		}
	}
	else
	{
		System.out.println(eid+" Already Exits in Table");
	}
	break;
	
	case 2:
		System.out.println("Enter the Eid for Update");
		eid=sc.nextInt();
		rs=st.executeQuery("select * from employee where eid="+eid);
		if(rs.next())
		{
			System.out.println("Enter the ename:");
			String ename=sc.next();
			System.out.println("Enter the Email:");
			String email=sc.next();
			System.out.println("Enter the Esalary:");
			float esalary=sc.nextFloat();
			int k=st.executeUpdate("update employee set ename='"+ename+"',email='"+email+"',esalary="+esalary+" where eid="+eid);
			if(k>0)
			{
				System.out.println("Records Updated Succesfully");
			}

		}
		else
		{
			System.out.println(eid+" not Exits in table");
		}
		break;
		
	case 3:
		System.out.println("Enter the Eid For Delete Record");
		eid=sc.nextInt();
		rs=st.executeQuery("select * from employee where eid="+eid);
		if(rs.next())
		{
			int k=st.executeUpdate("delete from employee where eid="+eid);
			if(k>0)
			{
				System.out.println("Reocrd deleted SuccessFully");
			}
		}
		else
		{
			System.out.println(eid+" Not Exits in Table");
		}
		break;
		
	case 4:
		System.out.println("Enter the Eid For search Records:");
		eid=sc.nextInt();
		rs=st.executeQuery("select * from employee where eid="+eid);
		if(rs.next())
		{
		    System.out.println("Record Found!!....");
		    System.out.println("Eid\tEname\tEmail\t\t\tEsalary");
		    System.out.println("-------------------------------------------------------------------");
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t "+rs.getFloat(4));
		}
		else
		{
			System.out.println("Record not found!!...");
		}
		break;
		
	case 5:
		rs=st.executeQuery("select * from employee");
		System.out.println("Eid\tEname\tEmail\t\t\tEsalary");
		while(rs.next())
		{
			
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t "+rs.getFloat(4));
		}
	    break;
	    
	case 6:System.out.println("Program Exit Successfulllyyy!!....");
		break;
	}
	
}while(choice<6);
}
}
