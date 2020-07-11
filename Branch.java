package com.assignmentjdbc.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class Branch {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection CONN=null;
		PreparedStatement pstmt=null;
		Driver dirverref=new Driver();
		DriverManager.registerDriver(dirverref);
		
		String dburl="jdbc:mysql://localhost:3306/JDBC?user=root&password=root";
		CONN=DriverManager.getConnection(dburl);
		
		String query=" insert into branch values(?,?) ";
		pstmt=CONN.prepareStatement(query);
	
		pstmt.setInt(1,Integer.parseInt(args[0]));
		pstmt.setString(2, args[1]);
		
		int res=pstmt.executeUpdate();
		
		if(res!=0)
		{
			System.out.println("branch data updated");
		}
		if(CONN!=null)
		{
			CONN.close();
		}
		if(pstmt!=null)
		{
			pstmt.close();
		}
	}
}
