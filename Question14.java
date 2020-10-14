package com.assignments.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Question14 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcassignments", 
				"root", "root");
		Statement st = con.createStatement();
		System.out.println("Enter the empId : ");
		int eid = sc.nextInt();
		String query = "select name, city, country from employee emp, empaddress eadd where emp.empid = eadd.empid and emp.empid="+eid;
		
		ResultSet rs = st.executeQuery(query);
		if(rs.next()) {
			do {
				System.out.println(rs.getString(1)+"'s Address : "+rs.getString(2)+", "+rs.getString(3));
			}while(rs.next());
		}
		else {
			System.out.println("No Records found");
		}
		
		con.close();
	}

}
