package com.OptimaisedDataDrivenActiTime.scripts;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.OptimaisedDataDrivenActiTime.generics.FWUtilis;
import com.OptimaisedDataDrivenActiTime.pages.EnterTimeTrackPage;
import com.OptimaisedDataDrivenActiTime.pages.LicensePage;
import com.OptimaisedDataDrivenActiTime.pages.LoginPage;


public class TestIssueDate extends FWUtilis
{

	public static void main(String[] args) throws InterruptedException, IOException 
	{

		String un = read_XL_Data(PATH, "CheckIssueDate", 1, 0);
		String pw = read_XL_Data(PATH, "CheckIssueDate", 1, 1);
		String expectedETPtitle = read_XL_Data(PATH, "CheckIssueDate", 1 , 2);
		String expectedLCPtitle = read_XL_Data(PATH, "CheckIssueDate", 1 , 3);
		String expectedIssueDate = read_XL_Data(PATH, "CheckIssueDate", 1 , 4);
		
		openApplication("chrome");
		
		verifyPage(driver, LPTITLE);
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername( un );
		lp.setPassword( pw );
		lp.clickLoginButton();
		Thread.sleep(1000);
		
		verifyPage(driver, expectedETPtitle);
		
		EnterTimeTrackPage etp = new EnterTimeTrackPage(driver);
		etp.clickSettings();
		etp.clickLicense();
		Thread.sleep(1000);
		
		verifyPage(driver, expectedLCPtitle);
		
		LicensePage lip = new LicensePage(driver);
		lip.getIssueDate();
		lip.verifyIssueDate(driver, expectedIssueDate);
		
		closeApplication();
	}
	
}
