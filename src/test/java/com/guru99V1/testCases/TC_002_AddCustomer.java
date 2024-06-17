package com.guru99V1.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99V1.pageObjects.AddCustomerPage;
import com.guru99V1.pageObjects.LoginPage;

public class TC_002_AddCustomer extends BaseClass
{
	@Test
	public void addNewCust() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		
		lp.setUid(username);
		logger.info("username entered");
		lp.setPwd(password);
		logger.info("password entered");
		lp.clickLogin();
		
		Thread.sleep(3000);
		
		AddCustomerPage acp=new AddCustomerPage(driver);
		
		acp.clickNewCustomer();
		Thread.sleep(2000);
		acp.closeAD();
		acp.setCustomerName("suresh");
		acp.clickMaleRdBtn();
		acp.setDob("12", "12", "1995");
		Thread.sleep(2000);
		acp.setAddress("tb palem kodad suryapet");
		acp.setCity("kodad");
		acp.setState("tg");
		acp.setPin("258963");
		acp.setMobileNo("9874563210");
		acp.setEmail(stringRandom()+"@gmail.com");
		Thread.sleep(2000);
		acp.setPassword("suresh@123");
		acp.clickSubmitBtn();
		
		if(driver.getPageSource().contains("Customer Registered Successfully!!!"))
		{
			Assert.assertTrue(true);
			logger.info("test case is passed");
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver, "AddCustomer");
			Assert.assertTrue(false);
		}
	}
	
	
}
