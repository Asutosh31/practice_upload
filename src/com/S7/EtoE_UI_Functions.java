package com.S7;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtoE_UI_Functions {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_2023\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.cssSelector("li[data-cy='roundTrip']")).click();
		driver.findElement(By.xpath("//li[@data-cy='oneWayTrip']")).click();
		driver.findElement(By.xpath("(//input[@id='fromCity'])[1]")).click();
		driver.findElement(By.cssSelector("input[placeholder='From']")).sendKeys("BLR");
		//driver.findElement(By.cssSelector("#toCity")).click();
		//driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Bhubaneswar");

		List<WebElement> options1 = driver.findElements(By.cssSelector("span[class='sr_iata font14 lightGreyText latoBold']"));
		for(WebElement option1 : options1)
		{
			if(option1.getText().equalsIgnoreCase("BLR"))
			{
				option1.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@id='toCity']")).click();
		driver.findElement(By.cssSelector("input#toCity")).sendKeys("BBI");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.cssSelector("div[class='font14 lightGreyText latoBold']"));
		for(WebElement option : options)
		{
			if(option.getText().equalsIgnoreCase("BBI"))
			{
				option.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//div[@aria-label='Wed Jul 17 2024']")).click();
		driver.findElement(By.xpath("//*[@data-cy='flightTraveller']")).click();
		driver.findElement(By.xpath("//*[@data-cy='adults-3']")).click();	
		driver.findElement(By.xpath("//*[@data-cy='children-2']")).click();	
		//driver.findElement(By.xpath("(//button[normalize-space()='APPLY'])[1]")).click();
		
//		WebElement element = driver.findElement(By.linkText("Search"));
//		element.click();
	}

}
