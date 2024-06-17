package com.guru99V1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage
{
	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[.='New Customer']")
    WebElement newCustomer;
	@FindBy(xpath="//input[@name='name']")
    WebElement customerName;
	@FindBy(xpath="(//input[@name='rad1'])[1]")
    WebElement maleRdBtn;
	@FindBy(xpath="(//input[@name='rad1'])[2]")
    WebElement femaleRdBtn;
	@FindBy(xpath="//input[@name='dob']")
    WebElement dob;
	@FindBy(xpath="//textarea[@name='addr']")
    WebElement address;
	@FindBy(xpath="//input[@name='city']")
    WebElement city;
	@FindBy(xpath="//input[@name='state']")
    WebElement state;
	@FindBy(xpath="//input[@name='pinno']")
    WebElement pin;
	@FindBy(xpath="//input[@name='telephoneno']")
    WebElement mobileNumber;
	@FindBy(xpath="//input[@name='emailid']")
    WebElement emailId;
	@FindBy(xpath="//input[@name='password']")
    WebElement password;
	@FindBy(xpath="//input[@name='sub']")
    WebElement submitBtn;
	@FindBy(xpath="//div[@id='dismiss-button']")
    WebElement adClose;
	
	public void clickNewCustomer() 
	{
		newCustomer.click();
	}
	public void setCustomerName(String cName) 
	{
		customerName.sendKeys(cName);
	}
	public void clickMaleRdBtn() 
	{
		if(!maleRdBtn.isSelected())
		{
			maleRdBtn.click();
		}
	}
	public void setDob(String dd, String mm, String yyyy) 
	{
		dob.sendKeys(dd);
		dob.sendKeys(mm);
		dob.sendKeys(yyyy);
	}
	public void setAddress(String add)
	{
		address.sendKeys(add);
	}
	public void setCity(String cityName)
	{
		city.sendKeys(cityName);
	}
	public void setState(String stateName)
	{
		state.sendKeys(stateName);
	}
	public void setPin(String pincode) 
	{
		pin.sendKeys(pincode);
	}
	public void setMobileNo(String mNo)
	{
		mobileNumber.sendKeys(mNo);
	}
	public void setEmail(String eMailId) 
	{
		emailId.sendKeys(eMailId);
	}
	public void setPassword(String pass) 
	{
		password.sendKeys(pass);
	}
	public void clickSubmitBtn()
	{
		submitBtn.click();
	}
	public void closeAD()
	{
		adClose.click();
	}
}
