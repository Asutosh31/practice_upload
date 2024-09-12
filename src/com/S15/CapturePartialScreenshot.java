package com.S15;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import javax.swing.plaf.FileChooserUI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class CapturePartialScreenshot {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://flipkart.com");
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> handle = driver.getWindowHandles();
		Iterator<String> it = handle.iterator();
		String ParentTab = it.next();
		String ChildTab = it.next();
		driver.switchTo().window(ChildTab);
		driver.get("https://rahulshettyacademy.com");
		
		driver.findElement(By.linkText("Courses")).click();
		WebElement name = driver.findElement(By.cssSelector("input[name='query']"));
		name.sendKeys("Jay Jagannath");
		
		//take the screenshot
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("scrnshot.png"));
		
		//Get height and width
		System.out.println(name.getRect().getHeight());
		System.out.println(name.getRect().getWidth());
		
		driver.quit();
		
	}

}
