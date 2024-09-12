package asutoshacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import asutoshacademy.AbstractsComponents.AbstractsComponent;
	
public class OrderPage extends AbstractsComponent{
	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".totalRow.button")
	WebElement checkoutEle;
	
	@FindBy(css = "tr td:nth-child(3)")
	private List<WebElement> productNames;
	
	public Boolean VerifyOrderDisplay(Object productName) {
		Boolean match = productNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase((String) productName));
		return match;
	}
	public CheckoutPage  gotoCheckout() {
		checkoutEle.click();
		return new CheckoutPage(driver);
	
	}
	

}
