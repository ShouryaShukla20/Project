package com.cg.pwa.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.pwa.beans.Account;
import com.cg.pwa.beans.Transaction;
import com.cg.pwa.exception.AccountException;

public class AccountDaoImpl implements AccountDao
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = emf.createEntityManager();
	
	@Override
	public String addAccount(Account account) throws AccountException
	{
		em.getTransaction().begin();
		em.persist(account);
		em.getTransaction().commit();
		return account.getMobileNumber();
	}
	
	@Override
	public Account searchAccount(String mobileNumber) throws AccountException
	{
		Account a1 = em.find(Account.class, mobileNumber);
		if(a1 != null)
		{
			return a1;
		}
		else
		{
			throw new AccountException("Account Not Found");
		}
	}

	@Override
	public Account deposit(String mobileNumber, double amount) throws AccountException
	{
		Account a1 = em.find(Account.class, mobileNumber);
		if(a1 != null)
		{
			double balance = a1.getInitialBalance();
			balance = balance+amount;
			a1.setInitialBalance(balance);
			em.getTransaction().begin();
			em.merge(a1);
			em.getTransaction().commit();
			return a1;
		}
		else
		{
			throw new AccountException("Account Not Found");
		}
	}

	@Override
	public Account withdraw(String mobileNumber, double amount) throws AccountException
	{
		Account a1 = em.find(Account.class, mobileNumber);
		if(a1 != null)
		{
			double balance = a1.getInitialBalance();
			balance = balance-amount;
			if(balance<0)
			{
				throw new AccountException("Insufficient Funds");
			}
			else
			{
				a1.setInitialBalance(balance);
				em.getTransaction().begin();
				em.merge(a1);
				em.getTransaction().commit();
				return a1;
			}
		}
		else
		{
			throw new AccountException("Account Not Found");
		}
	}

	@Override
	public boolean fundTransfer(String sendMNo, String receiveMNo, double transAmount) throws AccountException
	{
		Transaction transaction =new Transaction(sendMNo, receiveMNo, transAmount);
		Account a1 = em.find(Account.class, sendMNo);
		Account a2 = em.find(Account.class, receiveMNo);
		if((a1 != null) && (a2 != null))
		{
			double balance1 = a1.getInitialBalance();
			double balance2 = a2.getInitialBalance();
			if(balance1>=transAmount)
			{
				balance1 = balance1-transAmount;
				balance2 = balance2+transAmount;
				a1.setInitialBalance(balance1);
				a2.setInitialBalance(balance2);
				em.getTransaction().begin();
				em.persist(transaction);
				em.merge(a1);
				em.merge(a2);
				em.getTransaction().commit();
				return true;
			}
			else
			{
				throw new AccountException("Sorry ! You don't have sufficient Funds");
			}
		}
		else
		{
			throw new AccountException("Sorry! Mobile Numbers not Found");
		}
	}

	@Override
	public List<Account> getAccountDetails()
	{
		String sql="select account from Account account";
		Query query = em.createQuery(sql);
		List<Account> account = query.getResultList();
		return account;	
	}

	@Override
	public List<Transaction> printTransactions()
	{
		String sql="select transaction from Transaction transaction";
		Query query = em.createQuery(sql);
		List<Transaction> transaction = query.getResultList();
		return transaction;
	}

	@Override
	public List<Transaction> printTrans(String mobileNumber)
	{
		String sql="select transaction from Transaction transaction where transaction.sendMNo=:mobile1 or transaction.receiveMNo=:mobile2";
		TypedQuery<Transaction> query = em.createQuery(sql, Transaction.class);
		query.setParameter("mobile1", mobileNumber);
		query.setParameter("mobile2", mobileNumber);
		List<Transaction> transaction = query.getResultList();
		return transaction;
	}
	
	@Override
	public Account updateAccount(String mobileNumber, String customerName) throws AccountException
	{
		Account a1 = em.find(Account.class, mobileNumber);
		if(a1 != null)
		{
			a1.setCustomerName(customerName);
			em.getTransaction().begin();
			em.merge(a1);
			em.getTransaction().commit();
		}
		else
		{
			throw new AccountException("Mobile Number Not Found");
		}
		return null;
	}
}
