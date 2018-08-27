package com.cg.pwa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cg.pwa.beans.Account;
import com.cg.pwa.beans.Transaction;
import com.cg.pwa.exception.AccountException;

public interface AccountDao 
{
	public String addAccount(Account account) throws AccountException, SQLException;
	public Account searchAccount(String mobileNumber) throws AccountException, SQLException;
	public Account deposit(String mobileNumber, double amount) throws AccountException, SQLException;
	public Account withdraw(String mobileNumber, double amount) throws AccountException, SQLException;
	public boolean fundTransfer(String sendMNo, String receiveMNo,double transAmount) throws AccountException, SQLException;
	public ResultSet getAccountDetails() throws SQLException;
	public ResultSet printTransactions() throws SQLException;
	public ResultSet printTrans(String mobileNumber) throws SQLException, AccountException;
	public String updateAccount(String mobileNumber, String customerName) throws SQLException, AccountException;
}
