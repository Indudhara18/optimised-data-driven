package com.OptimaisedDataDrivenActiTime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrackPage 
{
	// Declare the WebElements present in EnterTimerTrackPage
	
	@FindBy(xpath="(//div[contains(text(),'Settings')])[1]")
	private WebElement settings ;
	
	@FindBy(xpath="(//a[contains(text(),'Licenses')])")
	private WebElement license ;
	
	@FindBy( xpath="//div[contains(text(),'TASKS')]" )
	private WebElement tasks ;
	
	// initialise the WebElements which were declared 
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// utilisation of WebElements 
	
	public void clickSettings()
	{
		settings.click();
	}
	
	public void clickLicense()
	{
		license.click();
	}
	
	public void clickTasks()
	{
		tasks.click();
	}
}
