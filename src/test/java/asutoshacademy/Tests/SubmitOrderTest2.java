package asutoshacademy.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import asutoshacademy.TestComponents.BaseTest;
import asutoshacademy.pageobjects.CartPage;
import asutoshacademy.pageobjects.CheckoutPage;
import asutoshacademy.pageobjects.ConfirmationPage;
import asutoshacademy.pageobjects.OrderPage;
import asutoshacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest2 extends BaseTest{

	@Test
	public void submitOrder() throws IOException, InterruptedException
	{   
	
		String productName = "ADIDAS ORIGINAL";
		ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
		
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyproductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.gotoCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();		
		String confirmMessage = confirmationPage.getCofirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
	}
	@Test(dependsOnMethods= {"submitOrder"})
	public void ordersHistoryTest(Object productName)
	{
		ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
		OrderPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
	}
		
	

}
