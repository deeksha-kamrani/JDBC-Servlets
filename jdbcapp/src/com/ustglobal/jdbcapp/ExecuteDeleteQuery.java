package com.ustglobal.jdbcapp;

import java.io.FileReader;
import java.sql.*;

import com.mysql.jdbc.Driver;

public class ExecuteDeleteQuery {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			// Step 1 Load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// Step 2 Get the Connection
			String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=tiger";
			conn = DriverManager.getConnection(url);
			
			// Step 3 Issue SQL Query
			String sql = "delete from employee_info where id=?";
			pstmt = conn.prepareStatement(sql);
			String empid = args[0];
			pstmt.setInt(1, Integer.parseInt(args[0]));
			int count = pstmt.executeUpdate();
			
			//Step 4 Read the result  
			System.out.println(count + "Row(s) deleted");
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			//Step 5 Close all resources
			try {
				if(conn!=null) {
					conn.close();
				} if(pstmt!=null) {
					pstmt.close();
				}
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
