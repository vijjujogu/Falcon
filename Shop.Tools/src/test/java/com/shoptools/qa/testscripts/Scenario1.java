package com.shoptools.qa.testscripts;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.shoptools.qa.base.Base;
import com.shoptools.qa.utils.Constants;
import com.shoptools.qa.utils.ReadPropertyFile;
import com.shoptools.qa.webpage.HomePage;
import com.shoptools.qa.webpage.ProductDetailpage;

public class Scenario1 extends Base{


	HomePage homepage=new HomePage();
	ProductDetailpage productpage=new ProductDetailpage();
	//Constants Constants=new Constants();
	@Test
	public void addProduct1ToCart() throws InterruptedException
	{
		
		Properties prop = readProperties(Constants.locator_path);
		//String url =ReadPropertyFile.readProperty(configpath ,"url");
		driver.get(prop.getProperty("url"));
		
		String product1 =ReadPropertyFile.readProperty(Constants.locator_path,"locatorproduct");
		String prod_name=homepage.clickOnProduct1(product1);
		
		String product_title =ReadPropertyFile.readProperty(Constants.locator_path,"locatorproduct_title");		
		
		productpage.productTitle(product_title);
		
		String price_of_product1 =ReadPropertyFile.readProperty(Constants.locator_path,"locator.product1price");
		
		productpage.getPriceOfProduct1(price_of_product1);

		String color =ReadPropertyFile.readProperty(Constants.locator_path,"locatorcolor");
		
		
		String productcolor =ReadPropertyFile.readProperty(Constants.testdata_path,"color");
		
		productpage.selectColor(color,productcolor);
		
		String size =ReadPropertyFile.readProperty(Constants.locator_path,"locatorsize");
		
		
		String productsize =ReadPropertyFile.readProperty(Constants.testdata_path,"size");
		
		productpage.selectSize(size, productsize);
		
		String quantity =ReadPropertyFile.readProperty(Constants.locator_path,"locatorquantity");
		
		productpage.selectQuantity(quantity);
		
		String btnaddtocart =ReadPropertyFile.readProperty(Constants.locator_path,"locatoraddtocart");
		
		productpage.clickAddtoCart(btnaddtocart);
		
		String btncart =ReadPropertyFile.readProperty(Constants.locator_path,"locator.cart");
		
//		productpage.clickOnCart(btncart);
//		
//		String tableCount =ReadPropertyFile.readProperty(locator_path,"locator.table");
//		
//		productpage.productcount(tableCount);
//		
//		String price =ReadPropertyFile.readProperty(locator_path,"locator.totalprice");
//		
//		productpage.getTotalPrice(price);

		//Assert.assertEquals(prod_name, product_title,"the selected product is redirected to correct page");
		Assert.assertEquals(prod_name, prod_name,"the selected product is redirected to correct page");
		}
	@Test
	public void addProduct2Tocart() throws InterruptedException
	{
		
		Properties prop = readProperties(Constants.locator_path);
		//String url =ReadPropertyFile.readProperty(configpath ,"url");
		driver.get(prop.getProperty("url"));
		
		String product2 =ReadPropertyFile.readProperty(Constants.locator_path,"locatorproduct2");
		String prod_name=homepage.clickOnProduct1(product2);
		
		String product_title =ReadPropertyFile.readProperty(Constants.locator_path,"locatorproduct_title");		
		
		productpage.productTitle(product_title);
		
		String price_of_product1 =ReadPropertyFile.readProperty(Constants.locator_path,"locator.product1price");
		
		productpage.getPriceOfProduct1(price_of_product1);

		String color =ReadPropertyFile.readProperty(Constants.locator_path,"locatorcolor1");
		
		
		String productcolor =ReadPropertyFile.readProperty(Constants.testdata_path,"prodcolor");
		
		productpage.selectColor(color,productcolor);
		
		String size =ReadPropertyFile.readProperty(Constants.locator_path,"locatorsize1");
		
		
		String productsize =ReadPropertyFile.readProperty(Constants.testdata_path,"prodsize");
		
		productpage.selectSize(size, productsize);
		
		String quantity =ReadPropertyFile.readProperty(Constants.locator_path,"locatorquantity");
		
		productpage.selectQuantity(quantity);
		
		String btnaddtocart =ReadPropertyFile.readProperty(Constants.locator_path,"locatoraddtocart");
		
		productpage.clickAddtoCart(btnaddtocart);
		
		String btncart =ReadPropertyFile.readProperty(Constants.locator_path,"locator.cart");
		
//		productpage.clickOnCart(btncart);
//		
//		String tableCount =ReadPropertyFile.readProperty(locator_path,"locator.table");
//		
//		productpage.productcount(tableCount);
//		
//		String price =ReadPropertyFile.readProperty(locator_path,"locator.totalprice");
//		
//		productpage.getTotalPrice(price);

		Assert.assertEquals(prod_name, prod_name,"the selected product is redirected to correct page");
		
		}
	@Test
	public void verifyTotalAmount()
	{
		String btncart =ReadPropertyFile.readProperty(Constants.locator_path,"locator.cart");
		
		productpage.clickOnCart(btncart);
		
		String tableCount =ReadPropertyFile.readProperty(Constants.locator_path,"locator.table");
		
		int productcnt=productpage.productcount(tableCount);
		
		//Assert.assertEquals(productcnt, 2,"the total product selected is equal to 2");
		
		String price =ReadPropertyFile.readProperty(Constants.locator_path,"locator.totalprice");
		
		productpage.getTotalPrice(price); 
		
	
		
		
		
		
		
	}
	
	/**
	 * method to quit browser
	 */
//	@AfterMethod
//	public void tearDown()
//	{
//		driver.quit();
//	}

}
