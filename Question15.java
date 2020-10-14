package com.assignments.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Question15 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcassignments", 
				"root", "root");
		
		System.out.println("Enter the city you want to check the records of : ");
		String city = sc.nextLine();
		String query = "select * from employee as emp, empaddress as ead where emp.empid = ead.empid and ead.city='"+city+"'";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+
					rs.getString(2)+"\t"+
					rs.getFloat(3)+"\t"+
					rs.getDate(4)+"\t"+
					rs.getString(6)+"\t"+
					rs.getString(7));
		}
		con.close();
	}

}
