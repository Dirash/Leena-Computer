package Dirash_Company.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Dirash_Company.AbsractReusableComponent.AbstractComponent;
import net.bytebuddy.implementation.bind.annotation.Super;

public class LandingPage extends AbstractComponent{
	WebDriver driver; 
	
	public LandingPage(WebDriver driver)
	{
		//Initialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement Submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductCatalogue loginApplication(String email, String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		Submit.click();
		ProductCatalogue ProductCatalogueobj = new ProductCatalogue(driver);
		return ProductCatalogueobj;
		
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String errorMessage()
	{
		waitForElementToAppear(errorMessage);
		return errorMessage.getText();
	}

}
