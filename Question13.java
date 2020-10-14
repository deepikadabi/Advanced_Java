package com.assignments.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Question13 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcassignments", 
				"root", "root");
		String query = "select * from employee as emp, empaddress as ead where emp.empid = ead.empid";
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+
		rs.getString(2)+"\t"+
		rs.getFloat(3)+ "\t"+
		rs.getDate(4)+"\t"+
		rs.getString(6)+"\t"+
		rs.getString(7)+"\t");
		}
		con.close();
	}	

}
