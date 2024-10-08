package Dirash_Company.Ecommerce_Framework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Dirash_Company.pageObjects.CartPage;
import Dirash_Company.pageObjects.LandingPage;
import Dirash_Company.pageObjects.ProductCatalogue;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String product_Name = "ADIDAS ORIGINAL";
		driver.manage().window().maximize();
		LandingPage LandingPageObj = new LandingPage(driver);
		LandingPageObj.goTo();
		ProductCatalogue ProductCatalogueobj = LandingPageObj.loginApplication("dirash@leena.ai", "Dirash@10");
		
		List<WebElement> products = ProductCatalogueobj.getProductlist();
		ProductCatalogueobj.addProductToCart(product_Name);
		CartPage CartPageobj = ProductCatalogueobj.goToCartPage();
		
		Boolean match =CartPageobj.veriftProductDisplay(product_Name);
		Assert.assertTrue(match);
		CartPageobj.checkOut();
		
		
			
		
//		Actions act = new Actions(driver);
//		act.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")),"india").build().perform();
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	    
	    driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	    driver.findElement(By.cssSelector(".action__submit")).click();
	    
	    String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	    Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	    driver.quit();

	}

}
