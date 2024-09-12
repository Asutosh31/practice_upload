package com.S9;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization_ExplicityWait {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_2023\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String[] itemsNeeded = { "Cauliflower", "Cucumber", "Onion" };
		driver.manage().window().maximize();
		
		//Explicit wait class created in global level
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("http://rahulshettyacademy.com/seleniumPractise/");
		
		addItems(driver, itemsNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		//Explicit wait implemented for target locator
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class='promoCode']")));
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		
		//Explicit wait implemented for target locator
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

		
	
		
		
		
		
		
		
		
		
		
	}
		public static void addItems(WebDriver driver, String[] itemsNeeded) {
			
			int j = 0;
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
 
			// Cauliflower - 1 Kg
			// Cucumber - 1 Kg
			// Beetroot - 1 Kg
			// To extract/split the word
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();

			List itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedName)) {
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				// if(j==6) - No need to give the Numbers of product present in Array
				if (j == itemsNeeded.length) {
					break;
				}
			}
		}

	}

}
