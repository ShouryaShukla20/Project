package com.cg.pwa.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.cg.pwa.beans.Account;
import com.cg.pwa.beans.Transaction;
import com.cg.pwa.exception.AccountException;
import com.cg.pwa.service.AccountService;
import com.cg.pwa.service.AccountServiceImpl;

public class TestProject
{
	AccountService aser = new AccountServiceImpl(); 

	@Test
	public void testAccount1()
	{
		Account account1 = new Account("9848762536", "Vamshi", 2500);
		assertEquals("9848762536", account1.getMobileNumber());
		assertEquals("Vamshi", account1.getCustomerName());
	}
	
	@Test(expected = AssertionError.class)
	public void testAccount2()
	{
		Account account2 = new Account("9848762536", "Vamshi", 2500);
		assertEquals("9495621546", account2.getMobileNumber());
		assertEquals("Vamshi", account2.getCustomerName());
	}
	
	@Test(expected = AssertionError.class)
	public void testTransaction()
	{
		Transaction transaction = new Transaction("9848762536", "9491562193", 42000);
		assertEquals("9848762536", transaction.getSendMNo());
		assertEquals("9491562193", transaction.getReceiveMNo());
		assertEquals(42000.0, transaction.getTransAmount());
	}
	
	@Test
	public void testValidatemobile1() throws AccountException
	{
		Account account = new Account("9848762536", "Vamshi", 2500);
		boolean b = true;
		assertEquals(b, aser.validateMobile(account.getMobileNumber()));
	}
	
	@Test
	public void testValidatemobile12() throws AccountException
	{
		Account account = new Account("98482536", "Vamshi", 2500);
		boolean b = true;
		try
		{
			assertEquals("Please Enter a Valid Mobile Number", aser.validateMobile(account.getMobileNumber()));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	@Test
	public void testWithdraw1()
	{
		Account account = new Account("9848762536", "Vamshi", 2500);
		try {
			try {
				assertEquals(1500, aser.withdraw(account.getMobileNumber(), 1000));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (AccountException e){
			System.out.println(e);
		}
	}
	
	@Test
	public void testWithdraw2()
	{
		Account account = new Account("9491562193", "Krishna", 5000);
		try {
			try {
				assertEquals(2500, aser.withdraw(account.getMobileNumber(), 2500));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (AccountException e){
			System.out.println(e);
		}
	}
	
	@Test
	public void testDeposit1()
	{
		Account account = new Account("9848762536", "Vamshi", 2500);
		try {
			try {
				assertEquals(5000, aser.deposit(account.getMobileNumber(), 2500));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (AccountException e){
			System.out.println(e);
		}
	}
	
	@Test
	public void testDeposit2()
	{
		Account account = new Account("9491562193", "Krishna", 5000);
		try {
			try {
				assertEquals(2500, aser.deposit(account.getMobileNumber(), 2500));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (AccountException e){
			System.out.println(e);
		}
	}
	
	@Test
	public void testTransfer1()
	{
		Account account1 = new Account("9848762536", "Vamshi", 2500);
		Account account2 = new Account("9491562193", "Krishna", 5000);
		try {
			try {
				assertEquals(5200, aser.fundTransfer(account1.getMobileNumber(), account2.getMobileNumber(), 200));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (AccountException e){
			System.out.println(e);
		}
	}
	
	@Test(expected=AssertionError.class)
	public void testPrintTrans()
	{
		Account account1 = new Account("9848762536", "Vamshi", 2500);
		try {
			assertEquals(account1, aser.printTrans(account1.getMobileNumber()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
