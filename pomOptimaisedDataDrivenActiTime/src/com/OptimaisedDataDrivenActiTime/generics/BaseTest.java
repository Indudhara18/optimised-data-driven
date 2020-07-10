package com.OptimaisedDataDrivenActiTime.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class is Precondion and PostCondition for project
 * @author Indudhara
 *
 */
abstract public class BaseTest implements IAutoConstants
{
	static
	{
		System.setProperty(CHROME_KEY , CHROME_VALUE);
		System.setProperty(GECKO_KEY , GECKO_VALUE);
	}
	
	public static WebDriver driver ;
	
	public static void openApplication(String setBrowser)
	{
		// open the browser
		if ( setBrowser.equals("chrome") ) 
		{
			driver = new ChromeDriver();
		}
		else
		{
			driver = new FirefoxDriver();
		}
		
		// set browser timeouts
		driver.manage().timeouts().implicitlyWait(ITO , TimeUnit.SECONDS);
		// maximise the window
		driver.manage().window().maximize();
		// enter the url
		driver.get( URL );
	}
	
	public static void closeApplication()
	{
		// close the browser
		driver.close();
	}
}
