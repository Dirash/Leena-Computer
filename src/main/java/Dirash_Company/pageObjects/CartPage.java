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
	
	
	@FindBy(css=".col-lg-4")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy = By.cssSelector(".col-lg-4");
	By AddToCart = By.cssSelector(".col-lg-4 button:last-child");
	By toastMessage = By.cssSelector(".toast-message");
	
	public List<WebElement> getProductlist()
	{
		
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String product_Name)
	{
		WebElement prod =getProductlist().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(product_Name)).findFirst().orElse(null);
		return prod;
	}
	

	public void addProductToCart(String product_Name)
	{
		WebElement prod = getProductByName(product_Name);
		prod.findElement(AddToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDissapear(spinner);	
	}
}
