package com.guru99V1.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.guru99V1.utilities.ReadConfig;

public class BaseClass
{
	ReadConfig rc=new ReadConfig();
	public String baseURL=rc.getApplicationUrl();
	public String username=rc.getUsername();
	public String password=rc.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	public static ChromeOptions options;
	
	@Parameters("brow")
	@BeforeClass
	public void setup(String browser)
	{	
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", rc.getChromePath());
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette", rc.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		else
			System.out.println("browser name is mismatched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		logger=Logger.getLogger("guru99");
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tName) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("Screenshots//"+tName+".png"));
		System.out.println("screenshot taken");
	}
	
	//creating random string
		public String stringRandom() 
		{
			return RandomStringUtils.randomAlphabetic(5);
		}
		public String numberRandom() 
		{
			return RandomStringUtils.randomNumeric(10);
		}
}
