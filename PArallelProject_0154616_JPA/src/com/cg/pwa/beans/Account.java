package com.cg.pwa.beans;

import java.util.Random;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account 
{
	@Id
	private String mobileNumber;
	private String customerName;
	private double initialBalance;
	
	public Account(String mobileNumber, String customerName,
			double initialBalance)
	{
		this();
		this.mobileNumber = mobileNumber;
		this.customerName = customerName;
		this.initialBalance = initialBalance;
	}

	public Account()
	{
		
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}

	@Override
	public String toString()
	{
		return mobileNumber + " " + customerName + " " + initialBalance;
	}
}
