package com.S16_testNG_Tutorial;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Basic4 {
	
	@Parameters({"URL"})
	@Test
	public void HloanWeblogin(String urlname)
	{
		System.out.println("HloanWeb");
		System.out.println(urlname);
	}
	
	@Test
	public void HloanMobilelogin()
	{
		System.out.println("HloanMobile");
	}
	
	@Test(groups={"smoke"})
	public void HloanAPIlogin()
	{
		System.out.println("HloanAPI");
	}
	@BeforeSuite
	public void firststSuite()
	{
		System.out.println("1st suite");
	}
	@AfterSuite
	public void LastSuite()
	{
		System.out.println("last suite");
	}
	@AfterMethod
	public void afterevery()
	{
		System.out.println("I'll execute after every method in Basic4 class");
	}
	@BeforeClass
	public void BeforeExcuteClass()
	{
		System.out.println("Before excute all methods in the class ~");
	}
	@AfterClass
	public void AfterExecuteClass()
	{
		System.out.println("After execute all methods in the class ~");
	}
}
