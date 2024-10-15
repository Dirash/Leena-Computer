package Dirash_Company.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Dirash_Company.AbsractReusableComponent.AbstractComponent;

public class OrderPage extends AbstractComponent{
	
WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		//Initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="td:nth-child(3)")
	List<WebElement> productNames;
	
	
	public Boolean verifyOrderDisplay(String product_Name)
	{
		Boolean match =productNames.stream().anyMatch(product->product.getText().equals(product_Name));
		return match;
	}

}
