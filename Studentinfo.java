package com.assignmentjdbc.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class Studentinfo {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Connection CONN=null;
		PreparedStatement pstmt=null;
		try
		{
		Driver diverref=new Driver();
		DriverManager.registerDriver(diverref);
		
		String dburl="jdbc:mysql://localhost:3306/JDBC?user=root&password=root";
		 CONN=DriverManager.getConnection(dburl);
		
		String query2=" insert into Studnet values(?,?,?,?) ";
		 pstmt=CONN.prepareStatement(query2);
		
		pstmt.setInt(1, Integer.parseInt(args[0]));
		pstmt.setString(2,args[1]);
		pstmt.setInt(3,Integer.parseInt(args[2]));
		pstmt.setInt(4,Integer.parseInt(args[3]));
		
		int res=pstmt.executeUpdate();
		if(res!=0)
		{
			System.out.println("student data is updated");
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
				if(pstmt!=null)
				{
					pstmt.close();
				}
			}
			catch(SQLException e2)
			{
				e2.printStackTrace();
			}
		}
	}

}
