package com.OptimaisedDataDrivenActiTime.scripts;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.OptimaisedDataDrivenActiTime.generics.FWUtilis;
import com.OptimaisedDataDrivenActiTime.pages.LoginPage;


public class TestValidLoginPage extends FWUtilis
{

	public static void main(String[] args) throws InterruptedException , IOException
	{

		String un = read_XL_Data(PATH, VALIDLOGINSHEET, 1, 0);
		String pw = read_XL_Data(PATH, VALIDLOGINSHEET, 1, 1);
		
		openApplication("chrome");
		
		LoginPage lp = new LoginPage(driver);
		
		verifyPage(driver, LPTITLE);
		lp.setUsername( un );
		lp.setPassword( pw );
		lp.clickLoginButton();
		Thread.sleep(2000);
		verifyPage(driver, ETTPTITLE);
		
		takeScreenshot(driver, "./photo/and.jpg");
		
		closeApplication();
		
	}
	
}
