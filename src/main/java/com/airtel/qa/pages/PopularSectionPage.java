package com.airtel.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.airtel.qa.base.TestBase;
import com.airtel.qa.util.TestUtil;

public class PopularSectionPage extends TestBase {

	// Xpath to get list of price
	List<WebElement> priceList = driver.findElements(By.xpath("//ul[@id='homefeatured']//div[@class='right-block']/div[@class='content_price']//span[@itemprop='price']"));

	public void addToCartLowsetPriceItem() {
		int lowestIndex=0;
		double lowestPrice = Double.parseDouble(priceList.get(0).getText().substring(1));
		for(int i=1; i<priceList.size(); i++) {
			String priceText = priceList.get(i).getText();
			double temp = Double.parseDouble(priceText.substring(1));
			if(temp<lowestPrice) {
				lowestPrice=temp;
				lowestIndex=i;
			}

		}
		System.out.println(lowestPrice);
		WebElement element = driver.findElement(By.xpath("(//ul[@id='homefeatured']//div[@class='right-block']/div[@class='button-container']//a[@title='Add to cart'])["+lowestIndex+"]"));

		// call scroll into view method to keep scrolling until find Add to cart
		scrollIntoView(element,driver);

		Actions action = new Actions(driver);
		action.moveToElement(priceList.get(lowestIndex)).build().perform();

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.findElement(By.xpath("(//ul[@id='homefeatured']//div[@class='right-block']/div[@class='button-container']//a[@title='Add to cart'])["+lowestIndex+"]")).click();
		
	}

	// scroll and view an element
	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
