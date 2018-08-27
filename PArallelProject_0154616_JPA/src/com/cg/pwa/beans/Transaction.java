package com.cg.pwa.beans;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction
{
	@Id
	private int transactionId;
	private String sendMNo;
	private String receiveMNo;
	private Date transDate;
	private double transAmount;
	private static int id = 101;
	
	public Transaction()
	{
		transactionId = id++;
		Instant current = Instant.now();
		transDate = Date.from(current);
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
