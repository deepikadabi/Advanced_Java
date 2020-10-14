package com.assignments.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Question17 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcassignments", 
				"root", "root");
		Statement st = con.createStatement();
		String query = "select emp.*, ead.*, floor(datediff(sysdate(), doj)/365) as years from employee emp, empaddress ead "
				+ "where emp.empid = ead.empid having years>5";
		ResultSet rs = st.executeQuery(query);
		if(rs.next()) {
			do {
				System.out.println(rs.getInt(1)+"\t"+
								rs.getString(2)+"\t"+
								rs.getFloat(3)+"\t"+
								rs.getDate(4)+"\t"+
								rs.getString(6)+"\t"+
								rs.getString(7));
			}while(rs.next());
		}
		else {
			System.out.println("No records found.");
		}
		
	}

}
