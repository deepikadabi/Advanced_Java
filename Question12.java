package com.assignments.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//There is need to store employee information 
//[like : employee id, name, salary, join date] and 
//employee's address information [like : address id, city, country, employee id]. 
//Employee and Address information should be stored in separate tables. 
//Create a program which can insert employee and address records. 
//First store employee record and then address record. 
//Make sure, if the address record is not saved then employee transaction should be rollbacked.

public class Question12 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbcassignments", 
				"root", "root");
		Statement st = con.createStatement();
		//con.commit();
		System.out.println("Enter the Employee ID : ");
		int eid = sc.nextInt();
		System.out.println("Enter the Employee Name : ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("Enter the salary : ");
		float sal = sc.nextFloat();
		System.out.println("Enter the date of joining(yyyy-mm-dd) : ");
		String date = sc.next();
		
		String query = "insert into employee values("+eid+", '"+name+"', "+sal+", '"+date+"'"+")";
		//System.out.println(query);
		st.executeUpdate(query);
		System.out.println("Enter City : ");
		sc.nextLine();
		String city = sc.nextLine();
		System.out.println("Enter country : ");
		String country = sc.nextLine();
		
		if(city.length() == 0 || country.length() == 0) {
			con.setAutoCommit(false);
			con.rollback();
			con.setAutoCommit(true);
			System.out.println("Transaction rolled back!");
		}
		else {
			query = "insert into empaddress (city, country, empid) values('"+city+"', '"+country+"', "+eid+")";
			//System.out.println(query);
			st.executeUpdate(query);
			System.out.println("Record Updated!");
			//con.commit();
		}
		
		con.close();
		
	}

}

//create table employee(empid int primary key, name varchar(20), salary float(7,3), doj date);
//create table empaddress(addid int primary key auto_increment, city varchar(30), country varchar(20), empid int, 
//		foreign key (empid) references employee(empid));
