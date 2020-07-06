package com.airtel.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.airtel.qa.util.TestUtil;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	// Create constructor of this class
	public TestBase() {
		 prop = new Properties();
		 try {
			FileInputStream ip = new FileInputStream("/AirtelXLabsAssignment/src/main/java/com/airtel/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		// read properties file
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			// define system property for chrome browser. Here i am using WebDriverManager
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// I have created TestUtil where I have put time for PageLoad and Implicit wait
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		// Get URL from properties file
		driver.get(prop.getProperty("url"));
	}
}
