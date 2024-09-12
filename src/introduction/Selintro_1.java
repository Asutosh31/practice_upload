package introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Selintro_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String name = "Asu";
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_2023\\introduction\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("ademy");
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		System.out.println(driver.findElement(By.tagName("h2")).getText());
		
		Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"App\"]/div/div/h2")).getText(), "Hello "+name+",");
		driver.findElement(By.xpath("//button[text()=\"Log Out\"]")).click();
		driver.close();
	}
	

}
