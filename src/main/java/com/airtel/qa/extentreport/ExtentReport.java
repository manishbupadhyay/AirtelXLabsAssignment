package com.airtel.qa.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	public static ExtentHtmlReporter extentHtmlReporter;
	public static ExtentReports extent;
	
	public static void htmlExtentReport() {
		// Extent HTML report
		extentHtmlReporter = new ExtentHtmlReporter("/AirtelXLabsAssignment/extentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(extentHtmlReporter);
		
		ExtentTest test = extent.createTest("Popular Section Page Test");
		
		extent.flush();
	}
	
}
