package com.ustglobal.jdbcapp;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class MyFirstJDBCWithProperties {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		FileReader reader = null;
		
		try {
			reader = new FileReader("db.properties");
			Properties prop = new Properties();
			prop.load(reader);
			
			prop.getProperty("driver-class-name");
			
			String url = prop.getProperty("url");
			conn = DriverManager.getConnection(url, prop);
			
		  	stmt = conn.createStatement();
			String sql = prop.getProperty("select-query");
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int sal = rs.getInt("sal");
				String gender = rs.getString("gender");
				
				System.out.println("Id: "+id);
				System.out.println("Name: "+name);
				System.out.println("Salary: "+sal);
				System.out.println("Gender: "+gender);
				System.out.println("*****************");	
			}	
			
		} catch (Exception e) {
			e.printStackTrace();	
		}	
		finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(stmt!= null) {
					stmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
				if(reader!=null) {
					reader.close();
				}
			}catch (Exception e) {
				e.printStackTrace();	
			}
		}				
	}
}
