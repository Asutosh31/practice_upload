package asutoshacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import asutoshacademy.AbstractsComponents.AbstractsComponent;

public class LandingPage extends AbstractsComponent{
	
	WebDriver driver;
	
	//Before you touch/action on anything in this class, this method is the 1st thing to use
	public LandingPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement useremail = driver.findElement(By.id("userEmail"));
	
	//PageFactory
	@FindBy(id="userEmail")
	WebElement uemail;
	
	@FindBy(id="userPassword")
	WebElement upassword;
	
	@FindBy(id="login")
	WebElement ulogin;
	
	@FindBy(css="[class*='toast-message']")
	WebElement errorMessage;
	
	//now we can use action method to simplify the code
	public ProductCatalogue loginApplication(String string, String string2)
	{
		uemail.sendKeys(string);	
		upassword.sendKeys(string2);
		ulogin.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	//instead of using the driver.get() in test class, use below method
 	public void goTo()
	{
		driver.get("http://rahulshettyacademy.com/client");
	}
}
