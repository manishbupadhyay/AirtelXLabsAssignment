package com.airtel.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.airtel.qa.base.TestBase;

public class PopularItemsWithDiscount extends TestBase {
	// discount Percentage
	List<WebElement> discountPercentage = driver.findElements(By.xpath("//div[@class='right-block']//div[@itemprop='offers']//span[@class='price-percent-reduction']"));
	
	// Original price
	List<WebElement> originalPrice = driver.findElements(By.xpath("//div[@class='right-block']//div[@itemprop='offers']//span[@class='old-price product-price']"));

	// price after discount
	List<WebElement> priceAfterDiscount = driver.findElements(By.xpath("//div[@class='right-block']//span[@class='price product-price']//parent::div[@itemtype=\"http://schema.org/Offer\"]"));

	public void itemsWithDiscount() {
		for(int i=0; i<discountPercentage.size(); i++) {
			String discountItemList = discountPercentage.get(i).getText();
			System.out.println("Discount items: "+ discountItemList);
		}
	}

	public void itemsOriginalPrice() {
		for(int j=0; j<originalPrice.size(); j++) {
			String originalPriceOfItem = originalPrice.get(j).getText();
			System.out.println("Original price of item : " + originalPriceOfItem);
		}

	}
	
	public void itemsPriceAfterDiscount() {
		for(int k=0; k<priceAfterDiscount.size(); k++) {
			String discountPrice = priceAfterDiscount.get(k).getText();
			System.out.println("Items price after discount : " + discountPrice);
		}
	}
}
