package com.uiFramework.companyName.projectName.pageObject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.testbase.TestBase;



public class LoginPage {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(LoginPage.class);
	
	
	@FindBy(xpath  = "//input[@name='signIn']")
	public WebElement signIn;
	
	@FindBy(xpath  = "//input[@name='submit']")
	public WebElement submitBtn;
	
	public LoginPage(WebDriver driver) throws IOException {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
		WaitHelper wait = new WaitHelper(driver);
		wait.waitForElement(signIn, ObjectReader.reader.getImplicitWait());
		logExtentReport("My account page object created");
		new TestBase().getNavigationScreen(driver);
		
	}
	
	public HomePage clickOnSubmit() throws IOException {
		submitBtn.click();
		log.info("clicked on submit Button");
		logExtentReport("Clicked on Submit");
		return new HomePage(driver);
		
		
	}
	
	public void logExtentReport(String s1) {
		TestBase.test.log(Status.INFO, s1);
	}
}
