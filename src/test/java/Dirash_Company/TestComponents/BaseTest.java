package Dirash_Company.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	public List<HashMap<String, String>> getJsonData(String file) throws IOException
	{
		// read json to string
		String jsonVariable = FileUtils.readFileToString(
				new File(file),
				StandardCharsets.UTF_8);
		// String to hasmap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonVariable,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}
	
	@BeforeMethod(alwaysRun = true)
	public LandingPage LaunchApplication() throws IOException
	{
		driver = initializer();
	    LandingPageObj = new LandingPage(driver);
		LandingPageObj.goTo();
		return LandingPageObj;
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser()
	{
		 driver.quit();
	}
	
	

}
