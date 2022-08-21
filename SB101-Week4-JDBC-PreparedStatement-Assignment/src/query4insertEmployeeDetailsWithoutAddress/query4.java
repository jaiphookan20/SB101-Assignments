package query4insertEmployeeDetailsWithoutAddress;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


/*
* Get input from user using Scanner class and use Prepared Statement to:  
*
* Develop a JDBC application to insert employee details without address, input should be
	given by the user.
*/

public class query4{

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter employeeid ");
		int id= s.nextInt();
		
		System.out.println("Enter name ");
		String name = s.next();
		
		System.out.println("Enter salary ");
		int sa = s.nextInt();
	
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/db2";
		
		try {
			
			Connection conn = DriverManager.getConnection(url,"root","qwerty123");
			
			PreparedStatement ps = conn.prepareStatement("insert into Employee2 values(?,?,null,?) ");
		
			ps.setInt(1, id);
			
			ps.setString(2, name);
			
			ps.setInt(3, sa);
			
			int x = ps.executeUpdate();
		
		
		if(x > 0) {
			
			System.out.println(x + " record inserted sucessfully"); 
		}
		
		else {
			System.out.println("not inserted...");
		}
	
		} 
		
		catch (SQLException e) {
	
			e.printStackTrace();
		}
		
	}
}