package com.cg.pwa.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.pwa.beans.Account;
import com.cg.pwa.exception.AccountException;
import com.cg.pwa.service.AccountService;
import com.cg.pwa.service.AccountServiceImpl;

public class TestDeposit
{
	AccountService aser = new AccountServiceImpl();
	
	@Test
	public void test1() throws AccountException
	{
		Account account = new Account("9848762536", "Vamshi", 2500);
		boolean b = true;
		assertEquals(b, aser.validateMobile(account.getMobileNumber()));
	}
	
	@Test
	public void test2() throws AccountException
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
	
	@Test(expected = AccountException.class)
	public void test3() throws AccountException
	{
		Account account = new Account("98482536", "Vamshi", 2500);
		boolean b = true;
		assertEquals(b, aser.validateMobile(account.getMobileNumber()));
	}
}
