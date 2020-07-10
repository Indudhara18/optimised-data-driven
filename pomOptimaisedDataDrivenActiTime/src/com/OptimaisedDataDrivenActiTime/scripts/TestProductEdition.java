package com.OptimaisedDataDrivenActiTime.scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.OptimaisedDataDrivenActiTime.generics.FWUtilis;
import com.OptimaisedDataDrivenActiTime.pages.EnterTimeTrackPage;
import com.OptimaisedDataDrivenActiTime.pages.LicensePage;
import com.OptimaisedDataDrivenActiTime.pages.LoginPage;

public class TestProductEdition extends FWUtilis
{

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException 
	{
		
		String un = read_XL_Data(PATH, "CheckProductEdition", 1, 0);
		String pw = read_XL_Data(PATH, "CheckProductEdition", 1, 1);
		String expectedETPtitle = read_XL_Data(PATH, "CheckProductEdition", 1 , 2);
		String expectedLCPtitle = read_XL_Data(PATH, "CheckProductEdition", 1 , 3);
		String expectedProductEdition = read_XL_Data(PATH, "CheckProductEdition", 1 , 4);
		
		
		openApplication("chrome");
		
		LoginPage lp = new LoginPage(driver);
		
		verifyPage(driver, LPTITLE);
		lp.setUsername( un );
		lp.setPassword( pw );
		lp.clickLoginButton();
		Thread.sleep(1000);
		verifyPage(driver, expectedETPtitle);
		
		EnterTimeTrackPage ep = new EnterTimeTrackPage(driver);
		ep.clickSettings();
		ep.clickLicense();
		Thread.sleep(1000);
		verifyPage(driver, expectedLCPtitle);
		
		LicensePage lip = new LicensePage(driver);
		lip.getProductEdition();
		lip.verifyProductEdition(driver, expectedProductEdition);
		
		closeApplication();
	}
	
}
