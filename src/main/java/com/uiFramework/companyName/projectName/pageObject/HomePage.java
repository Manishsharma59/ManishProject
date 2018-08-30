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

public class HomePage {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(HomePage.class);
	WaitHelper wait;
	@FindBy(name="profileName")
	public WebElement profileName;
	
	public HomePage(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WaitHelper(driver);
		wait.waitForElement(profileName, ObjectReader.reader.getImplicitWait());
		new TestBase().getNavigationScreen(driver);
		logExtentReport("Home Page objectcreated");
	}

	public void logExtentReport(String s1) {
		TestBase.test.log(Status.INFO, s1);
		
	}

}
