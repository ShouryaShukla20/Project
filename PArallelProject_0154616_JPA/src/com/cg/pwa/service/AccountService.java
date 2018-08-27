package com.cg.pwa.service;

import java.util.List;

import com.cg.pwa.beans.Account;
import com.cg.pwa.beans.Transaction;
import com.cg.pwa.exception.AccountException;

public interface AccountService
{
	String addAccount(Account account)  throws AccountException;
	Account searchAccount(String mobileNumber) throws AccountException;
	Account updateAccount(String mobileNumber, String customerName) throws AccountException;
	Account deposit(String mobileNumber, double amount) throws AccountException;
	Account withdraw(String mobileNumber, double amount) throws AccountException;
	public boolean fundTransfer(String sendMNo, String receiveMNo,double transAmount) throws AccountException;
	List<Account> getAccountDetails();
	List<Transaction> printTransactions();
	List<Transaction> printTrans(String mobileNumber);
	boolean validateAccount(Account account) throws AccountException;
	boolean validateMobile(String mobileNumber) throws AccountException;
}
