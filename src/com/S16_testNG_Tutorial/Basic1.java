package com.S16_testNG_Tutorial;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Basic1 {

	@Parameters({"URL"})
	@Test
	public void demo(String urlname)
	{
		System.out.println("Maa");
		System.out.println(urlname);

	}
	@Test
	public void demo2()
	{
		System.out.println("Devine");
	}
}
