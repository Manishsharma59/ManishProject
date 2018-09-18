package com.uiFramework.companyName.projectName.helper.assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class VerificationHelper {

	private Logger log = LoggerHelper.getLogger(VerificationHelper.class);
	private WebDriver driver;

	public VerificationHelper(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDiplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("Element is present "+element.getText());
			return true;
		} catch (Exception e) {
			log.error(element.toString() + " Element is not present " + e.getCause());
			return false;
		}
	}

	public boolean isNotDiplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("Element is displayed");
			return false;
		} catch (Exception e) {
			log.error(element.toString() + " Element is not displayed ");
			return true;
		}
	}
	
	public String readValueFromElement(WebElement element) {
		if (null == element) {
			log.info("WebElement is null..");
			return null;
		}
		boolean status = isDiplayed(element);
		if (status) {
			log.info("element text is "+element.getText());
			return element.getText();
		} else {
			return null;
		}
	}

	public String getText(WebElement element) {
		if (null == element) {
			log.info("WebElement is null..");
			return null;
		}
		boolean status = isDiplayed(element);
		if (status) {
			log.info("element text is "+element.getText());
			return element.getText();
		} else {
			return null;
		}
	}
	
	public String getTitle() {
		log.info("Page title is " +driver.getTitle());
		return driver.getTitle();
	}

}
