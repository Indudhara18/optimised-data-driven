package com.OptimaisedDataDrivenActiTime.generics;

/**
 * This interface is having all the constants for this particular project
 * @author Indudhara
 *
 */
public interface IAutoConstants 
{
	
	// by default public static final will be added by compiler
	
	String CHROME_KEY = "webdriver.chrome.driver" ;
	String CHROME_VALUE = "./driver/chromedriver.exe" ;
	
	String GECKO_KEY = "webdriver.gecko.driver" ;
	String GECKO_VALUE = "./driver/geckodriver.exe" ;
	
	String URL = "http://localhost/login.do" ;
	
	long ITO = 20 ;
	long ETO = 20 ;
	
	String LPTITLE = "actiTIME - Login" ;
	String ETTPTITLE = "actiTIME - Enter Time-Track" ;
	String TLTITLE = "actiTIME - Task List" ;
	String LICPTITLE = "actiTIME - Licenses" ;
	
	String PATH = "./data/input.xlsx" ;
	String VALIDLOGINSHEET = "ValidCredential" ;
	String INVALIDLOGINSHEET = "InvalidCredential" ;
	
	
}
