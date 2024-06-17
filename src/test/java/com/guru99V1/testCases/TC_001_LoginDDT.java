package com.guru99V1.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99V1.pageObjects.LoginPage;
import com.guru99V1.utilities.XL_Util;

public class TC_001_LoginDDT extends BaseClass
{
	@Test(dataProvider="dp")
	public void loginDDT(String Use, String pas)
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUid(Use);
		logger.info("username is provides");
		lp.setPwd(pas);
		logger.info("password is provides");
		lp.clickLogin();
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("login passed");
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean isAlertPresent()
	{
		try 
		{
			driver.switchTo().alert();
			return true;
		} catch (Exception e)
		{
			return false;
		}
		
	}
	
	@DataProvider(name="dp")
	public Object[][] dp() throws IOException
	{
		String path="src\\test\\java\\com\\guru99V1\\testData\\LoginData.xlsx";
		int r=XL_Util.getRowCount(path, "Sheet1");
		int c=XL_Util.getCellCount(path, "Sheet1", r);
		Object[][] data=new Object[r][c];
		for (int i = 1; i <= r; i++)
		{
			for (int j = 0; j < c; j++) 
			{
				data[i-1][j]=XL_Util.getCellData(path, "Sheet1", i, j);
			}
		}
		return data;
	}
	
}
