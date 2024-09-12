package com.S15;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Relative_Locators {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rah	ulshettyacademy.com/angularpractice/");
		
		//above
		WebElement aboveElement = driver.findElement(By.cssSelector("input[name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(aboveElement)).getText());
		
		//below
		WebElement belowElement = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(belowElement)).click();
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
		
		//left
		WebElement leftElement = driver.findElement(By.xpath("//label[@class='form-check-label']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(leftElement)).click();

		//right
		WebElement rightElement = driver.findElement(By.cssSelector("label[for='inlineRadio1']"));
		driver.findElement(with(By.tagName("input")).toRightOf(rightElement)).click();
	}

}
