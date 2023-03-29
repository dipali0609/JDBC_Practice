package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
public class MainJdbcApp 
{
	public static void main(String[] args) throws Exception
	{
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/edubridge";
		String un="root";
		String up="root";
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,un,up);
		Statement st=con.createStatement();
		
		String s="select * from employeee";
		ResultSet rs=st.executeQuery(s);
		while(rs.next())
		{
			System.out.println(rs.getInt("eid")+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t\t"+rs.getString(4));
		}
		
		
		
		
		
	}
}
/*
 * import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainJdbcApp {

	public static void main(String[] args) {
		//load the driver
		//make the connection
		//create a statement object
		//exeute sql commands
		
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/employeedatabase";
		String un="root";
		String up="root";
		
		//load driver
		try {
		Class.forName(driver);
		//make the connection
		Connection conn=DriverManager.getConnection(url, un, up);
		//create a statement object
		Statement stmt=conn.createStatement();
		
		String s="select * from employee";
		ResultSet rs=stmt.executeQuery(s);
		
		System.out.println("EID\tENAME\tESALARY");
		while(rs.next()) {
			//System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
			System.out.println(rs.getInt("empid")+"\t"+rs.getString("empname")+"\t"+rs.getFloat("empsalary"));
		}
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
 * */
