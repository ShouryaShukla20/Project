package com.cg.pwa.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cg.pwa.beans.Account;
import com.cg.pwa.beans.Transaction;
import com.cg.pwa.exception.AccountException;

public interface AccountService
{
	public String addAccount(Account account)  throws AccountException, SQLException;
	public Account searchAccount(String mobileNumber) throws AccountException, SQLException;
	public Account deposit(String mobileNumber, double amount) throws AccountException, SQLException;
	public Account withdraw(String mobileNumber, double amount) throws AccountException, SQLException;
	public boolean fundTransfer(String sendMNo, String receiveMNo,double transAmount) throws AccountException, SQLException;
	public ResultSet getAccountDetails() throws SQLException;
	public ResultSet printTransactions() throws SQLException;
	public ResultSet printTrans(String mobileNumber) throws SQLException, AccountException;
	public boolean validateAccount(Account account) throws AccountException;
	public boolean validateMobile(String mobileNumber) throws AccountException;
	public String updateAccount(String mobileNumber, String customerName) throws AccountException, SQLException;
}
