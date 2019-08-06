package com.falcon.qa.util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.falcon.qa.base.TestBase;
import com.google.common.base.Function;

/**
 * util class which contains methods for wait operations
 * @author Vijayalakshmi.Jogu
 *
 */
public class TestUtil extends TestBase {
	static String text;
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	/**
	 * fluent wait for finding element and click on it
	 * @param driver
	 * @param xpath
	 * @param timeOutInSeconds
	 */
	public  void ignoreClickInterceptAndClickOnElement(WebDriver driver,final String xpath,int timeOutInSeconds) {
		FluentWait<WebDriver> fluentWait =  new FluentWait<WebDriver>( driver)
				.ignoring(ElementClickInterceptedException.class)
				.pollingEvery(timeOutInSeconds, TimeUnit.SECONDS)
				.withTimeout(timeOutInSeconds,TimeUnit.SECONDS);
		
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				element.click();
				return true;
			}
		});
	}
	/**
	 * explicit wait for finding url until it is present
	 * @param driver
	 * @param element
	 * @param timeout
	 */
	public  void urlwait(WebDriver driver, String element, int timeout)
	{
		 new WebDriverWait(driver,timeout).until(ExpectedConditions.urlToBe(element));
	}
	/**
	 * explicit wait for finding web element and retrieving the text of it
	 * @param driver
	 * @param element
	 * @param timeout
	 * @return
	 */
	
	public  String waitforGetText(WebDriver driver, String element, int timeout) {
		 new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
		 String total=driver.findElement(By.xpath(element)).getText();
		 return total;
	}
	
}
		
	
	
			
	

	

