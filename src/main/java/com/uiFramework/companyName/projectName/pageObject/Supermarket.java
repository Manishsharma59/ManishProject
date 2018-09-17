package com.uiFramework.companyName.projectName.pageObject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.select.DropDownHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.testbase.TestBase;

public class Supermarket {
	

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(Supermarket.class);
	WaitHelper wait;
	DropDownHelper dropDownHelper;
	
	
	@FindBy(xpath="//input[@type='search']")
	public WebElement search;

	public Supermarket(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitHelper(driver);
		wait.waitForElement(search, ObjectReader.reader.getImplicitWait());
		log.info("Supermarket Page Object created");
		new TestBase().getNavigationScreen(driver);
	}

}
