package com.assignments.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Question8 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcassignments", 
				"root", "root");
		String query = "select avg(marks) from student";
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		if(rs.next())
			System.out.println("Averge Marks : "+rs.getInt(1));
		con.close();
	}

}
