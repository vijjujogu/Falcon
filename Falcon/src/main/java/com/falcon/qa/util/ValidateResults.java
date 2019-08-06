package com.falcon.qa.util;
import org.testng.Assert;
/**
 * class which contains all assert methods
 * @author Vijayalakshmi.Jogu
 *
 */
public class ValidateResults {
		

		/**
		 * to verify integer values
		 * @param actual
		 * @param expected
		 * @param message
		 * @return
		 */
			public boolean verifyResult(int actual,int expected,String message) {
				try {
					Assert.assertEquals(actual, expected);
					System.out.println("PASS : " + message + ": " + "ACTUAL : " + actual + " 	" + "EXPECTED :" + expected);
					return true;
				}
					catch (AssertionError assertionError) {
						return false;
					}
				
			}
			/**
			 * to verify strings 
			 * @param actual
			 * @param expected
			 * @param message
			 * @return
			 */
			public boolean verifyResult(Object actual,Object expected,String message) {
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




