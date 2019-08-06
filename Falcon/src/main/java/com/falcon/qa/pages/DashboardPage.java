package com.falcon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.falcon.qa.base.TestBase;
import com.falcon.qa.util.TestUtil;

/**
 *  class which contains methods to interact with web elements
 * @author Vijayalakshmi.Jogu
 *
 */
public class DashboardPage extends TestBase{
	
	TestUtil util=new TestUtil();
	
	/**
	 * This method finds the product snapshot link and returns to that page.
	 * @param driver 
	 * @param xpath  
	 * @param timeOutInSeconds 
	 */
	
	public void productSnapshotlink(WebDriver driver, final String xpath,int timeOutInSeconds) 
	{
		
		util.ignoreClickInterceptAndClickOnElement(driver, xpath, timeOutInSeconds);
	}
	
	/**
	 * This method will redirect back to dashboard page
	 * @param dashboardurl
	 * @throws InterruptedException
	 */
	public void getUrlofDashboard(String dashboardurl) throws InterruptedException
	{
		driver.navigate().to(dashboardurl);
		
	}
	/**
	 * This method takes the application name and 
	 * services from user and return the xpath for dashboard  Application links.
	 * @param name
	 * @param name1
	 * @return
	 */
	
	public String linkXpath(String name,String name1)
	{
	 String linkxpath="//h4[text()='"+name+"']//following-sibling::small[text()='"+name1+"']";
		return linkxpath;
		
	}
	/**
	 * This method clicks on the link of dashboard page and verify it is redirected to correct page
	 * @param driver
	 * @param xpath
	 * @param timeOutInSeconds
	 * @return
	 */
	
	public String dashboardlinks(WebDriver driver, final String xpath,int timeOutInSeconds)  
	{
		
		util.ignoreClickInterceptAndClickOnElement(driver, xpath, timeOutInSeconds);
		String expectedURL="http://falcon-dashboard.atmecs.corp:8082/#/reports/8195";
		util.urlwait(driver,expectedURL, 10);
		
		String actual= driver.getCurrentUrl();
		return actual;
	}
}
