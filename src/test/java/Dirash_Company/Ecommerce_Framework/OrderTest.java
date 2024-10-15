package Dirash_Company.Ecommerce_Framework;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Dirash_Company.TestComponents.BaseTest;
import Dirash_Company.pageObjects.CartPage;
import Dirash_Company.pageObjects.CheckOutPage;
import Dirash_Company.pageObjects.ConfirmationPage;
import Dirash_Company.pageObjects.OrderPage;
import Dirash_Company.pageObjects.ProductCatalogue;

public class OrderTest extends BaseTest {

	String product_Name = "ADIDAS ORIGINAL";
	@Test(dataProvider = "getData",groups = "purchaseOrder")
	public void submitOrder(String email,String password, String product_Name) throws IOException
	{
		// TODO Auto-generated method stub
		        
        ProductCatalogue ProductCatalogueobj = LandingPageObj.loginApplication(email, password);
		List<WebElement> products = ProductCatalogueobj.getProductlist();
		ProductCatalogueobj.addProductToCart(product_Name);
		CartPage CartPageobj = ProductCatalogueobj.goToCartPage();
		Boolean match =CartPageobj.veriftProductDisplay(product_Name);
		Assert.assertTrue(match);
		CheckOutPage CheckOutPageobj = CartPageobj.checkOut();
		CheckOutPageobj.selectCountry("india");
		ConfirmationPage ConfirmationPageobj = CheckOutPageobj.submitOrder();
		String confirmMessage = ConfirmationPageobj.getConfirmMessage();
	    Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	   
	}
	
	@Test(dependsOnMethods = {"submitOrder"} )
	public void orderHistoryTest()
	{
		 
	     ProductCatalogue ProductCatalogueobj = LandingPageObj.loginApplication("dirash@leena.ai", "Dirash@10");
	     OrderPage OrderPageObj = ProductCatalogueobj.goToOrderPage();
	     Assert.assertTrue(OrderPageObj.verifyOrderDisplay(product_Name));
	}
	
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"dirash@leena.ai", "Dirash@10","ADIDAS ORIGINAL"},{"dirash+2@leena.ai", "Dirash@10","ZARA COAT 3"}};
		
	
	}

}
