package query3provideEmployeeBonus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


/*
 * Get input from user using Scanner class and use Prepared Statement to:  
 *
 * Develop a JDBC application to provide the bonus to all the employees as 500/.
 */

public class Query3 {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter bonus ");
		
		/* taking input for bonus amount from user */
		int id = keyboard.nextInt();
	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		
		catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/db2";
		
		try {
			Connection conn = DriverManager.getConnection(url,"root","qwerty123");
			
			PreparedStatement ps = conn.prepareStatement("UPDATE employee2 SET salary = salary+?"); //updating salary by amount set by user
			
			ps.setInt(1, id);
			
			int x = ps.executeUpdate();  
			
			/* executeUpdate() returns an integer - representing the number of rows affected, thus
			 * if number of rows affected is greater than 0, that means, update has occurred
			 *  */
		
		
		if(x > 0) {
			System.out.println(x + " record updated sucessfully");
		}
		else
			System.out.println("not updated...");
		
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
