package asutoshacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import asutoshacademy.AbstractsComponents.AbstractsComponent;

public class CheckoutPage extends AbstractsComponent{
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = ".btnn.action__submit")
	private WebElement submit;
	
	@FindBy(xpath = "(//input[@class='input txt text-validated'])[2]")
	private WebElement country;
	
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	private WebElement selectCountry;
	
	private By reults = By.cssSelector(".ta-results");
	
	public void selectCountry(String countryname){
		Actions a = new Actions(driver);
		a.sendKeys(country, countryname).build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "driver");
		selectCountry.click();
	}
	
	public void waitForElementToAppear(By cssSelector) {
		// TODO Auto-generated method stub
		
	}

	public ConfirmationPage submitOrder() {
		
		submit.click();
		return new ConfirmationPage(driver);
		
	}

}
