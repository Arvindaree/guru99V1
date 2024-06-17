package com.guru99V1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//elements
	@FindBy(xpath ="//input[@name='uid']")
	WebElement uid;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement pass;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement loginBtn;
	
	@FindBy(xpath="//input[@name='btnReset']")
	WebElement resetBtn;
	
	@FindBy(xpath="//a[.='Log out']")
    WebElement logout;
	
	//action methods
	public void setUid(String uName)
	{
		uid.sendKeys(uName);
	}
	
	public void setPwd(String pwd)
	{
		pass.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		loginBtn.click();
	}
	
	public void clickReset()
	{
		resetBtn.click();
	}
	
	public void clickLogout()
	{
		logout.click();
	}
	
}
