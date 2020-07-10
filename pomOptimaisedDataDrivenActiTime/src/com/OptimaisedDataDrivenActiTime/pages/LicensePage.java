package com.OptimaisedDataDrivenActiTime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LicensePage 
{
	// declare the WebElements of License page
	
	@FindBy(xpath="//nobr[contains(text(),'Product Edition:')]/../../td[2]")
	private WebElement productEdition ;
	
	@FindBy( xpath="//nobr[contains(text(),'Issue Date:')]/../../td[2]" )
	private WebElement issueDate ;
	
	// initialise the dclared WebElements
	
	public LicensePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// utilisation of WebElements by creating setter methods
	
	public void getProductEdition()
	{
		String s = productEdition.getText() ;
		System.out.println("Product Edition is : " + s);
	}
	
	public void getIssueDate()
	{
		String s = issueDate.getText() ;
		System.out.println("Issue Date is : " + s);
	}
	
	public void verifyIssueDate(WebDriver driver , String expectedIssuedate )
	{
		String actualIssueDate = issueDate.getText();
		if ( actualIssueDate.equals(expectedIssuedate) ) 
		{
			System.out.println("Issue date is verified and test case is passed");
		}
		else
		{
			System.out.println("Issue date verified and not matchs as expected,  test case failed");
		}
	}
	
	
	public void verifyProductEdition(WebDriver driver , String expectedProductEdition )
	{
		String actualProductEdition = productEdition.getText() ;
		if ( actualProductEdition.equals(expectedProductEdition) ) 
		{
			System.out.println("Product Edition is verified and test case is passed");
		}
		else
		{
			System.out.println("Product Edition verified and not matchs as expected,  test case failed");
		}
	}
	
}
