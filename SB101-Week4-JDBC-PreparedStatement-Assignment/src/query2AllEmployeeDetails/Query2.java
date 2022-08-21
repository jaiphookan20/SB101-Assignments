package query2AllEmployeeDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
 *Get input from user using Scanner class and use Prepared Statement to:  
 *
 *Develop a JDBC application to get all employee’s all details from the table
 */


public class Query2 {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		
		catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		
		String url= "jdbc:mysql://localhost:3306/db2";
		
		try {
			Connection conn = DriverManager.getConnection(url,"root","qwerty123");
			
			PreparedStatement ps = conn.prepareStatement("select * from Employee2");
			
			ResultSet rs= ps.executeQuery();
			
			/* Using while loop here because we are expecting more than record to appear */
			while(rs.next()) {
				System.out.println("Employee id is "+ rs.getInt("eid"));
				System.out.println("Employee name is "+ rs.getString("name"));
				System.out.println("Employee address is "+ rs.getString("address"));
				System.out.println("Salary is "+ rs.getInt("salary"));
			
			System.out.println("-------------------------------");
		}
		
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
}


/* This program actually doesn't output anything, not even the simple 'Employee doesn't exist' message
  like in the previous query1employeeSalary one, because as we were expecting multiple records, and thus we did not use an
  if-else statement but a while (res.next() -> thus since there are no SQL statement mistakes
  but no records exist, it just doesn't output anything. 
  
 */