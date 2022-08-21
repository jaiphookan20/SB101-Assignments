package query1employeeSalary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/* 
 * Create the Database and tables as follows:

create database db2;
	use db2;
	Table:
	Employee2
	eid int primary key
	name varchar(15)
	address varchar(15)
	salary int
 * 
Get input from user using Scanner class and use Prepared Statement to do the following :

1) Develop a JDBC application to get the salary of a particular employee, whose Id is given
by the user.

 * */


public class Queries {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter id");
		
		int id= keyboard.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		String url= "jdbc:mysql://localhost:3306/db2";
		
		try {
			
		Connection conn = DriverManager.getConnection(url,"root","qwerty123");
			
		PreparedStatement ps=	conn.prepareStatement("select salary from Employee2 where eid=?");
		
		ps.setInt(1, id); 
		
		/* 
		
		1st parameter refers to the column no of the query you are providing for '?'
		ie since we are providing 'eid' which is column 1 of the table Employee2, we insert 1 into the first param
		
		2nd parameter refers to the 'id' variable that we are taking input for from the user
		
		preparedStatementObject.setInt() -> we are using this because the data we want back is of type int
		
		if we wanted a String result back, we would've used 
		preparedStatementObject.setString()
		For eg PreparedStatement ps= conn.prepareStatement("select * from student where name =?")); 
		
		
		*/
		
		ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
				System.out.println("Salary is " + rs.getInt("salary"));
			}
			else {
				System.out.println("Employee doesnt exist");
			}
		} 
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}