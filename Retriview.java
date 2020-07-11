package com.assignmentjdbc.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Retriview {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Connection CONN=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		String dburl="jdbc:mysql://localhost:3306/JDBC?user&password";
		 CONN=DriverManager.getConnection(dburl, "root", "root");
		System.out.println("Student details\n");
		String query1=" select * from Studnet ";
		 stmt=CONN.createStatement();
		
		 rs=stmt.executeQuery(query1);
		while(rs.next())
		{
			System.out.println("Student id ="+rs.getInt("s_id"));
			System.out.println("Name ="+rs.getString("s_name"));
			System.out.println("branch id ="+rs.getInt("branch_id"));
			System.out.println("pincode ="+rs.getInt("pincode"));
			
			System.out.println();
		
		}
		System.out.println();
		System.out.println("address details\n");
		query1=" select * from address ";
		rs=stmt.executeQuery(query1);
		while(rs.next())
		{
			System.out.println("pincode ="+rs.getInt("pincode"));
			System.out.println("city ="+rs.getString("city"));
			System.out.println("street ="+rs.getString("street"));
			System.out.println();
		}
		System.out.println();
		System.out.println("Branch details\n");
		query1=" select * from branch ";
		rs=stmt.executeQuery(query1);
		while(rs.next())
		{
			System.out.println("branch id ="+rs.getInt("branch_id"));
			System.out.println("branch_name ="+rs.getString("branch_name"));
			System.out.println();
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
			if(CONN!=null)
			{
				CONN.close();
			}
			if(stmt!=null)
			{
				stmt.close();
			}
			if(rs!=null)
			{
				rs.close();
			}
			}
			catch(SQLException e2)
			{
				e2.printStackTrace();
			}
		}
	}

}
