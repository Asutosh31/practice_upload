package com.S7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_Alerts {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_2023\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		driver.findElement(By.cssSelector("[id='name']")).sendKeys("Asu");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		driver.switchTo().alert().accept();

		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[class='btn-style']")).click();
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[class='btn-style']")).click();
		driver.switchTo().alert().accept();

	}

}
