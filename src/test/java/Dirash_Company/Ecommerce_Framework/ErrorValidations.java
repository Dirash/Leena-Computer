package Dirash_Company.Ecommerce_Framework;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Dirash_Company.TestComponents.BaseTest;
import Dirash_Company.pageObjects.ProductCatalogue;

public class ErrorValidations extends BaseTest {

	@Test(groups = "errorHandling")
	public void submitOrder() throws IOException
	{
		// TODO Auto-generated method stub
		
        String product_Name = "ADIDAS ORIGINAL";
        ProductCatalogue ProductCatalogueobj = LandingPageObj.loginApplication("dirash@leena.ai", "Dish@10");
        Assert.assertEquals("Incorrect email or password.", LandingPageObj.errorMessage());  
        
	}

}
