package jdbc_demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateDemo
{
	public static void main(String[] args)
	{
		Connection con = DatabaseConnection.getConnection();
		double salary;
		int empid;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee ID : ");
		empid = sc.nextInt();
		System.out.println("Enter Employee Salary : ");
		salary = sc.nextDouble();
		String sql = "update employee set salary=? where empid=? ";
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, salary);
			ps.setInt(2, empid);
			int r = ps.executeUpdate();
			System.out.println("1 row updated");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
