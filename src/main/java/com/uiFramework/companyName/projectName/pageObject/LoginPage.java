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
	
	
	@FindBy(id  = "input_0")
	public WebElement mobOrEmailId;
	
	@FindBy(id  = "input_1")
	public WebElement password;
	
	@FindBy(xpath  = "//button[@type='submit']")
	public WebElement loginSecurely;
	
	
	@FindBy(xpath="//div[@id='login-header-wrapper']/ul/li[2]")
	public WebElement signUp;
	
	
	public LoginPage(WebDriver driver) throws IOException {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
		WaitHelper wait = new WaitHelper(driver);
		wait.waitForElement(mobOrEmailId, ObjectReader.reader.getImplicitWait());
		log.info("Login page object created");
		new TestBase().getNavigationScreen(driver);
		
	}
	
	public void enterUserName() {
		mobOrEmailId.clear();
		mobOrEmailId.sendKeys(ObjectReader.reader.getUserName());
		log.info("Entering username " +ObjectReader.reader.getUserName() );
		TestBase.logExtentReport("Entering username " +ObjectReader.reader.getUserName());
	}
	
	public void enterPassword() {
		password.clear();
		password.sendKeys(ObjectReader.reader.getPassword());
		log.info("Entering password " +ObjectReader.reader.getPassword() );
		TestBase.logExtentReport("Entering password " +ObjectReader.reader.getPassword());
	}
	
	public void clickOnloginSecurely() {
		loginSecurely.click();
		log.info("Click on loginSecurely" );
		TestBase.logExtentReport("Click on loginSecurely" );
	}
	public HomePage login() throws IOException {
		enterUserName();
		enterPassword();
		clickOnloginSecurely();
		return new HomePage(driver);	
	}
	
	public SignUpPage clickOnSignUp() throws IOException {
		signUp.click();
		log.info("click on signup");
		TestBase.logExtentReport("Click on Sign Up" );
		return new SignUpPage(driver);
		
	}

}
