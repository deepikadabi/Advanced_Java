package com.assignments.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Question4 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcassignments",
				"root", "root");
		Statement st = con.createStatement();
		String query = "select * from student order by marks desc";
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			System.out.println("Roll no : "+rs.getInt(1)+"\t"
			+"Name : "+rs.getString(2)+"\t"
			+"Marks : "+rs.getInt(3)+"\t"
			+"Date of Birth : "+rs.getDate(4));
		}
		con.close();
	}

}
