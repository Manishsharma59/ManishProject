package com.uiFramework.companyName.projectName.testScript;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.pageObject.HomePage;
import com.uiFramework.companyName.projectName.pageObject.LoginPage;
import com.uiFramework.companyName.projectName.pageObject.SignUpPage;
import com.uiFramework.companyName.projectName.testbase.TestBase;

public class Paytm extends TestBase{
	
	
	private Logger log = LoggerHelper.getLogger(Paytm.class);
	
	@Test(priority = 0,description="Login test with invalid credentials")
	public void loginPatym() throws IOException, InterruptedException {
		
		driver.get(ObjectReader.reader.getURL());
		log.info("Opening url "+ObjectReader.reader.getURL());
		TestBase.logExtentReport("Opening url "+ObjectReader.reader.getURL());
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = homePage.clickOnLogInOrSignUp();
		loginPage.login();
	}
	
	@Test(priority = 1,description="Sign up test with invalid details")
	public void signUp() throws IOException, InterruptedException {
		driver.get(ObjectReader.reader.getURL());
		log.info("Opening url "+ObjectReader.reader.getURL());
		TestBase.logExtentReport("Opening url "+ObjectReader.reader.getURL());
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = homePage.clickOnLogInOrSignUp();
		SignUpPage signUpPage = loginPage.clickOnSignUp();
		signUpPage.signUp();
	}
}
