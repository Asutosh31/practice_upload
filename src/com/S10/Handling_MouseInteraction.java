package com.S10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import net.bytebuddy.implementation.bytecode.ShiftLeft;

public class Handling_MouseInteraction {

	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver", "F:\\Selenium_2023\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/ref=nav_logo");
		Actions a = new Actions(driver);
		
		//use Shift key to caps on
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("asu").build().perform();
		
		//double click or select the text
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).doubleClick().build().perform();
		
		//moves to a specific element
		WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		a.moveToElement(move).build().perform();
		
		//right click
		a.moveToElement(move).contextClick().build().perform();
		
		
		

	}

}
