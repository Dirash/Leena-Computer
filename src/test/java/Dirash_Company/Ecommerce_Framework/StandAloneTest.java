package Dirash_Company.Ecommerce_Framework;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Dirash_Company.TestComponents.BaseTest;
import Dirash_Company.pageObjects.CartPage;
import Dirash_Company.pageObjects.CheckOutPage;
import Dirash_Company.pageObjects.ConfirmationPage;
import Dirash_Company.pageObjects.ProductCatalogue;

public class StandAloneTest extends BaseTest {

	@Test
	public void submitOrder() throws IOException
	{
		// TODO Auto-generated method stub
		
        String product_Name = "ADIDAS ORIGINAL";
        ProductCatalogue ProductCatalogueobj = LandingPageObj.loginApplication("dirash@leena.ai", "Dirash@10");
   
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

}
