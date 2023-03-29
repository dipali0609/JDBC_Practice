package com.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.print.attribute.standard.PrinterIsAcceptingJobs;

import com.edu1.DatabaseConnection;


public class DatabaseOperation 
{
	static Connection con;
public static void DisplayRecords() throws Exception 
{
	
	con=DatabaseConnection.getConnection();
	PreparedStatement pst=con.prepareStatement("select * from employee");
	ResultSet rs=pst.executeQuery();
	while(rs.next())
	{
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4));
	}
	
}

public static void InsertReocrds() throws Exception 
{
con=DatabaseConnection.getConnection();
Scanner sc=new Scanner(System.in);
System.out.println("Enter the Eid");
int eid=sc.nextInt();
PreparedStatement pst ;
pst=con.prepareStatement("select * from employee where eid=?");
pst.setInt(1, eid);
ResultSet rs=pst.executeQuery();
if(!rs.next())
{
	System.out.println("Enter the ename");
	String ename=sc.next();
	System.out.println("Enter the email");
	String email=sc.next();
	System.out.println("Enter the esalary");
	float esalary=sc.nextFloat();
	
	pst=con.prepareStatement("insert into employee values(?,?,?,?)");
	pst.setInt(1, eid);
	pst.setString(2, ename);
	pst.setString(3, email);
	pst.setFloat(4, esalary);
	int k=pst.executeUpdate();
	if(k>0)
	{
		System.out.println("Record Insert successFully");
	}
	
}
else
{
	System.out.println(eid+"Already Exits");
}
	
}

public static void UpdateRecords() throws Exception {
	// TODO Auto-generated method stub
	con=DatabaseConnection.getConnection();
	Scanner sc=new Scanner(System.in);
PreparedStatement pst;
	
	
	System.out.println("Enter Id to Update");
	int id=sc.nextInt();
	int ch;
	pst=con.prepareStatement("Select * from employee where eid=?");
	
	pst.setInt(1, id);
	ResultSet rs=pst.executeQuery();
	
	if(rs.next())
	{
		while(true)
		{
		    System.out.println("Which Feild do you want to update");
			//System.out.println("1 update Name \n2 update Email \n3 show All Records \n4 Update Ephone \n5 Update Esalary \n6 Exit");
		    System.out.println("1 update Name \n2 update Email \n4 Show Data");
			ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
				 pst=con.prepareStatement("update employee set ename=? where eid=?");
				System.out.println("enter the ename");
				String ename=sc.next();
				  pst.setString(1, ename);
				  pst.setInt(2, id);
				  int k=pst.executeUpdate();
				   if(k>0)
				   {
					   System.out.println("Record Updated Succesfully");
				   }
				   else
				   {
					   System.out.println("Not Updated....");
				   }
				break;
				
			case 2:
				pst=con.prepareStatement("update employee set email=? where eid=?");
				System.out.println("enter the email");
				String email=sc.next();
				    pst.setString(1, email);
				    pst.setInt(2, id);
				    k=pst.executeUpdate();
				 
				   if(k>0)
				   {
					   System.out.println("Record Updated Succesfully");
				   }
				   else
				   {
					   System.out.println("Not Updated...");
				   }
				break;
				
	
			case 3:
				pst=con.prepareStatement("select * from employee");
				rs=pst.executeQuery();
				System.out.println("Eid\tEname\tEmail\t\t\tEsalary");
				while(rs.next())
				{
					
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t "+rs.getFloat(4));
				}
			    break;
			    
			
				
			
				
			}
			System.out.println("Do you Want to Continue press N to exit any key to continue");
			char choice=sc.next().charAt(0);
			if(choice=='n')
			{
				break;
			}
		
	}
	System.out.println("Program is Terminated");
}
	else
	{
		System.out.println(id+" Not Exits in table");
	}
}

public static void DeleteRecords() throws Exception {
	// TODO Auto-generated method stub
	con=DatabaseConnection.getConnection();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the eid for Delete Record from table");
	int eid=sc.nextInt();

    PreparedStatement pst;
	pst=con.prepareStatement("select * from employee where eid=?");
	pst.setInt(1, eid);
	ResultSet rs=pst.executeQuery();
	pst=con.prepareStatement("delete from employee where eid=?");
	pst.setInt(1,eid);
	if(rs.next())
	{
		int k=pst.executeUpdate();
		if(k>0)
		{
			System.out.println("Record Deleted successfully");
		}
	}
	else
	{
		System.out.println(eid+"Not Exits...Not Deleted...");
	}

}
}
