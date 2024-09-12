package com.S6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_2023\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://google.com");
		driver.navigate().to("https://rahulshettyacademy.com/locatorspractice");
		
		//using CSS selector
		//CSS -> tagname#Id
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("Asu");
		
		//CSS -> tagname[attribute=value]
		driver.findElement(By.cssSelector("input[name=inputPassword]")).sendKeys("12345");
		driver.findElement(By.className("signInBtn")).click();
		
		//CSS -> tagname.classname
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		//link text
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		//Xpath
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Asu");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("rahul@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9938000111");
		
		//CSS -> tagname[attribute='value']:nth-child(index)
		driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("123333331");
		//CSS -> .classname
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		//CSS -> ParentTagname ChildTagname
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		//driver.close();
		//driver.quit();
		
		
		
	}

}
