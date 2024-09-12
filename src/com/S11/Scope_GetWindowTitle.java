package com.S11;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope_GetWindowTitle {

	public static void main(String[] args) throws InterruptedException {
	//	System.setProperty("Webdriver.chrome.driver", "F:\\Selenium_2023\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://qaclickacademy.com/practice.php");
		
		//To get the links present in the 1st column of the footer section table
		WebElement columndriver = driver.findElement(By.xpath("//div/table/tbody/tr/td[1]/ul"));
		
		//open all the links present in the 1st column of the table
		for(int i=1; i<columndriver.findElements(By.tagName("a")).size(); i++)
		{
			//without opening separate window or going back from child tab to main tab again and again
			//direct open one by one link to the right from the main tab
			String clicksOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clicksOnLinkTab);
		}
			Set<String> st = driver.getWindowHandles();
			Iterator<String> it = st.iterator();
		
			Thread.sleep(5000);
			while(it.hasNext())
			{
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
		}

	}


