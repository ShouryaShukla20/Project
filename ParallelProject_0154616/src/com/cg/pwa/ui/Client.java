package com.cg.pwa.ui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.cg.pwa.beans.Account;
import com.cg.pwa.beans.Transaction;
import com.cg.pwa.exception.AccountException;
import com.cg.pwa.service.AccountService;
import com.cg.pwa.service.AccountServiceImpl;

public class Client
{
	public static void main(String[] args) throws SQLException
	{
		AccountService aser = new AccountServiceImpl(); 
		Scanner sc = new Scanner(System.in);
		
		do
		{
		System.out.println("Menu: ");
		System.out.println("1. Add Account Details");
		System.out.println("2. Update Account Details");
		System.out.println("3. Search Account");
		System.out.println("4. Deposit");
		System.out.println("5. Withdraw");
		System.out.println("6. Fund Transfer");
		System.out.println("7. Display All Account Details");
		System.out.println("8. Print Transactions using Mobile Number");
		System.out.println("9. Print All Transactions");
		System.out.println("10. Exit");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Enter Customer Mobile Number: ");
			sc.nextLine();
			String mobileNumber = sc.nextLine();
			try {
				if(aser.validateMobile(mobileNumber))
				{
					System.out.println("Enter Customer Name: ");
					String customerName = sc.nextLine();
					System.out.println("Enter Initial balance: ");
					double initialBalance = sc.nextDouble();
					Account account = new Account(mobileNumber, customerName, initialBalance);
					try {
						if(aser.validateAccount(account))
						{
							aser.addAccount(account);
							System.out.println(account);
						}
					} catch (AccountException e) {
						System.out.println(e);
					}
				}
			} catch (AccountException e2) {
				System.out.println(e2);
			}
			break;
		
		case 2:
			System.out.println("Enter the Mobile Number to be updated:");
			sc.nextLine();
			String mobileNumber2 = sc.nextLine();
			try {
				if(aser.validateMobile(mobileNumber2))
				{
					Account account2;
					try {
						account2 = aser.searchAccount(mobileNumber2);
						System.out.println("Enter new Customer Name:");
						String customerName2 = sc.nextLine();
						aser.updateAccount(mobileNumber2, customerName2);
						account2.setCustomerName(customerName2);
						System.out.println(account2);
					} catch (AccountException e1) {
						System.out.println(e1);
					}
				}
			} catch (AccountException e2) {
				System.out.println(e2);
			}
			break;
			
		case 3:
			System.out.println("Enter the Mobile Number to be searched:");
			sc.nextLine();
			String mobileNumber3 = sc.nextLine();
			try {
				if(aser.validateMobile(mobileNumber3))
				{
					Account account3;
					try {
						account3 = aser.searchAccount(mobileNumber3);
						System.out.println(account3);
					} catch (AccountException e1) {
						System.out.println(e1);
					}
				}
			} catch (AccountException e2) {
				System.out.println(e2);
			}
			break;
		
		case 4:	
			System.out.println("Enter Mobile number to deposit:");
			sc.nextLine();
			String mobileNumber4 = sc.nextLine();
			try {
				if(aser.validateMobile(mobileNumber4))
				{
					System.out.println("Enter amount to be deposited");
					double depositAmount = sc.nextDouble();
					Account account4;
					try {
						account4 = aser.deposit(mobileNumber4, depositAmount);
						System.out.println(account4);
					} catch (AccountException e1) {
						System.out.println(e1);
					}
				}
			} catch (AccountException e2) {
				System.out.println(e2);
			}
			break;
		
		case 5:
			System.out.println("Enter Mobile number to withdraw:");
			sc.nextLine();
			String mobileNumber5 = sc.nextLine();
			try {
				if(aser.validateMobile(mobileNumber5))
				{
					System.out.println("Enter amount to be withdrawn");
					double withdrawAmount = sc.nextDouble();
					Account account5;
					try {
						account5 = aser.withdraw(mobileNumber5, withdrawAmount);
						System.out.println(account5);
					} catch (AccountException e1) {
						System.out.println(e1);
				}
				}
			} catch (AccountException e2) {
				System.out.println(e2);
			}
			break;
			
		case 6:
			System.out.println("Enter Send Mobile Number : ");
			sc.nextLine();
			String sendMNo = sc.nextLine();
			try 
			{
				if(aser.validateMobile(sendMNo))
				{
					System.out.println("Enter Receive Mobile Number : ");
					String receiveMNo = sc.nextLine();
					if(aser.validateMobile(receiveMNo))
					{
						System.out.println("Enter Transfer Amount");
						double transAmount = sc.nextDouble();
						if(transAmount>0)
						{
							try {
								aser.fundTransfer(sendMNo, receiveMNo, transAmount);
								System.out.println("Transaction Done Successfully ");
							} catch (AccountException e) {
								System.out.println(e);
							}
						}
						else
						{
							System.out.println("Please Enter a valid amount");
						}
					}
				}
			}
			catch (AccountException e1)
			{
				System.out.println(e1);
			}
			break;
			
		case 7:
			ResultSet rs = aser.getAccountDetails();
			while(rs.next())
			{
				String mobileNumber7 = rs.getString("mobileNumber");
				String customerName7 = rs.getString("customerName");
				double balance = rs.getDouble("initialBalance");
				System.out.println(mobileNumber7 +  " " + customerName7 + " " + balance);
			}
			break;
		
		case 8:
			System.out.println("Enter Mobile Number to print transactions : ");
			sc.nextLine();
			String mobileNumber8 = sc.next();
			try {
				if(aser.validateMobile(mobileNumber8))
				{
						ResultSet rs1 = aser.printTrans(mobileNumber8);
						while(rs1.next())
						{
							int transactionId9 = rs1.getInt("transactionId");
							String sendMNo9 = rs1.getString("sendMNo");
							String receiveMNo9 = rs1.getString("receiveMNo");
							double transAmount9 = rs1.getDouble("transAmount");
							java.sql.Date transDate = rs1.getDate("transDate");
							System.out.println(transactionId9 + " " + sendMNo9 + " " + receiveMNo9
									+ " " + transAmount9 + " " + transDate);
						}
				}
			} catch (AccountException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case 9:
			ResultSet rs2 = aser.printTransactions();
			while(rs2.next())
			{
				int transactionId9 = rs2.getInt("transactionId");
				String sendMNo9 = rs2.getString("sendMNo");
				String receiveMNo9 = rs2.getString("receiveMNo");
				double transAmount9 = rs2.getDouble("transAmount");
				java.sql.Date transDate = rs2.getDate("transDate");
				System.out.println(transactionId9 + " " + sendMNo9 + " " + receiveMNo9
						+ " " + transAmount9 + " " + transDate);
			}
			break;
			
		case 10:
			System.out.println("Thanks for using the Application");
			System.exit(0);
		
		default:
			System.out.println("Please Enter a Valid Input");
			break;
		}
		}while(true);
	}
}
