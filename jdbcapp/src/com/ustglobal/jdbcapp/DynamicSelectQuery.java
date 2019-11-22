package com.ustglobal.jdbcapp;

import java.sql.*;

import com.mysql.jdbc.Driver;

public class DynamicSelectQuery {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=tiger";
		String sql = "select * from employee_info where id=?";
				
				Connection conn = null;
		        PreparedStatement pstmt = null;
		        ResultSet rs = null;
		        
		        try {
		        	//Step 1 Load the Driver
		        	
					Driver driver = new Driver();
					DriverManager.registerDriver(driver);
					
					//Step 2 Get the Connection
					
					conn = DriverManager.getConnection(url);
					
					//Step 3 Issue SQL Query
					
					pstmt = conn.prepareStatement(sql);
					String empid = args[0];
					int id = Integer.parseInt(empid);
					pstmt.setInt(1, id);
					
					rs = pstmt.executeQuery();
					
					//Step 4 Read the Result
					if(rs.next()) {
						int emp_id = rs.getInt("id");
						int sal = rs.getInt("sal");
						String name = rs.getString("name");
						String gender = rs.getString("gender");
						
						System.out.println("Id: "+id);
						System.out.println("Name: "+name);
						System.out.println("Salary: "+sal);
						System.out.println("Gender: "+gender );
						
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						if(rs!=null) {
							rs.close();
						}
						if(pstmt!=null) {
							pstmt.close();
						}
						if(conn!=null) {
							conn.close();	
						}
						
					}catch(SQLException e) {
						e.printStackTrace();
					}
					
				}// end of try-catch-finally
		        
	}// end of main()

}// end of Query
