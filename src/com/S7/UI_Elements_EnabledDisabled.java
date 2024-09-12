package com.S7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UI_Elements_EnabledDisabled {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_2023\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.makemytrip.com/");
		//using relative xpath
		driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
		//using index xpath
		driver.findElement(By.xpath("(//li[@data-cy='oneWayTrip'])[1]")).click();
		System.out.println(driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("(//li[@data-cy='oneWayTrip'])[1]")).isSelected());
		
		//isEnabled
		System.out.println(driver.findElement(By.xpath("//p[@class='latoBlack font12 greyText lineHeight16']")).isEnabled());
		
		//get attribute Before clicking on the round trip 
		System.out.println(driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).getAttribute("class"));
		driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
		//get attribute After clicking on round trip
		System.out.println(driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).getAttribute("class"));
		
		if(driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).getAttribute("class").contains("selected"))
			{
				System.out.println("it's clicked");
				Assert.assertTrue(true);
			}else
			{
				Assert.assertTrue(false);
			}

	}

}
