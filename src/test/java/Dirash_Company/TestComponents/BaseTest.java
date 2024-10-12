package Dirash_Company.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Dirash_Company.pageObjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage LandingPageObj;
	public WebDriver initializer() throws IOException
	{
	Properties prop = new Properties();
	FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resource/Globaldata.properties");
	prop.load(fis);
	String browserName = prop.getProperty("browser");
	
	if(browserName.equalsIgnoreCase("chrome"))
	{
	 driver = new ChromeDriver();
	
	}
	else if(browserName.equalsIgnoreCase("firefox"))
	{
		//fireFix
	}
	else if(browserName.equalsIgnoreCase("edge"))
	{
		//Edge
	}
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	return driver;
	
	}
	
	@BeforeMethod
	public LandingPage LaunchApplication() throws IOException
	{
		driver = initializer();
	    LandingPageObj = new LandingPage(driver);
		LandingPageObj.goTo();
		return LandingPageObj;
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		 driver.quit();
	}

}
