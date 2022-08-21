package query5searchEmployeeOnID;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


/*
* Get input from user using Scanner class and use Prepared Statement to:  
*
* Develop a JDBC application to search Employees based on Id.
*/


public class query5 {


	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter id of Employee you want to search: ");
		int id = s.nextInt();
	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url= "jdbc:mysql://localhost:3306/db2";
		
		try {
			Connection conn = DriverManager.getConnection(url,"root","qwerty123");
		
		/* search Employees based on Id. */
			
		PreparedStatement ps =	conn.prepareStatement("select * from Employee2 where eid=?");
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()) {
			System.out.println("Employee id is " + rs.getInt("eid"));
			System.out.println("Employee name is " + rs.getString("name"));
			System.out.println("Employee address is "+ rs.getString("address"));
			System.out.println("Salary is "+ rs.getInt("salary"));
			
			System.out.println("-------------------------------");
		}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}


/* 

Output is: 

Enter id of Employee you want to search: 
1
Employee id is 1
Employee name is Jai
Employee address is null
Salary is 80000


*/