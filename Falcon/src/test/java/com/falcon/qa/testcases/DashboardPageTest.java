package com.falcon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.falcon.qa.base.TestBase;
import com.falcon.qa.pages.DashboardPage;

import com.falcon.qa.util.ValidateResults;
/**
 * class which contains testscripts 
 * @author Vijayalakshmi.Jogu
 *
 */
public class DashboardPageTest extends TestBase {

	DashboardPage dashboardpage;
	
	ValidateResults validate=new ValidateResults();
	
	String dashboardurl;
	String productsnapshotpath;
	String name;
	String name1;
	String view;
	
	/**
	 * method for initialization such as setting up browser,reading property file
	 */
	@BeforeMethod
	public void setUp() {
		initialization();
		dashboardpage=new DashboardPage();
	}
	/**
	 * method to verify whether productsnapshot link is clicking and
	 * redirecting to dashboard page
	 * @throws InterruptedException 
	 */
	@Test(priority=1)
	public void verifyProductlinkTest() throws InterruptedException 
	{
		//reading xpath from properties file
	dashboardurl = prop.getProperty("dashboardurl");
	productsnapshotpath=prop.getProperty("productsnapshotpath");
	
	//calling productsnapshotlink
	dashboardpage.productSnapshotlink(driver,productsnapshotpath,30);
		
	dashboardpage.getUrlofDashboard(dashboardurl);
	
		
	}
	/**
	 * method to verify the application links are clickable in dashboard page
	 * and redirecting to proper page
	 * @throws InterruptedException
	 */
	@Test(priority=2)
	public void clickonLinkByNameTest() throws InterruptedException
	{
		dashboardurl = prop.getProperty("dashboardurl");
		name = prop.getProperty("name");
		name1=prop.getProperty("name1");
		
		String path=dashboardpage.linkXpath(name, name1);
		
		String actual=dashboardpage.dashboardlinks(driver,path,30);
		//System.out.println(actual);
		String expectedURL="http://falcon-dashboard.atmecs.corp:8082/#/reports/8195";
		validate.verifyResult(expectedURL,actual, "the link is redirected to correct page");
	}
	
	/**
	 * method to quit browser
	 */
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
