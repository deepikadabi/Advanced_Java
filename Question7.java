package com.assignments.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Question7 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcassignments", 
				"root", "root");
		Statement st = con.createStatement();
		System.out.println("Enter the roll number of the Student you want to check the record of : ");
		int roll = sc.nextInt();
		String query = "select * from student where rno="+roll;
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
