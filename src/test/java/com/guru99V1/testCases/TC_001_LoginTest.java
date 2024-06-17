package com.guru99V1.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99V1.pageObjects.LoginPage;

public class TC_001_LoginTest extends BaseClass
{
	@Test
	public void loginTest() throws IOException
	{
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setUid(username);
		logger.info("username entered");
		lp.setPwd(password);
		logger.info("password entered");
		lp.clickLogin();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("login test passed");
		}
		else
		{
			captureScreen(driver, "loginTest");
			logger.info("login test failed");
			Assert.assertTrue(false);
		}
		
	}
	
}
