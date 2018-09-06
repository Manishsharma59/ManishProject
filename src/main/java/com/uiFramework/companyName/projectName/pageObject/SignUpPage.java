package com.uiFramework.companyName.projectName.pageObject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.testbase.TestBase;

public class SignUpPage {
	
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(SignUpPage.class);
	WaitHelper wait;
	
	
	@FindBy(xpath  = "//input[@name='mobileNumber']")
	public WebElement mobileNUmber;
	
	@FindBy(xpath  = "//input[@name='loginPassword']")
	public WebElement createPassword;
	
	@FindBy(xpath  = "//input[@name='email']")
	public WebElement eMailId;
	
	@FindBy(xpath  = "(//button[@name='signupBtn'])[2]")
	public WebElement proceed;
	
	public SignUpPage(WebDriver driver) throws IOException {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
		WaitHelper wait = new WaitHelper(driver);
		wait.waitForElement(mobileNUmber, ObjectReader.reader.getImplicitWait());
		log.info("Sign Up page object created");
		new TestBase().getNavigationScreen(driver);
		
	}

	
	public void enterMobileNumber() {
		mobileNUmber.sendKeys(ObjectReader.reader.getUserName());
		log.info("Entering Mobile number");
		TestBase.logExtentReport("Entering Mobile number "+ObjectReader.reader.getUserName());
	}
	
	public void enterCreatePassword() {
		createPassword.sendKeys(ObjectReader.reader.getUserName());
		log.info("Entering create password");
		TestBase.logExtentReport("Entering create password "+ObjectReader.reader.getUserName());
	}
	
	public void enterEmail() {
		eMailId.sendKeys(ObjectReader.reader.getUserName());
		log.info("Entering Email");
		TestBase.logExtentReport("Entering Email "+ObjectReader.reader.getUserName());
	}
	
	public void clickOnProceed() {
		proceed.click();
		log.info("Click on Proceed");
		TestBase.logExtentReport("Click on Proceed");
	}
	
	public void signUp() {
		enterMobileNumber();
		enterCreatePassword();
		enterEmail();
		new WaitHelper(driver).waitForElement(proceed, 20);
		clickOnProceed();
	}
}
