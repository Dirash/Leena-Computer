package Dirash_Company.Ecommerce_Framework;

import java.io.IOException;
import java.util.HashMap;
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

public class StandAloneTest extends BaseTest {

	String product_Name = "ADIDAS ORIGINAL";
	@Test(dataProvider = "getData",groups = "purchaseOrder")
	public void submitOrder(HashMap<String ,String> input) throws IOException
	{
		// TODO Auto-generated method stub
		        
        ProductCatalogue ProductCatalogueobj = LandingPageObj.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = ProductCatalogueobj.getProductlist();
		ProductCatalogueobj.addProductToCart(input.get(product_Name));
		CartPage CartPageobj = ProductCatalogueobj.goToCartPage();
		Boolean match =CartPageobj.veriftProductDisplay(input.get(product_Name));
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
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data = getJSONDatatoMap(System.getProperty("user.dir") + "\\src\\test\\java\\Dirash_Company\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
			
	}

}
