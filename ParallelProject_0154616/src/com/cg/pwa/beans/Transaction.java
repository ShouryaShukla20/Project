package com.cg.pwa.beans;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.cg.pwa.dao.DatabaseConnection;

public class Transaction
{
	private static int transactionId;
	private String sendMNo;
	private String receiveMNo;
	private java.util.Date transDate;
	private java.sql.Date sqlDate;
	private double transAmount;
	private static int id;
	
	static
	{
		/*Connection con = DatabaseConnection.getConnection();
		String sql = "SELECT * FROM transactiondatabase ORDER BY transactionId DESC LIMIT 1";
//		String sql = "SELECT MAX(transactionId) FROM transactiondatabase";
//		String sql = "select transactionId from transactiondatabase";
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			id = rs.getInt("transactionId");
			transactionId = id++;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}*/
		
	}
	
	public Transaction()
	{
//		transactionId = (int) ((Math.random()*(1000))+2000);
		Connection con = DatabaseConnection.getConnection();
//		String sql = "SELECT * FROM transactiondatabase ORDER BY transactionId DESC LIMIT 1";
		String sql = "SELECT MAX(transactionId) FROM transactiondatabase";
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			id = rs.getInt("transactionId");
			transactionId = id++;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		transDate = new java.util.Date();
		sqlDate = new java.sql.Date(transDate.getTime());  
	}
	
	public Transaction(String sendMNo, String receiveMNo, double transAmount)
	{
		this();
		this.sendMNo = sendMNo;
		this.receiveMNo = receiveMNo;
		this.transAmount = transAmount;
	}

	public int getTransactionId() {
		return transactionId;
	}

/*	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
*/
	public String getSendMNo() {
		return sendMNo;
	}

	public void setSendMNo(String sendMNo) {
		this.sendMNo = sendMNo;
	}

	public String getReceiveMNo() {
		return receiveMNo;
	}

	public void setReceiveMNo(String receiveMNo) {
		this.receiveMNo = receiveMNo;
	}

	public Date getTransDate() {
		return transDate;
	}

	public java.sql.Date getSqlDate() {
		return sqlDate;
	}

	/*	public void setTransDate(LocalDate transDate) {
		this.transDate = transDate;
	}
*/
	public double getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(double transAmount) {
		this.transAmount = transAmount;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Transaction.id = id;
	}

	@Override
	public String toString() {
		return transactionId + ", " + sendMNo + ", " + receiveMNo + ", "
				+ transDate + ", " + transAmount;
	}
}
