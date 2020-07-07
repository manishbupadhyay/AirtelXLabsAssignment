package com.airtel.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.airtel.qa.base.TestBase;
import com.airtel.qa.extentreport.ExtentReport;
import com.airtel.qa.pages.PopularItemsWithDiscount;


public class PopularItemsWithDiscountTest extends TestBase {

	PopularItemsWithDiscount popularItemsWithDiscount;

	public PopularItemsWithDiscountTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		popularItemsWithDiscount = new PopularItemsWithDiscount();
	}

	@Test
	public void discountItemsTest() {
	
		popularItemsWithDiscount.itemsWithDiscount();
		popularItemsWithDiscount.itemsOriginalPrice();
		popularItemsWithDiscount.itemsPriceAfterDiscount();
	}

	@AfterMethod
	public void tearDown() {
		ExtentReport.htmlExtentReport();
		driver.quit();
	}
}
