package com.uiFramework.companyName.projectName.testbase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.BrowserType;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.ChromeBrowser;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.FirefoxBrowser;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.IExplorerBrowser;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.utils.ExtentManager;

import net.bytebuddy.jar.asm.commons.Method;

public class TestBase {
	
	private Logger log = LoggerHelper.getLogger(TestBase.class);
	public static ExtentReports extent;
	public static ExtentTest test;
	WebDriver driver;
	@BeforeSuite
	public void beforeSuit() {
		extent = ExtentManager.getInstance();
	}
	
	@BeforeClass
	public void beforeClass() {
		
		test = extent.createTest(getClass().getName());
	}
	
	@BeforeMethod
	public void beforeMethod(){
		test.log(Status.INFO, "**************test started***************");
		log.info("**************Started***************");
	}

	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName()+" is fail" + result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName()+" is pass");
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, result.getName()+" is skip" + result.getThrowable());
		}
		extent.flush();
	}
	
	public WebDriver getBrowserObject(BrowserType btype) throws Exception {
		try {
			switch(btype) {
			case Chrome:
				//get object of chrome browser class
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				ChromeOptions option = chrome.getChromeOptions();
				return chrome.getChromeDriver(option);
				
			case Firefox:
				//get object of chrome browser class
				FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
				FirefoxOptions options = firefox.getFirefoxOptions();
				return firefox.getFirefoxDriver(options);
				
				
			case IExplorer:
				//get object of chrome browser class
				IExplorerBrowser ie = IExplorerBrowser.class.newInstance();
				InternetExplorerOptions cap = ie.getIExplorerBrowserOptions();
				return ie.getInternetExplorerDriver(cap);
				
				default:
					throw new Exception("driver not found " +btype.name());
			}
			
		}catch(Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}
	
	public void setUpDriver(BrowserType btype) throws Exception {
		driver = getBrowserObject(btype);
		log.info("Initialize web driver : "+driver.hashCode());
		WaitHelper wait = new WaitHelper(driver);
		wait.setImplicitWait(30, TimeUnit.SECONDS);
		wait.pageLoadTimeOut(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
}
