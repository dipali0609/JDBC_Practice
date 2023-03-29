package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
public class DeleteRecord 
{
public static void main(String[] args) throws Exception {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/edubridge","root","root");
	Statement st=con.createStatement();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the id");
	int id=sc.nextInt();
	
	
	ResultSet rs=st.executeQuery("select * from employeee where eid="+id);
	if(rs.next())
	{
		int k=st.executeUpdate("delete from employeee where eid="+id);
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

//package com.edu;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.Scanner;
//
//public class DeleteRecord {
//
//	public static void main(String[] args) {
//		//load the driver
//				//make the connection
//				//create a statement object
//				//exeute sql commands
//				
//				String driver="com.mysql.cj.jdbc.Driver";
//				String url="jdbc:mysql://localhost:3306/employeedatabase";
//				String un="root";
//				String up="root";
//				
//				//load driver
//				try {
//				Class.forName(driver);
//				//make the connection
//				Connection conn=DriverManager.getConnection(url, un, up);
//				//create a statement object
//				Statement stmt=conn.createStatement();
//				
//				Scanner sc=new Scanner(System.in);
//				System.out.println("Enter employee id delete record");
//				int empid=sc.nextInt();
//				
//				String sql="select * from employee where empid="+empid;
//				ResultSet rs=stmt.executeQuery(sql);
//				
//				if(rs.next()) {
//					//if record exists in the table go for delete
//					String del="delete from employee where empid="+empid;
//					int i=stmt.executeUpdate(del);
//					if(i>0) {
//						System.out.println("Employee record is deleted");
//					}
//				}else {
//					System.out.println(empid+" Employee with given id not exists");
//				}
//		
//				}catch(Exception e) {
//				   e.printStackTrace();	
//				}
//	}
//
//	}
