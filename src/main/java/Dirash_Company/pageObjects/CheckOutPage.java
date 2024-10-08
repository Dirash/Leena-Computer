package Dirash_Company.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Dirash_Company.AbsractReusableComponent.AbstractComponent;

public class CheckOutPage extends AbstractComponent{
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		//Initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement SelectCountry;
	
	By results = By.cssSelector(".ta-results");

   
    public void selectCountry(String countryName)
    {
    	Actions act = new Actions(driver);
    	act.sendKeys(country,countryName).build().perform();
    	waitForElementToAppear(results);
    	SelectCountry.click(); 	
    	
    }
    
    public ConfirmationPage submitOrder()
    {
    	submit.click();
    	return new ConfirmationPage(driver);
    }

}
