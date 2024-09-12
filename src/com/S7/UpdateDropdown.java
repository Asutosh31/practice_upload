package com.S7;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdateDropdown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_2023\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Assert false, result will be pass if condition satisfied
		//using assert false, without clicking the check box -> result pass
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());
		
		//code to click the check box
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).click();
		//using assert true after clicking the check box -> result pass
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());
		
		//using assert false after clicking the check box -> result fail
	//	Assert.assertFalse(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());
		
		//check and print the total chec kbox present in the page
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		//using assert equals to compare expected vs actual -> result pass
		Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 6);
		
		//using assert equals to compare expected vs actual -> result fail
		Assert.assertEquals(driver.findElements(By.cssSelector("input[id*='ctl00_mainContent_chk']")).size(), 7);
	}

}
