package com.airtel.qa.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.airtel.qa.base.TestBase;

public class TestUtil {

	public static long PAGE_LOAD_TIMEOUT = 50;
	public static long IMPLICIT_WAIT = 40;

	public static void takeScreenshotOfCart() throws Exception {
		// take screenshot
		File screenshotFile  = ((TakesScreenshot)TestBase.driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(screenshotFile , new File("/AirtelXLabsAssignment/src/main/java/com/airtel/qa/util/productCart.png"));
	}

}
