package com.assignments.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Question1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcassignments", 
				"root","root");
		
		Statement st = con.createStatement();
		String query = "create table if not exists student(rno int, name varchar(20), marks int, dob date)";
		System.out.println(st.execute(query));
		System.out.println("Student table created!");
		con.close();
	}

}
