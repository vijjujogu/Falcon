package com.shoptools.qa.utils;

import org.testng.Assert;

public class Constants {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public final static String PROJECT_BASE_PATH = System.getProperty("user.dir");
	public final static String configpath = PROJECT_BASE_PATH + "/resources/Config.properties";
	public final static String locator_path = PROJECT_BASE_PATH + "/resources/locators.properties";
	public final static String testdata_path= PROJECT_BASE_PATH + "/resources/testdata.properties";
	
	public  boolean verifyResult(Object actual,Object expected,String message) {
		try {
			Assert.assertEquals(actual, expected);
			System.out.println("PASS : " + message + ": " + "ACTUAL : " + actual + " 	" + "EXPECTED :" + expected);
			return true;
		}
			catch (AssertionError assertionError) {
				return false;
			}
		
	}
}
