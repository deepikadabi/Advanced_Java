package com.assignments.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Question9 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcassignments",
				"root", "root");
		PreparedStatement psInsert = con.prepareStatement("insert into student values(?, ?, ?, ?)"); 
		PreparedStatement psSelect = con.prepareStatement("select * from student");
		PreparedStatement psUpdate = con.prepareStatement("update student set marks=? where rno=?");
		PreparedStatement psDelete = con.prepareStatement("delete from student where rno=?");
		while(true) {
			System.out.println("====================MENU====================");
			System.out.println("1. Insert new Records\n2. Display Records\n3. Update a Record\n4. Delete a Record\n5. Exit");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Enter the roll no of Student : ");
				int roll = sc.nextInt();
				System.out.println("Enter the name of Student : ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter total marks out of 100 : ");
				int marks = sc.nextInt();
				System.out.println("Enter date of birth in (yyyy-mm-dd) format : ");
				String date = sc.next();
				psInsert.setInt(1, roll);
				psInsert.setString(2, name);
				psInsert.setInt(3, marks);
				psInsert.setDate(4, java.sql.Date.valueOf(date));
				System.out.println(psInsert.executeUpdate() +" row created.");
				break;
				
			case 2:
				ResultSet rs = psSelect.executeQuery();
				while(rs.next()) {
					System.out.println("Roll no : "+rs.getInt(1)+"\t"
					+"Name : "+rs.getString(2)+"\t"
					+"Marks : "+rs.getInt(3)+"\t"
					+"Date of Birth : "+rs.getDate(4));
				}
				break;
				
			case 3:
				System.out.println("Enter the roll number of the student you want to update the marks of : ");
				int rno = sc.nextInt();
				System.out.println("Enter the marks : ");
				int mks = sc.nextInt();
				psUpdate.setInt(1, mks);
				psUpdate.setInt(2, rno);
				System.out.println(psUpdate.executeUpdate() +" row updated.");
				break;
				
			case 4:
				System.out.println("Enter the roll no of the student you want to delete the record of : ");
				int roln = sc.nextInt();
				psDelete.setInt(1, roln);
				System.out.println(psDelete.executeUpdate() +" row updated.");
				break;
			
			case 5:
				System.out.println("Bye..");
				con.close();
				System.exit(0);
			
			default:
				System.out.println("Invalid Choice! Please try again.");
				break;
			}
		}
	}
}
