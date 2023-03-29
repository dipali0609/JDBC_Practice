package com.edu1;

import java.sql.*;
import java.util.Scanner;

public class DatabaseOperations {

	static Connection conn;
	public static void displayRecord() throws Exception {
		// TODO Auto-generated method stub
		conn=DatabaseConnection.getConnection();
		//create a statement object
				Statement st=conn.createStatement();
				String s="select * from employee";
				ResultSet rs=st.executeQuery(s);
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t\t"+rs.getString(4));
				}
				
	}

	public static void addEmployee() throws Exception {
		// TODO Auto-generated method stub
		conn=DatabaseConnection.getConnection();
		//create a statement object
				Statement st=conn.createStatement();
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

	public static void updateEmployee() throws Exception {
		
				conn=DatabaseConnection.getConnection();
				//create a statement object
						Statement st=conn.createStatement();
						Scanner sc=new Scanner(System.in);
						System.out.println("Enter Id to Udate");
						int id=sc.nextInt();
						int ch;
						ResultSet rs=st.executeQuery("Select * from employee where eid="+id);
						if(rs.next())
						{
							while(true)
							{
							    System.out.println("Which Feild do you want to update");
								System.out.println("1 update Name \n2 update Email \n3 show All Records \n4 Update Esalary \n5 Exit");
								ch=sc.nextInt();
								
								switch(ch)
								{
								case 1: 
									System.out.println("enter the ename");
									String ename=sc.next();
									 String str="update employee set ename='"+ename+"' where eid="+id;
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
									 str="update employee set email='"+email+"' where eid="+id;
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
									rs=st.executeQuery("select * from employee");
									System.out.println("Eid\tEname\tEmail\t\tEsalary");
									while(rs.next())
									{
										
										System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t "+rs.getFloat(4));
									}
								    break;
								    
									
								case 4:
									System.out.println("enter the eSalary");
									Float esalary=sc.nextFloat();
									 str="update employee set esalary='"+esalary+"' where eid="+id;
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
							
						}
						System.out.println("Program is Terminated");
					}
						else
						{
							System.out.println("ID Not Present");
						}
					
	}

	public static void deleteEmployee() throws Exception {
		// TODO Auto-generated method stub
		conn=DatabaseConnection.getConnection();
		//create a statement object
				Statement st=conn.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id");
		int id=sc.nextInt();
		
		
		ResultSet rs=st.executeQuery("select * from employee where eid="+id);
		if(rs.next())
		{
			int k=st.executeUpdate("delete from employee where eid="+id);
		if(k>0)
		{
			System.out.println("Record delete");
		}
		
		}else
		{
			System.out.println(id+" Id is not exits....Not deleted");
		}
	}

}
