package com.eduu;

import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.*;
public class DeletePreparedStatementEx 
{
public static void main(String[] args) throws Exception 
{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/edubridge","root","root");
PreparedStatement pst;

Scanner sc=new Scanner(System.in);
System.out.println("Enter the eid for Delete Record from table");
int eid=sc.nextInt();


pst=con.prepareStatement("select * from prod where eid=?");
pst.setInt(1, eid);
ResultSet rs=pst.executeQuery();
pst=con.prepareStatement("delete from prod where eid=?");
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
