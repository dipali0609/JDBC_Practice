package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateRecSwitch 
{
public static void main(String[] args) throws Exception
{
	Class.forName("com.mysql.cj.jdbc.Driver");	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/edubridge","root","root");
	Statement st=con.createStatement();
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Id to Udate");
	int id=sc.nextInt();
	int ch;
	ResultSet rs=st.executeQuery("Select * from employeee where eid="+id);
	if(rs.next())
	{
		while(true)
		{
		    System.out.println("Which Feild do you want to update");
			System.out.println("1 update Name \n2 update Email \n3 show All Records \n4 Update Ephone \n5 Update Esalary \n6 Exit");
			ch=sc.nextInt();
			
			switch(ch)
			{
			case 1: 
				System.out.println("enter the ename");
				String ename=sc.next();
				 String str="update employeee set ename='"+ename+"' where eid="+id;
				   System.out.println(str);
				   int k=st.executeUpdate(str);
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
				System.out.println("enter the email");
				String email=sc.next();
				 str="update employeee set email='"+email+"' where eid="+id;
				   System.out.println(str);
				   k=st.executeUpdate(str);
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
				rs=st.executeQuery("select * from employeee");
				System.out.println("Eid\tEname\tEmail\tephone\tedob\tedname\t\t\tEsalary");
				while(rs.next())
				{
					
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t "+rs.getString(4)+"\t"+rs.getDate(5)+"\t"+rs.getString(6)+"\t"+rs.getFloat(7));
				}
			    break;
			    
			case 4:
				System.out.println("enter the ephone");
				String ephone=sc.next();
				 str="update employeee set ephone='"+ephone+"' where eid="+id;
				   System.out.println(str);
				   k=st.executeUpdate(str);
				   if(k>0)
				   {
					   System.out.println("Record Updated Succesfully");
				   }
				   else
				   {
					   System.out.println("Not Updated...");
				   }
				break;
				
			case 5:
				System.out.println("enter the eSalary");
				Float esalary=sc.nextFloat();
				 str="update employeee set esalary='"+esalary+"' where eid="+id;
				   System.out.println(str);
				   k=st.executeUpdate(str);
				   if(k>0)
				   {
					   System.out.println("Record Updated Succesfully");
				   }
				   else
				   {
					   System.out.println("Not Updated...");
				   }
				
			}
			System.out.println("Do you Want to Continue press N to exit any key to continue");
			char choice=sc.next().charAt(0);
			if(choice=='n')
			{
				break;
			}
		
	}//while
	System.out.println("Program is Terminated");
}//if
}//main
}//class
