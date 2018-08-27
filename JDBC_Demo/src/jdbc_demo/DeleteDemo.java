package jdbc_demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteDemo
{
	public static void main(String[] args)
	{
		Connection con = DatabaseConnection.getConnection();
		int empid;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee ID : ");
		empid = sc.nextInt();
		String sql = "delete from Employee where empid=? ";
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, empid);
			int r = ps.executeUpdate();
			System.out.println("1 row deleted");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

}
