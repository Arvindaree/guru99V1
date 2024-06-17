package com.guru99V1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagersPage
{
	     WebDriver driver;
	     
	     public ManagersPage(WebDriver driver) 
	    {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	     
	    //elements
	    @FindBy(xpath="//a[.='Manager']")
	    WebElement manager;
	    @FindBy(xpath="//a[.='New Customer']")
	    WebElement newCustomer;
	    @FindBy(xpath="//a[.='Edit Customer']")
	    WebElement editCustomer;
	    @FindBy(xpath="//a[.='Delete Customer']")
	    WebElement deleteCustomer;
	    @FindBy(xpath="//a[.='New Account']")
	    WebElement newAccount;
	    @FindBy(xpath="//a[.='Edit Account']")
	    WebElement editAccount;
	    @FindBy(xpath="//a[.='Delete Account']")
	    WebElement deleteAccount;
	    @FindBy(xpath="//a[.='Deposit']")
	    WebElement deposit;
	    @FindBy(xpath="//a[.='Withdrawal']")
	    WebElement withdrawal;
	    @FindBy(xpath="//a[.='Fund Transfer']")
	    WebElement fundTransfer;
	    @FindBy(xpath="//a[.='Change Password']")
	    WebElement changePassword;
	    @FindBy(xpath="//a[.='Balance Enquiry']")
	    WebElement balanceEnquiry;
	    @FindBy(xpath="//a[.='Mini Statement']")
	    WebElement miniStatement;
	    @FindBy(xpath="//a[.='Customised Statement']")
	    WebElement customisedStatement;
	    @FindBy(xpath="//a[.='Log out']")
	    WebElement logout;
	    
	    
	     
}
