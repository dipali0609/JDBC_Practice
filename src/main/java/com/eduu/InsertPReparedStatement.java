package com.eduu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class InsertPReparedStatement {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/edubridge","root","root");
		PreparedStatement pst;
		String ename, email;
		float esalary;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Eid");
		int eid=sc.nextInt();
       
        pst=con.prepareStatement("select * from employee where eid=?");
        pst.setInt(1, eid);
		ResultSet rs=pst.executeQuery();
		if(!rs.next())
		{
			System.out.println("enter the EName");
			ename=sc.next();
			System.out.println("enter the Email");
			email=sc.next();
			System.out.println("enter the Esalaary");
			esalary=sc.nextFloat();
			pst=con.prepareStatement("insert into employee values(?,?,?,?) ");
		    pst.setInt(1, eid);
		    pst.setString(2, ename);
		    pst.setString(3, email);
		    pst.setFloat(4, esalary);
		    
		    int k=pst.executeUpdate();
			
			if(k>0)
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
