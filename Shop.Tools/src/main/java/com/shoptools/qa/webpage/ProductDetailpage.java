package com.shoptools.qa.webpage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.shoptools.qa.base.Base;
import com.shoptools.qa.utils.ReadPropertyFile;



public class ProductDetailpage extends Base {

	public void productTitle(String productTitle) {
		
		//String productTitlepath =ReadPropertyFile.readProperty(path,productTitle);
		String title=driver.findElement(By.xpath(productTitle)).getText();
		System.out.println(title);
	}
	public void selectColor(String color_dropdown,String color ) {
		Select dropdown = new Select(driver.findElement(By.xpath(color_dropdown)));
		dropdown.selectByVisibleText(color);		
	}
	public void selectSize(String size_dropdown,String size)
	{
		Select dropdown = new Select(driver.findElement(By.xpath(size_dropdown)));
		dropdown.selectByVisibleText(size);		
	}
	public void selectQuantity(String quantity)
	{
		driver.findElement(By.xpath(quantity)).click();
	}
	public void clickAddtoCart(String btnAddtocart) {
		driver.findElement(By.xpath(btnAddtocart)).click();
	}
	public void clickOnCart(String btnCart)
	{
		driver.findElement(By.xpath(btnCart)).click();
	}
	public int productcount(String count)
	{
		List<WebElement> element = driver.findElements(By.xpath(count));
		int cnt = element.size();
		System.out.println(cnt);
		return cnt;
	}
	public void getTotalPrice(String price)
	{
		String total_price=driver.findElement(By.xpath(price)).getText();
		//int amount=Integer.parseInt(total_price.replaceAll("[^0-9]", "")); 
		System.out.println(total_price);
		
	}
	public void getPriceOfProduct1(String price1)
	{
		String product1_price=driver.findElement(By.xpath(price1)).getText();
		//int product1_amount=Integer.parseInt(product1_price.replaceAll("[^0-9]", "")); 
		System.out.println(product1_price);
		
	}
	public void getPriceOfProduct2(String price2)
	{
		String product2_price=driver.findElement(By.xpath(price2)).getText();
		//int product2_amount=Integer.parseInt(product2_price.replaceAll("[^0-9]", "")); 
		System.out.println(product2_price);
	}
	
}
