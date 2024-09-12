package com.S11;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

public class Scope_LinkCount {

	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver", "F:\\Selenium_2023\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://qaclickacademy.com/practice.php");
		
		//count the total nos of link
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//To get the links present in  the footer section
		//limit the driver make a child of main driver
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		//To get the links present in the 1st column of the footer section table
		WebElement columndriver = driver.findElement(By.xpath("//div/table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
	}

}
