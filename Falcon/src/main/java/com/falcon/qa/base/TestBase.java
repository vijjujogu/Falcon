package com.falcon.qa.base;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.falcon.qa.util.TestUtil;
/**
 * Base class for browser launch and reading property file
 * @author Vijayalakshmi.Jogu
 *
 */
public class TestBase {
	
	// declaration of global variables
	public static WebDriver driver;
	public static Properties prop;
	public final static String PROJECT_BASE_PATH = System.getProperty("user.dir");
	/**
	 * logic for reading property file
	 */
	public TestBase() 
	{
	
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(PROJECT_BASE_PATH+ "/src/main/java/com/falcon"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * logic for initializing browser
	 */
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		//String path = Constants.PROJECT_BASE_PATH + "/resources/Config.properties";
		String chromepath =PROJECT_BASE_PATH + "/lib/chromedriver.exe";
		String ffpath =PROJECT_BASE_PATH + "/lib/geckodriver.exe";
		String iepath =PROJECT_BASE_PATH + "/lib/IEDriverServer.exe";
		
		if(browserName.equals("chrome")){
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vijayalakshmi.Jogu\\eclipse-workspace\\Falcon\\lib\\chromedriver.exe");	
			System.setProperty("webdriver.chrome.driver",chromepath);
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver",ffpath);	
			driver = new FirefoxDriver(); 
		}
		else if(browserName.equals("IE")){
			System.setProperty("webdriver.ie.driver",iepath);	
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
}	
