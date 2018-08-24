package com.uiFramework.companyName.projectName.helper.alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class AlertHelper {
	
	private Logger log = LoggerHelper.getLogger(AlertHelper.class);
	private WebDriver driver;
	
	public AlertHelper(WebDriver driver) {
		this.driver =driver;
		log.info("AlertHelper Object is created");
	}
	
	public Alert getAlert() {
		log.info("Alert text "+driver.switchTo().alert().getText());
		driver.switchTo().alert().getText();
		return driver.switchTo().alert();
	}
	public void acceptAlert() {
		getAlert().accept();
		log.info("Accept alert is done");
		
	}
	
	public void dismissAlert() {
		getAlert().dismiss();
		log.info("Accept dismiss is done");
		
	}
	
	public String getAlertText() {
		String text = getAlert().getText();
		log.info("Alert text is "+text);
		return text;
	}
	
	public boolean isAlertPresent() {
		
		try {
			driver.switchTo().alert();
			log.info("alert is present");
			return true;
		}catch(NoAlertPresentException e) {
			log.info(e.getCause());
			return false;
		}
	}
	
	public void acceptAlertIfPresent() {
		if(isAlertPresent()) {
			acceptAlert();
		}
		else {
			log.info("Alert is not present");
		}
	}
	
	
	public void dismissAlertIfPresent() {
		if(isAlertPresent()) {
			dismissAlert();
		}
		else {
			log.info("Alert is not present");
		}
	}
	
	public void acceptPrompt(String text) {
		if(isAlertPresent()) {
			Alert alert = getAlert();
			alert.sendKeys(text);
			alert.accept();
			log.info("alert text : "+text);
		}
	}
	
	}