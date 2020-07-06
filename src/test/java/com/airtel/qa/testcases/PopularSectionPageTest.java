package com.airtel.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.airtel.qa.base.TestBase;
import com.airtel.qa.extentreport.ExtentReport;
import com.airtel.qa.pages.PopularSectionPage;

public class PopularSectionPageTest extends TestBase {

	PopularSectionPage popularSectionPage;

	public PopularSectionPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		popularSectionPage = new PopularSectionPage();
	}

	@Test
	public void itemsWithLowestPrice() {
	
		popularSectionPage.addToCartLowsetPriceItem();
		
		// verify that product is successfully added to cart or not
		String shoppingCartContains = driver.findElement(By.xpath("//span[@id='summary_products_quantity']//parent::span[@class='heading-counter']"))
		.getText().substring(29, 31).replaceAll("\\s", "");
		
		System.out.println(shoppingCartContains); // output: 1

		String viewCartElement = driver.findElement(By.xpath("//div[@class='shopping_cart']//span[@class='ajax_cart_quantity']")).getText();
		
		System.out.println(viewCartElement); // output: 1
	
		Assert.assertEquals(shoppingCartContains, viewCartElement);
		
	}

	@AfterMethod
	public void tearDown() {
		ExtentReport.htmlExtentReport();
		driver.quit();
	}
}
