package jdbc_demo;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class SelectDemo
{
	public static void main(String[] args)
	{
		String sql = "select empname, empid, salary, joindate"
				+ " from Employee where salary > ?";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Salary : ");
		double salary = sc.nextDouble();
		Connection con = DatabaseConnection.getConnection();
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, salary);
//Return type of executeUpdate is int
//Return type of executeQuery is ResultSet 
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
//				String name = rs.getString(1);
				String name = rs.getString("empname");
				int id = rs.getInt("empid");
				double sal = rs.getDouble("salary");
				Date date = rs.getDate("joindate");
				LocalDate jd = date.toLocalDate();
				System.out.println(name+" "+id+" "+sal+" "+jd);
				
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}		
	}
}
