package com.shoptools.qa.webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.shoptools.qa.base.Base;

public class HomePage extends Base{

	
	public void clickOnMYwishlist(String wishlist)
	{
		driver.findElement(By.xpath(wishlist));
	}
	
	public String clickOnProduct1(String product1)
	{
		//WebElement product=//a[text()='"+product1+"'];
		String productName=driver.findElement(By.xpath(product1)).getText();
		driver.findElement(By.xpath(product1)).click();
		System.out.println(productName);
		return productName;
		
	}
	public void clickOnProduct2(String product2)
	{
		//WebElement product=//a[text()='"+product1+"'];
		
		driver.findElement(By.xpath(product2)).click();
	}
	
}
