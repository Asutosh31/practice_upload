package asutoshacademy.stepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import asutoshacademy.TestComponents.BaseTest;
import asutoshacademy.pageobjects.CartPage;
import asutoshacademy.pageobjects.CheckoutPage;
import asutoshacademy.pageobjects.ConfirmationPage;
import asutoshacademy.pageobjects.LandingPage;
import asutoshacademy.pageobjects.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationimplemetation extends BaseTest {

	public LandingPage landingpage;
	public ProductCatalogue productCatalogue;
	ConfirmationPage confirmationPage;
	@Given("I landed on the EcommercePage")
	public void I_landed_on_the_EcommercePage() throws IOException
	{
		launchApplication();
	}
	
	@Given ("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password)
	{
		 productCatalogue = landingPage.loginApplication(username, password);
	}
	
	@When("^I add product (.+) to Cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException 
	{
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}
	
	@When("^Checkout (.+) and submit the order$")
	public void checkout_submit_order(String productname)
	{
		CartPage cartPage = productCatalogue.goToCartPage();	
		
		Boolean match = cartPage.VerifyproductDisplay(productname);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.gotoCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
	}
	
	//Then "THANKYOU FOR THE ORDER." message displayed on the confirmationPage
	@Then("{string} message is displayed on ConfirmationPage")
	public void message_displayed_confirmationPage(String string)
	{
		String confirmMessage = confirmationPage.getCofirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}
	
	@Then("^\"([^\"]*)\" message is displayed$")
		public void something_message_is_displayed(String strArg1)throws Throwable{
		Assert.assertEquals(strArg1, landingPage.getErrorMessage());
		driver.close();
	}
}