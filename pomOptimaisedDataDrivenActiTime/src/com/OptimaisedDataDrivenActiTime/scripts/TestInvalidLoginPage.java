package com.OptimaisedDataDrivenActiTime.scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.OptimaisedDataDrivenActiTime.generics.FWUtilis;
import com.OptimaisedDataDrivenActiTime.pages.LoginPage;

public class TestInvalidLoginPage extends FWUtilis
{

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException 
	{
		openApplication("chrome");
		verifyPage(driver, LPTITLE);
		
		int rowcount = XL_rowCount(PATH, INVALIDLOGINSHEET);	
		
		for (int i = 1; i <=rowcount ; i++) 
		{
			String un = read_XL_Data(PATH, INVALIDLOGINSHEET, i, 0);
			String pw = read_XL_Data(PATH, INVALIDLOGINSHEET, i, 1);
			
			LoginPage lp = new LoginPage(driver);
			lp.setUsername(un);
			lp.setPassword(pw);
			Thread.sleep(1000);
			lp.clickLoginButton();
			Thread.sleep(1000);
			lp.checkErrorMessage();
			takeScreenshot(driver, "./photo/1.png");
			Thread.sleep(1000);
		}
		
			
		closeApplication();
		
	}
	
	
}
