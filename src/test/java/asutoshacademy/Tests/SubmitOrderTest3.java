package asutoshacademy.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import asutoshacademy.TestComponents.BaseTest;
import asutoshacademy.pageobjects.CartPage;
import asutoshacademy.pageobjects.CheckoutPage;
import asutoshacademy.pageobjects.ConfirmationPage;
import asutoshacademy.pageobjects.OrderPage;
import asutoshacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest3 extends BaseTest{
	String productName = "ADIDAS ORIGINAL";
	
	@Test(dataProvider="getData",groups={"Purchase"})
	public void submitOrder(String email, String password, String productName) throws IOException, InterruptedException
	{   
	
		
		ProductCatalogue productCatalogue = landingPage.loginApplication(email, password);
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
	
	@DataProvider
	public Object [][] getData()
	{
		return new Object[][] {{"anshika@gmail.com","Iamking@000","ADIDAS ORIGINAL"}, {"shetty@gmail.com","Iamking@000","ZARA COAT 3"}};
	}
	

}
