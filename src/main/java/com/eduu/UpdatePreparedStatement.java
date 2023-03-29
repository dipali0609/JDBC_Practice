package com.eduu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdatePreparedStatement {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/edubridge","root","root");
		String dname;
		PreparedStatement pst;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Id to Udate");
		int did=sc.nextInt();
		pst=con.prepareStatement("Select * from dept where did=?");
		pst.setInt(1, did);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			pst=con.prepareStatement("update dept set dname=? where did=?");
			System.out.println("enter the deptName");
			dname=sc.next();
		     
			 pst.setString(1, dname);
		    pst.setInt(2, did);
		   
		    int k=pst.executeUpdate();
			
			if(k>0)
			{
				System.out.println("Record Updated successfully....");
			}
		}
		else
		{
			System.out.println(did+" dId Not Exits");
		}
	}

}
