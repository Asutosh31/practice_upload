package asutoshacademy.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import asutoshacademy.TestComponents.BaseTest;
import asutoshacademy.pageobjects.CartPage;
import asutoshacademy.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest{

	@Test(groups= {"ErrorHandling"})//,retryAnalyzer=Retry.class)
	public void loginErrorValidation()
	{
		landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
		Assert.assertEquals("Incorrect email password.", landingPage.getErrorMessage());
	}

	@Test
	public void submitOrder() throws IOException, InterruptedException
	{   
	
		String productName = "ADIDAS ORIGINAL";
		ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyproductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
	}

}
