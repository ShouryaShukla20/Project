package com.cg.pwa.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cg.pwa.beans.Account;
import com.cg.pwa.beans.Transaction;
import com.cg.pwa.exception.AccountException;

public class AccountDaoImpl implements AccountDao
{
	Connection con = DatabaseConnection.getConnection();
//	int transactionId = 101;
	
	@Override
	public String addAccount(Account account) throws AccountException, SQLException
	{
		String sql = "insert into accountdatabase(mobileNumber,customerName,initialBalance) "
				+ " values (?,?,?) ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, account.getMobileNumber());
			ps.setString(2, account.getCustomerName());
			ps.setDouble(3, account.getInitialBalance());
			int rs = ps.executeUpdate();
			return account.getMobileNumber();
	}

	@Override
	public Account searchAccount(String mobileNumber) throws AccountException, SQLException
	{
		String sql1 = "select mobileNumber, customerName, initialBalance "
				+ "from accountdatabase where mobileNumber= ? ";
		
		PreparedStatement ps = con.prepareStatement(sql1);
		ps.setString(1, mobileNumber);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			String mno = rs.getString(1);
			String cname = rs.getString(2);
			double balance = rs.getDouble(3);
			Account account = new Account(mno, cname, balance);
			return account;
		}
		else
		{
			throw new AccountException("Mobile Number Not Found in the Database");
		}
	}

	@Override
	public Account deposit(String mobileNumber, double amount) throws AccountException, SQLException
	{
		String sql1 = "select mobileNumber, customerName, initialBalance "
				+ "from accountdatabase where mobileNumber= ? ";
		PreparedStatement ps1 = con.prepareStatement(sql1);
		ps1.setString(1, mobileNumber);
		ResultSet rs = ps1.executeQuery();
		if(rs.next())
		{
			String mno = rs.getString(1);
			String cname = rs.getString(2);
			double balance = rs.getDouble(3);
			
			balance = balance+amount;
			
			String sql2 = "update accountdatabase set initialBalance=? where mobileNumber=? ";
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setDouble(1, balance);
			ps2.setString(2, mobileNumber);
			ps2.executeUpdate();
			Account account = new Account(mno, cname, balance);
			return account;
		}
		else
		{
			throw new AccountException("Mobile Number Not Found in the Database");
		}
	}

	@Override
	public Account withdraw(String mobileNumber, double amount)	throws AccountException, SQLException
	{
		String sql1 = "select mobileNumber, customerName, initialBalance "
				+ "from accountdatabase where mobileNumber= ? ";
		PreparedStatement ps1 = con.prepareStatement(sql1);
		ps1.setString(1, mobileNumber);
		ResultSet rs = ps1.executeQuery();
		if(rs.next())
		{
			String mno = rs.getString(1);
			String cname = rs.getString(2);
			double balance = rs.getDouble(3);
			if(amount<=balance)
			{
				balance = balance-amount;
				
				String sql2 = "update accountdatabase set initialBalance=? where mobileNumber=? ";
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setDouble(1, balance);
				ps2.setString(2, mobileNumber);
				ps2.executeUpdate();
				Account account = new Account(mno, cname, balance);
				return account;
			}
			else
			{
				throw new AccountException("Insufficient Funds");
			}
		}
		else
		{
			throw new AccountException("Mobile Number Not Found in the Database");
		}
	}

	@Override
	public boolean fundTransfer(String sendMNo, String receiveMNo, double transAmount) throws AccountException, SQLException
	{
		Transaction transaction =new Transaction(sendMNo, receiveMNo, transAmount);
		String sql1 = "select mobileNumber, customerName, initialBalance "
				+ "from accountdatabase where mobileNumber= ? ";
		PreparedStatement ps1 = con.prepareStatement(sql1);
		ps1.setString(1, sendMNo);
		
		String sql2 = "select mobileNumber, customerName, initialBalance "
				+ "from accountdatabase where mobileNumber= ? ";
		PreparedStatement ps2 = con.prepareStatement(sql1);
		ps2.setString(1, receiveMNo);
		
		ResultSet rs1 = ps1.executeQuery();
		ResultSet rs2 = ps2.executeQuery();
		if(rs1.next() && rs2.next())
		{
			String mno1 = rs1.getString(1);
			String cname1 = rs1.getString(2);
			double balance1 = rs1.getDouble(3);
			
			String mno2 = rs2.getString(1);
			String cname2 = rs2.getString(2);
			double balance2 = rs2.getDouble(3);
			if(transAmount<=balance1)
			{
				balance1 = balance1-transAmount;
				balance2 = balance2+transAmount;
				
				String sql3 = "update accountdatabase set initialBalance=? where mobileNumber=? ";
				PreparedStatement ps3 = con.prepareStatement(sql3);
				ps3.setDouble(1, balance1);
				ps3.setString(2, sendMNo);
				ps3.executeUpdate();
				
				String sql4 = "update accountdatabase set initialBalance=? where mobileNumber=? ";
				PreparedStatement ps4 = con.prepareStatement(sql4);
				ps4.setDouble(1, balance2);
				ps4.setString(2, receiveMNo);
				ps4.executeUpdate();
				
				String sql5 = "insert into transactiondatabase(transactionId,sendMNo,receiveMNo,transDate,transAmount) "
						+ " values (?,?,?,?,?) ";
				PreparedStatement ps5 = con.prepareStatement(sql5);
				ps5.setInt(1, transaction.getTransactionId());
				ps5.setString(2, sendMNo);
				ps5.setString(3, receiveMNo);
				ps5.setDate(4, transaction.getSqlDate());
				ps5.setDouble(5, transAmount);
				int rs = ps5.executeUpdate();
				return true;
			}
			else
			{
				throw new AccountException("Insufficient Funds");
			}
		}
		else
		{
			throw new AccountException("Sorry! Mobile Numbers not Found");
		}
	}

	@Override
	public ResultSet getAccountDetails() throws SQLException
	{
		String sql1 = "select * from accountdatabase";
		PreparedStatement ps1 = con.prepareStatement(sql1);
		ResultSet rs = ps1.executeQuery();	
		return rs;
	}

	@Override
	public ResultSet printTransactions() throws SQLException
	{
		String sql1 = "select * from transactiondatabase";
		PreparedStatement ps1 = con.prepareStatement(sql1);
		ResultSet rs = ps1.executeQuery();
		return rs;
	}

	@Override
	public ResultSet printTrans(String mobileNumber) throws SQLException, AccountException
	{
		String sql1 = "select transactionId,sendMNo, receiveMNo, transdate, transAmount from transactiondatabase where sendMNo = ? or receiveMNo = ?";
		PreparedStatement ps1 = con.prepareStatement(sql1);
		ps1.setString(1, mobileNumber);
		ps1.setString(2, mobileNumber);
		ResultSet rs = ps1.executeQuery();
		if(rs.next())
		{
			return rs;
		}
		else
		{
			throw new AccountException("Sorry. mobile Number Not Found");
		}
		
	}

	@Override
	public String updateAccount(String mobileNumber, String customerName) throws SQLException, AccountException
	{
		String sql1 = "update accountdatabase set customerName=? where mobileNumber=?";
		PreparedStatement ps1 = con.prepareStatement(sql1);
		ps1.setString(1, customerName);
		ps1.setString(2, mobileNumber);
		int r = ps1.executeUpdate();
		return "Updated Successfully";
	}
}
