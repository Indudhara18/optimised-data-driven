package com.OptimaisedDataDrivenActiTime.generics;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is used to For FrameWork
 * @author Indudhara
 *
 */

public class FWUtilis extends BaseTest
{

	/**
	 * This method is used to get title from the current web page and to verify the title of page 
	 * @param driver
	 * @param expTitle
	 */
	public static void verifyPage( WebDriver driver , String expTitle )
	{
		String expectedTitle = expTitle ;
		String actualTitle = driver.getTitle() ;
		
		if ( actualTitle.equals( expectedTitle ) ) 
		{
			System.out.println("Expected page is displayed-->" + expectedTitle);
		}
		else
		{
			System.out.println("Expected page not displayed-->" + actualTitle);
		}		
	}
	
	/**
	 * This method is used to take Screenshot
	 * @param driver
	 * @param path
	 */
	public static void takeScreenshot(WebDriver driver, String path) 
	{
		try
		{
		  TakesScreenshot ts = (TakesScreenshot) driver ;
		  File src = ts.getScreenshotAs(OutputType.FILE);
		  File des = new File(path);
		  FileUtils.copyFile(src, des);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This method is used to read data from Excel
	 * @param path
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 */
	public static String read_XL_Data(String path, String sheet, int row, int cell)
	{
		String data = "" ;
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			data = wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
	 	}
		return data ;
	}
	
	/**
	 * This method is used to count the number of rows which having data in it
	 * @param path
	 * @param sheet
	 * @return
	 */
	public static int XL_rowCount(String path , String sheet)
	{
		int rowcount = 0 ;
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			rowcount = wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rowcount;
	}
	
	
	
	/**
	 * This method is used to create explicitlyWait object 
	 * @return
	 */
	public static WebDriverWait explicitlyWait()
	{
		WebDriverWait wait = new WebDriverWait(driver , ETO);
		return wait ;	
	}
	
	
	/**
	 * This method is used to create Select class object and perform actions on single select and multi select
	 * @param sel
	 * @param element
	 * @return
	 */
	public static Select lists( WebElement element)
	{
		Select sel = new Select(element);
		return sel ;
	}
	
	
	/**
	 * This method is used to handle the Alert popup
	 * @param driver
	 */
	public static void handlePopUp(WebDriver driver)
	{
		Alert al = driver.switchTo().alert();
		al.accept();
	}
	
	
	/**
	 * This method is to handle Noticefication Popup
	 */
	public static void handleNotificationPopup()
	{
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--disable-notifications");
	}
	
	
	/**
	 * This method is used to download a file
	 * @param driver
	 * @param element
	 * @param xpathxpression
	 */
	public static void downloadAFile(WebDriver driver , WebElement element,  String xpathxpression)
	{
		element = driver.findElement(By.xpath(xpathxpression));
		element.click();
		try
		{
			Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyPress(KeyEvent.VK_ENTER);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}
