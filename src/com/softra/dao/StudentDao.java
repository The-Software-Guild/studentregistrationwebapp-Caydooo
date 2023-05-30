package com.softra.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;

import com.mysql.jdbc.Connection;
import com.softra.model.Student;

public class StudentDao implements Idao {

	public StudentDao() {}
	
	protected Connection initConnection(ServletContext context) {
		Connection con = null;
		
		try {
			Class.forName(context.getInitParameter("driverClassName"));
			//System.out.println("MySQL driver registered with DriverManager");
			
			con = (Connection) DriverManager.getConnection(context.getInitParameter("url"), context.getInitParameter("username"), context.getInitParameter("password"));
			//System.out.println(con);
		} catch (ClassNotFoundException e) {
			System.out.println("MySQL suitable driver not found");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	private void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void persistStudent(ServletContext context) {
		Connection con = initConnection(context);
		int counter = 0;
		
		String sql = "SELECT COUNT(*) FROM student;";
		try {
			PreparedStatement pState = con.prepareStatement(sql);
			ResultSet rSet = pState.executeQuery();
			
			while(rSet.next()) {
				counter = rSet.getInt(1);
			}
			
			Student s = (Student) context.getAttribute("student");
			sql = "INSERT INTO student VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement pStatement = con.prepareStatement(sql);
			
			counter++;
			pStatement.setInt(1, counter);
			pStatement.setString(2, s.getName());
			pStatement.setInt(3, s.getAge());
			pStatement.setInt(4, s.getMobileNo());
			pStatement.setString(5, s.getAddress());
			
			int n = pStatement.executeUpdate();
			System.out.println("Successfully stored s: " + s.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		closeConnection(con);
	}
}
