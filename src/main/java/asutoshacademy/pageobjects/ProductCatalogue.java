package asutoshacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import asutoshacademy.AbstractsComponents.AbstractsComponent;


public class ProductCatalogue extends AbstractsComponent {
	
	WebDriver driver;
	
	
	//Before you touch/action on anything in this class, this method is the 1st thing to use
	public ProductCatalogue(WebDriver driver)
	{
		//initialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//PageFactory
	//Remember: PageFactory exclusively used for driver.findByElement constructor
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = (By.cssSelector(".card-body button:last-of-type"));
	By toastMessage = By.cssSelector("#toast-container");
	
	//lets start with the action methods
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public void waitForElementToAppear(By products) {
		// TODO Auto-generated method stub
		
	}

	public WebElement getProductByName(String productName)
	{
		WebElement prod =	getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	
	public void addProductToCart(String products2) throws InterruptedException
	{
		WebElement prod = getProductByName(products2);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);


	}



}
