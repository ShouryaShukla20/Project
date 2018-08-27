package com.cg.pwa.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cg.pwa.beans.Account;
import com.cg.pwa.beans.Transaction;
import com.cg.pwa.dao.AccountDao;
import com.cg.pwa.dao.AccountDaoImpl;
import com.cg.pwa.exception.AccountException;

public class AccountServiceImpl implements AccountService
{
	AccountDao adao = new AccountDaoImpl(); 
	@Override
	public String addAccount(Account account)  throws AccountException, SQLException
	{
		return adao.addAccount(account);
	}

	@Override
	public ResultSet getAccountDetails() throws SQLException
	{
		return adao.getAccountDetails();
	}

	@Override
	public boolean validateAccount(Account account) throws AccountException
	{
		if(!account.getMobileNumber().matches("[7-9][0-9]{9}"))
		{
				throw new AccountException("Invalid Mobile Number");
		}
		if(!account.getCustomerName().matches("[A-Z][A-Za-z\\s]{3,35}"))
		{
			throw new AccountException("Invalid Customer Name");
		}
		if((account.getInitialBalance()<0))
		{
			throw new AccountException("Initial Balance cannot be less than Zero");
		}
		return true;
	}

	@Override
	public Account searchAccount(String mobileNumber) throws AccountException, SQLException
	{
		return adao.searchAccount(mobileNumber);
	}

	@Override
	public Account deposit(String mobileNumber, double amount) throws AccountException, SQLException
	{
		return adao.deposit(mobileNumber, amount);
	}

	@Override
	public Account withdraw(String mobileNumber, double amount) throws AccountException, SQLException
	{
		return adao.withdraw(mobileNumber, amount);
	}

	@Override
	public boolean fundTransfer(String sendMNo, String receiveMNo, double transAmount) throws AccountException, SQLException
	{
		return adao.fundTransfer(sendMNo, receiveMNo, transAmount);
	}

	@Override
	public boolean validateMobile(String mobileNumber) throws AccountException
	{
		if(!mobileNumber.matches("[7-9][0-9]{9}"))
		{
				throw new AccountException("Please Enter a Valid Mobile Number");
		}
		return true;
	}

	@Override
	public ResultSet printTransactions() throws SQLException
	{
		return adao.printTransactions();
	}

	@Override
	public ResultSet printTrans(String mobileNumber) throws SQLException, AccountException
	{
		return adao.printTrans(mobileNumber);
	}
	
	@Override
	public String updateAccount(String mobileNumber, String customerName) throws AccountException, SQLException
	{
		return adao.updateAccount(mobileNumber, customerName);
	}
}
