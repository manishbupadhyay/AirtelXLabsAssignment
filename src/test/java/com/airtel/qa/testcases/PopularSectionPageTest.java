package com.airtel.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.airtel.qa.base.TestBase;
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
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
