package com.assignments.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Question5 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbcassignments",
				"root", "root");
		Statement st = con.createStatement();
		String query = "select count(*) from student";
		ResultSet rs = st.executeQuery(query);
		if(rs.next())
			System.out.println(rs.getInt(1) + " student records found.");
		con.close();
	}

}
