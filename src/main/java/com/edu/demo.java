package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



public class demo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/edubridge","root","root");
		Statement st=con.createStatement();
		
		String sql="insert into student values(8,'Dipali')";
		st.executeUpdate(sql);
		
		
		
		
	}

}
