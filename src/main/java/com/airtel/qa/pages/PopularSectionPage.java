package com.airtel.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.airtel.qa.base.TestBase;

public class PopularSectionPage extends TestBase {

	// Xpath to get list of price
	List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='content_price']//span[@itemprop='price']"));

	public void getPriceList() {
		
	}
}
