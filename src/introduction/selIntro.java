package introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class selIntro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

   		System.setProperty("webdriver.driver.chromedriver", "/introduction/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	//	System.setProperty("webdriver.gecko.driver", "\\F:\\Selenium_2023\\geckodriver.exe");
	//	WebDriver driver = new FirefoxDriver();
		
		driver.get("https://facebook.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
   //	System.out.println(driver.getPageSource()); 	//Identify the method that gives the source of the last page loaded.
		
		
		driver.close();
		driver.quit();
	}

}
