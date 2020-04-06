package com.uiFramework.companyName.projectName.testbase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.BrowserType;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.ChromeBrowser;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.EdgeBrowser;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.FirefoxBrowser;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.IExplorerBrowser;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.PropertyReader;
import com.uiFramework.companyName.projectName.helper.excel.ExcelHelper;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.resource.ResouceHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.utils.ExtentManager;


public class TestBase {
	
	private Logger log = LoggerHelper.getLogger(TestBase.class);
	public static ExtentReports extent;
	public static ExtentTest test;
	public static File reportDirectory;
	public WebDriver driver;
	@BeforeSuite
	public void beforeSuit() {
		extent = ExtentManager.getInstance();
	}
	@BeforeTest
	public void beforeTest() throws Exception {
		ObjectReader.reader = new PropertyReader();
		reportDirectory = new File(ResouceHelper.getResources("src\\main\\resources\\Screenshots"));
		setUpDriver(ObjectReader.reader.getBrowserType());
		test = extent.createTest(getClass().getSimpleName());
	}
	@BeforeClass
	public void beforeClass() {
		
		
	}
	
	@BeforeMethod
	public void beforeMethod(){
		test.log(Status.INFO, "**************test started***************");
		log.info("**************Started***************");
	}

	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName()+" is fail" + result.getThrowable());
			String imagePath = captureScreen(result.getName(),driver);
			test.addScreenCaptureFromPath(imagePath);
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName()+" is pass");
			String imagePath = captureScreen(result.getName(),driver);
			test.addScreenCaptureFromPath(imagePath);
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, result.getName()+" is skip" + result.getThrowable());
		}
		extent.flush();
		
	}
	
	@AfterTest
	public void afterTest() throws Exception{
		if(driver!=null){
			//driver.quit();
		}
	}

	
	public WebDriver getBrowserObject(BrowserType btype) throws Exception {
		try {
			switch(btype) {
			case Chrome:
				//get object of chrome browser class
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();//this is equal to new ChromeBrowser();
				ChromeOptions option = chrome.getChromeOptions();
				return chrome.getChromeDriver(option);
				
			case Firefox:
				//get object of chrome browser class
				FirefoxBrowser firefox = new FirefoxBrowser();
				FirefoxOptions options = firefox.getFirefoxOptions();
				return firefox.getFirefoxDriver(options);
				
				
			case IExplorer:
				//get object of chrome browser class
				IExplorerBrowser ie = IExplorerBrowser.class.newInstance();
				InternetExplorerOptions cap = ie.getIExplorerBrowserOptions();
				return ie.getInternetExplorerDriver(cap);
				
			case Edge:
				//get object of chrome browser class
				EdgeBrowser edge = EdgeBrowser.class.newInstance();
				return edge.getEdgeDriver();
				
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
		wait.setImplicitWait(ObjectReader.reader.getImplicitWait(), TimeUnit.SECONDS);
		wait.pageLoadTimeOut(ObjectReader.reader.getExplicitWait(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
	}
	
	public String captureScreen(String fileName, WebDriver driver) {
		
		if(driver == null) {
			log.info("driver is null");
			return null;
		}
		if(fileName=="") {
			
			fileName = "blank";
		}
		File destFile = null;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			destFile = new File(reportDirectory+"/"+fileName+"_"+dateFormatter.format(cal.getTime())+".png");
			//FileUtils.getFileUtils().copyFile(scrFile, destFile);
			Files.copy(scrFile.toPath(), destFile.toPath());
			Reporter.log("<a href='"+destFile.getAbsolutePath()+"'><img src = '"+destFile.getAbsolutePath()+"'height='100' width='100'/></a>");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return destFile.toString();
	}
	
	
	public void getNavigationScreen(WebDriver driver) throws IOException {
		log.info("Capturing ui navigation screen..");
		String screen = captureScreen("",driver);
				test.addScreenCaptureFromPath(screen);
	}
	
	public static void logExtentReport(String s1) {
		TestBase.test.log(Status.INFO, s1);
	}
	
	public void getApplicationUrl(String url) {
		driver.get(url);
		log.info("Opening url "+ObjectReader.reader.getURL());
		logExtentReport("Opening url "+ObjectReader.reader.getURL());
	}

	public Object[][] getExcelData(String excelName, String sheetName){
		String excelLocation = ResouceHelper.getResources("src\\main\\resources\\excels\\"+excelName);
		log.info("Excel Location "+excelLocation);
		ExcelHelper excelHelper = new ExcelHelper();
		Object[][] data = excelHelper.getExcelData(excelLocation, sheetName);
		return data;
	}
}
