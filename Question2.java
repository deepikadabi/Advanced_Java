package com.assignments.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcassignments",
				"root", "root");
		PreparedStatement ps = con.prepareStatement("insert into student values(?, ?, ?, ?)");
		System.out.println("Enter the number of records you want to insert : ");
		int x = sc.nextInt();
		int roll;
		String name;
		int marks;
		String date;
		//DateFormat d = new SimpleDateFormat("yyyy-mm-dd");
		while(x>0) {
			System.out.println("Enter the roll no of Student : ");
			roll = sc.nextInt();
			System.out.println("Enter the name of Student : ");
			sc.nextLine();
			name = sc.nextLine();
			System.out.println("Enter total marks out of 100 : ");
			marks = sc.nextInt();
			System.out.println("Enter date of birth in (yyyy-mm-dd) format : ");
			date = sc.next();
			//Date dobj = d.parse(date);
			ps.setInt(1, roll);
			ps.setString(2, name);
			ps.setInt(3, marks);
			ps.setDate(4, java.sql.Date.valueOf(date));
			System.out.println(ps.executeUpdate() +" row created.");	
			x--;
		}
		con.close();
	}

}
