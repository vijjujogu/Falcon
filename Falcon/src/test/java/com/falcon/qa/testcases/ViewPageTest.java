package com.falcon.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.falcon.qa.base.TestBase;
import com.falcon.qa.pages.DashboardPage;

import com.falcon.qa.pages.ViewPage;
import com.falcon.qa.util.ValidateResults;
/**
 * class which contains testscripts 
 * @author Vijayalakshmi.Jogu
 *
 */
public class ViewPageTest extends DashboardPage {

	DashboardPage dashboardpage;
	ViewPage viewpage;
	ValidateResults validate=new ValidateResults();
	String view;
	String toggle;
	String totaltest;
	String passcount;
	String failcount;
	String skipcount;
	String status;
	String countpass;
	String countfail;
	String dashboardurl;
	String name;
	String name1;
	
	/**method for initialization such as setting up browser,reading property file
	 **/
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		viewpage=new ViewPage();
		dashboardpage=new DashboardPage();
		
	}
	/**
	 * method to verify the result count by dashboard toggle 
	 * @throws InterruptedException 
	 */
	@Test
	public void verifyResultCountByToggle() throws InterruptedException 
	{
		// to retrieve the xpath from property file
		
		dashboardurl = prop.getProperty("dashboardurl");
		view = prop.getProperty("view");
		 toggle = prop.getProperty("toggle");
		 totaltest = prop.getProperty("totaltest");
		 passcount = prop.getProperty("passcount");
		 failcount = prop.getProperty("failcount");
		 skipcount = prop.getProperty("skipcount");
		 name = prop.getProperty("name");
		name1=prop.getProperty("name1");
		 
		 
		dashboardpage.getUrlofDashboard(dashboardurl);
		
		String path=dashboardpage.linkXpath(name, name1);
		dashboardpage.dashboardlinks(driver,path,30); 
		viewpage.clickOnToggle(driver,toggle,30);
		
		//code to retrieve the total test count
		
		String total=viewpage.getTextofTotalTest(driver,totaltest,30);
		String value = total.replaceAll("[^0-9]", ""); 
		int finaltotal = Integer.parseInt(value);
		System.out.println("total"+finaltotal);
		
		//code to retrieve the pass test count
		String pass=viewpage.getTextofPassTest(passcount);
		int pass1 = Integer.parseInt(pass);
		System.out.println("pass"+pass1);
		
		//code to retrieve the fail test count
		String fail=viewpage.getTextofFailTest(failcount);
		int fail1 = Integer.parseInt(fail);
		System.out.println("fail"+fail1);
		
		//code to retrieve the skip test count
		String skip=viewpage.getTextofSkipTest(skipcount);
		int skip1 = Integer.parseInt(skip); 
		System.out.println("skip"+skip1);
		
		int count=pass1+fail1+skip1;
		
		//calling assert method to verify the result
		validate.verifyResult(finaltotal, count, "the total tests executed is equal to sum of pass,fail and skip");
		
		//code to retrieve count of status
		status=prop.getProperty("status");
		int statusct=viewpage.getStatusCount(status);
		System.out.println("Total Tests are" + statusct);
		
		//calling assert method to verify the result
		validate.verifyResult(finaltotal, statusct, "The total tests run are equal to status tests");

		//code to retrieve pass count
		countpass=prop.getProperty("countpass");
		int passcnt=viewpage.getpasscount(countpass);
		System.out.println("pass count is"+passcnt);
		
		//calling assert method present in TestUtil class to verify the result
		validate.verifyResult(passcnt, pass1,"The total pass count of status  is equal to actual test passed");
		
		//code to retrieve fail count
		countfail=prop.getProperty("countfail");
		int failcnt=viewpage.getpasscount(countfail);
		System.out.println("pass count is"+failcnt);
		
		//calling assert method to verify the result
		validate.verifyResult(failcnt,fail1,"The total fail count of status  is equal to actual test failed");
		
		
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
