package com.eduu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.x.ReusableOutputStream;

public class UpdateMenu 
{
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/edubridge","root","root");
	PreparedStatement pst;
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Id to Update");
	int id=sc.nextInt();
	int ch;
	pst=con.prepareStatement("Select * from employeee where eid=?");
	pst.setInt(1, id);
	ResultSet rs=pst.executeQuery();
	if(rs.next())
	{
		while(true)
		{
		    System.out.println("Which Feild do you want to update");
			//System.out.println("1 update Name \n2 update Email \n3 show All Records \n4 Update Ephone \n5 Update Esalary \n6 Exit");
		    System.out.println("1 update Name \n2 update Email \n3 Update ephone \n4 Show Data");
			ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
				 pst=con.prepareStatement("update employeee set ename=? where eid=?");
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
				pst=con.prepareStatement("update employeee set email=? where eid=?");
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
				pst=con.prepareStatement("update employeee set ephone=? where eid=?");
				System.out.println("enter the ephone");
				String ephone=sc.next();
				pst.setString(1, ephone);
				pst.setInt(2, id);;
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
			case 4:
				pst=con.prepareStatement("select * from employeee");
				rs=pst.executeQuery();
				System.out.println("Eid\tEname\tEmail\tephone\tedob\tedname\t\t\tEsalary");
				while(rs.next())
				{
					
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t "+rs.getString(4)+"\t"+rs.getDate(5)+"\t"+rs.getString(6)+"\t"+rs.getFloat(7));
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
}
}
