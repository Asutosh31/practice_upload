package com.S15;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokingTabs_UsingSelenium {

	public static void main(String[] args) {
		
		System.setProperty("Webdriver.chrome.driver", "F:\\Selenium_2023\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> handle = driver.getWindowHandles();
		Iterator<String> it = handle.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com");
		
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/get']"))
		.get(1).getText();
		driver.switchTo().window(parentWindow);
		driver.findElement(By.name("name")).sendKeys(courseName);
		//driver.quit();
		
	}

}
