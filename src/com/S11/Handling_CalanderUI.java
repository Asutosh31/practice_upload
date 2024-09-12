package com.S11;

import java.text.ParseException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_CalanderUI {

	public static void main(String[] args) {
		
		String monthNumber = "7";
		String date = "31";
		String year = "2024";
		String[] expecteDate = {monthNumber,date,year};
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();
	
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
		List<WebElement> actualDate = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
	
		for(int i=0; i<actualDate.size(); i++)
		{
			System.out.println(actualDate.get(i).getAttribute("value"));
			Assert.assertEquals(actualDate.get(i).getAttribute("value"), expecteDate[i]);
		}
		System.out.println("Testcase Pass");
		driver.quit();
	}

}
