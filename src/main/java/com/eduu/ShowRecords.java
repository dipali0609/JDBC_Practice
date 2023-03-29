package com.eduu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ShowRecords 
{
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/edubridge","root","root");
	//Statement st=con.createStatement();
    PreparedStatement pst=con.prepareStatement("select * from employee");
    ResultSet rs=pst.executeQuery();
    while(rs.next())
    {
    	System.out.println(rs.getInt(1)+"\t" +rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4));
    }
   
}
}