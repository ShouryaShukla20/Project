package jdbc_demo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InsertDemo
{
	public static void main(String[] args)
	{
		int empid;
		String empname;
		double salary;
		String jdate;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee ID : ");
		empid = sc.nextInt();
		System.out.println("Enter Employee Name : ");
		empname = sc.next();
		System.out.println("Enter Employee Salary : ");
		salary = sc.nextDouble();
		System.out.println("Enter joining date as (dd/MM/yyyy) : ");
		jdate = sc.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate doj = LocalDate.parse(jdate,formatter);
		
		Connection con = DatabaseConnection.getConnection();
		
		String sql = "insert into Employee(empname,empid,joindate,salary) "
				+ " values (?,?,?,?) ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, empname);
			ps.setInt(2, empid);
			Date date = Date.valueOf(doj);
			ps.setDate(3, date);
			ps.setDouble(4, salary);
			
			int rs = ps.executeUpdate();
			System.out.println("1 row selected");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
