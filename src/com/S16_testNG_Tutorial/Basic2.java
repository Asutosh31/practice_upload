package com.S16_testNG_Tutorial;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Basic2 {
	
	@Parameters({"URL"})
	@Test(groups= {"smoke"})
	public void D1(String urlname)
	{
		System.out.println("God");
		System.out.println(urlname);
	}
	@Test
	public void D2()
	{
		System.out.println("God2");
	}
	@Test(groups={"smoke"})
	public void D3()
	{
		System.out.println("God3");
	}
	@Test
	public void D4()
	{
		System.out.println("God4");
	}

}
