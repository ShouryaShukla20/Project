package com.cg.pwa.service;

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
	public String addAccount(Account account)  throws AccountException
	{
		return adao.addAccount(account);
	}

	@Override
	public List<Account> getAccountDetails()
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
	public Account searchAccount(String mobileNumber) throws AccountException
	{
		return adao.searchAccount(mobileNumber);
	}

	@Override
	public Account deposit(String mobileNumber, double amount) throws AccountException
	{
		return adao.deposit(mobileNumber, amount);
	}

	@Override
	public Account withdraw(String mobileNumber, double amount) throws AccountException
	{
		return adao.withdraw(mobileNumber, amount);
	}

	@Override
	public boolean fundTransfer(String sendMNo, String receiveMNo, double transAmount) throws AccountException
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
	public List<Transaction> printTransactions()
	{
		return adao.printTransactions();
	}

	@Override
	public List<Transaction> printTrans(String mobileNumber)
	{
		return adao.printTrans(mobileNumber);
	}

	@Override
	public Account updateAccount(String mobileNumber, String customerName) throws AccountException
	{
		return adao.updateAccount(mobileNumber, customerName);
	}
}
