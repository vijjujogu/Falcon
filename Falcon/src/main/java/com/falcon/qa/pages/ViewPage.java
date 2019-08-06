package com.falcon.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.falcon.qa.base.TestBase;
import com.falcon.qa.util.TestUtil;
/**
 * class which contains methods to interact with web elements
 * @author Vijayalakshmi.Jogu
 *
 */
public class ViewPage extends TestBase{
	
	TestUtil util=new TestUtil();
	
	/**
	 * method to navigate to particular url
	 * @param view
	 */
	public void getUrl(String view)
	{
		driver.get(view);
	}
	/**
	 * method to click on dashboard toggle
	 * @param driver
	 * @param xpath
	 * @param timeOutInSeconds
	 */
	public void clickOnToggle(WebDriver driver, final String xpath,int timeOutInSeconds) {
		
		util.ignoreClickInterceptAndClickOnElement(driver, xpath, timeOutInSeconds);
	}
	/**
	 * method to get text of total tests run
	 * @param driver
	 * @param xpath
	 * @param timeout
	 * @return
	 */
	 public String getTextofTotalTest(WebDriver driver,String xpath,int timeout)
	 {
		 return util.waitforGetText(driver,xpath,timeout);
	 }
	
	/**
	 * method to get text of total passed tests 
	 * @param passcount
	 * @return
	 * @throws InterruptedException
	 */
	public String getTextofPassTest(String passcount) {
		
		String pass=driver.findElement(By.xpath(passcount)).getText();
		
		return pass;
		
	}
	/**
	 * method to get text of total failed tests
	 * @param failcount
	 * @return
	 */
	public String getTextofFailTest(String failcount) 
	{
		
		String fail=driver.findElement(By.xpath(failcount)).getText();
		
		return fail;
		
	}
	/**
	 * method to get text of total skiped tests
	 * @param skipcount
	 * @return
	 */
	public String getTextofSkipTest(String skipcount)  {
		
		String skip=driver.findElement(By.xpath(skipcount)).getText();
		
		return skip;
		
	}
	/**
	 * method to get the total count of status 
	 * @param status
	 * @return
	 */
	public int getStatusCount(String status)  {
		
		List<WebElement> element = driver.findElements(By.xpath(status));
		 int statuscnt = element.size();
		
		return statuscnt;
	}
	/**
	 * method to get the count of pass 
	 * @param countpass
	 * @return
	 */
	public int getpasscount(String countpass)
	{
		List<WebElement> element = driver.findElements(By.xpath(countpass));
		 int cntpass = element.size();
		
		return cntpass;
	}
	/**
	 * method to get the count of fail
	 * @param countfail
	 * @return
	 */
	public int getfailcount(String countfail)
	{
		List<WebElement> element = driver.findElements(By.xpath(countfail));
		 int cntfail = element.size();
		
		return cntfail;
	}
}