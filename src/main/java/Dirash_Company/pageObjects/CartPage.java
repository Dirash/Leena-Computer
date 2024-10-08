package Dirash_Company.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import Dirash_Company.AbsractReusableComponent.AbstractComponent;

public class CartPage extends AbstractComponent{
	WebDriver driver; 
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		//Initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
		
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	
	public Boolean veriftProductDisplay(String product_Name)
	{
		Boolean match =cartProducts.stream().anyMatch(product->product.getText().equals(product_Name));
		return match;
	}
	
	public CheckOutPage checkOut()
	{
		checkout.click();	
		return new CheckOutPage(driver);
		
	}


}
