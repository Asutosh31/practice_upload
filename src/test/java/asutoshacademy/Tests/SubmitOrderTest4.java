package asutoshacademy.Tests;

import java.io.IOException;
import java.util.HashMap;
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

public class SubmitOrderTest4 extends BaseTest{
	String productName = "ADIDAS ORIGINAL";
	
	@Test(dataProvider="getData",groups={"Purchase"})
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException
	{   
	
		
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();	
			
		Boolean match = cartPage.VerifyproductDisplay(input.get("product"));
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
		List<HashMap<String, String>>data=getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//asutoshacademy//data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
		
	}
//	HashMap<String, String> map = new HashMap<String,String>();
//	map.put("email", "anshika@gmail.com");
//	map.put("password", "Iamking@000");
//	map.put("product", "ADIDAS ORIGINAL");
//	
//	HashMap<String, String> map1 = new HashMap<String,String>();
//	map1.put("email", "shetty@gmail.com");
//	map1.put("password", "Iamking@000");
//	map1.put("product", "ZARA COAT 3");
	public List<HashMap<String, String>> getJsonDataToMap(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
