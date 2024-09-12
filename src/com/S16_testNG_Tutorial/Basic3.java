package com.S16_testNG_Tutorial;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Basic3 {
	@Parameters({"URL"})
	@Test
	public void PloanWeblogin(String urlname)
	{
		System.out.println("PloanWeb");
		System.out.println(urlname);
	}
	@BeforeMethod
	public void beforeevery()
	{
		System.out.println("I'll execute before every method in Basic3 class");
	}
	
	@Test
	public void PloanMobilelogin()
	{
		System.out.println("PloanMobile");
	}
	
	@Test
	public void PloanAPIlogin()
	{
		System.out.println("PloanAPI");
	}
	
	@BeforeTest
	public void beforetest()
	{
		System.out.println("I'll execute 1st");
	}
	@AfterTest
	public void aftertest()
	{
		System.out.println("I'll execute last");
	}
}
