package com.shoptools.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.shoptools.qa.utils.Constants;
import com.shoptools.qa.utils.ReadPropertyFile;


public class Base {
	
	
	public static WebDriver driver;
	public static Properties prop;
	public final static String PROJECT_BASE_PATH = System.getProperty("user.dir");
	//String path = PROJECT_BASE_PATH+ "/resources/config.properties";
	/**
	 * logic for reading property file
	 */

	 public static Properties readProperties(String path) {
			
			Properties properties = new Properties();
			try {
				FileInputStream inputStream = new FileInputStream(path);
				try {
					properties.load(inputStream);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return properties;
		}
 
	/**
	 * logic for initializing browser
	 */
	@Test
	public static void initialization() {
		
		String configpath = PROJECT_BASE_PATH + "/resources/Config.properties";
		//String br =ReadPropertyFile.readProperty(locator_path,"locatorproduct");
		Properties prop = readProperties(configpath);
		String chromepath =PROJECT_BASE_PATH + "/lib/chd.exe";
		String ffpath =PROJECT_BASE_PATH + "/lib/geckodriver.exe";
		String iepath =PROJECT_BASE_PATH + "/lib/IEDriverServer.exe";
		String browserName = prop.getProperty("browser");
		//String browserName =ReadPropertyFile.readProperty(configpath ,"browser");
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
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		//String url =ReadPropertyFile.readProperty(configpath ,"url");
	}
}	

	
