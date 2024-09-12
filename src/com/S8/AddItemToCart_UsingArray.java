package com.S8;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddItemToCart_UsingArray {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_2023\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String[] names = {"Cauliflower" , "Cucumber" , "Beetroot"};
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://rahulshettyacademy.com/seleniumPractise/");
		List<WebElement> product = driver.findElements(By.xpath("//div[@class='product'][3]"));
		for(int i=0; i<product.size(); i++)
		{
			String name = product.get(i).getText();
			if(name.contains("Cucumber"))
			{
				//Thread.sleep(3000);
				driver.findElements(By.xpath("//div[3]//div[3]//button[1]")).get(i).click();
				break;
			}
		}
				
	}

}
