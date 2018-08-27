package com.cg.pwa.dao;

import java.util.List;

import com.cg.pwa.beans.Account;
import com.cg.pwa.beans.Transaction;
import com.cg.pwa.exception.AccountException;

public interface AccountDao 
{
	String addAccount(Account account) throws AccountException;
	Account updateAccount(String mobileNumber, String customerName) throws AccountException;
	Account searchAccount(String mobileNumber) throws AccountException;
	Account deposit(String mobileNumber, double amount) throws AccountException;
	Account withdraw(String mobileNumber, double amount) throws AccountException;
	public boolean fundTransfer(String sendMNo, String receiveMNo,double transAmount) throws AccountException;
	List<Account> getAccountDetails();
	List<Transaction> printTransactions();
	List<Transaction> printTrans(String mobileNumber);
}
