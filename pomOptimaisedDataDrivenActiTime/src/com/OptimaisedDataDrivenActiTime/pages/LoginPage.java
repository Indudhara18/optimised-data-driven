package com.OptimaisedDataDrivenActiTime.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	// declare the WebElements present in LoginPage 
	
	@FindBy(name="username")
	private WebElement unTB ;
	
	@FindBy(name="pwd")
	private WebElement pwTB ;
	
	@FindBy(id="loginButton")
	private WebElement lgnBTN ;
	
	@FindBy(xpath="//span[contains(text(),'invalid.')]")
	private WebElement errMSG ;
	
	// initialise the declared WebElements 
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// utilisation of WebElements
	
	/**
	 * This method is used to set User Name
	 * @param un
	 */
	public void setUsername(String un)
	{
		unTB.sendKeys(un);
	}
	
	/**
	 * This method is used to clear UserName
	 */
	public void clearUserName()
	{
		unTB.clear();
	}
	
	/**
	 * This method is used to set password
	 * @param pw
	 */
	public void setPassword(String pw)
	{
		pwTB.sendKeys(pw);
	}
	
	/**
	 * This method is used to click Login Button
	 */
	public void clickLoginButton()
	{
		lgnBTN.click();
	}
	
	/**
	 * This method is used to check Error Message
	 */
	public void checkErrorMessage()
	{
		if( errMSG.isDisplayed() )
		{
			System.out.println("Error Message displayed :"+ errMSG.getText());
		}	
		
		else
		{
			System.out.println("Error Message not displayed ");
		}		
	}
	 /**
	  * This method is used to handle Alert PopUp
	  * @param driver
	  */
	public void manageAlertPopup(WebDriver driver)
	{
		Alert al = driver.switchTo().alert();
		al.accept();
	}
}
