package com.edu;
import java.sql.*;
public class ResultSetMetaDataEx 
{
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/edubridge","root","root");
	Statement st=con.createStatement();
  
	ResultSet rs=st.executeQuery("select * from employee");
	ResultSetMetaData rs1=rs.getMetaData();
	System.out.println("Number of column In Table="+rs1.getColumnCount());
	System.out.println("class Name Of column="+rs1.getColumnClassName(1));
	System.out.println("Column name="+rs1.getColumnName(4));
	System.out.println("column Label="+rs1.getColumnLabel(3));
	System.out.println("column size="+rs1.getColumnDisplaySize(4));
	System.out.println("column size="+rs1.getColumnDisplaySize(1));
	System.out.println(rs1.getTableName(4));
	System.out.println(rs1.getClass());
	System.out.println(rs1.getColumnTypeName(2));
	
}
}
