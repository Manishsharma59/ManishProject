package com.uiFramework.companyName.projectName.pageObject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.testbase.TestBase;

public class NavigationMenu {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(HomePage.class);
	WaitHelper wait;
	
	@FindBy(name="menuOption")
	public WebElement menuOption;
	
	public NavigationMenu(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WaitHelper(driver);
		wait.waitForElement(menuOption, ObjectReader.reader.getImplicitWait());
		new TestBase().getNavigationScreen(driver);
		TestBase.logExtentReport("Home Page objectcreated");
	}
	
	public void mouseOver(String data) {
		log.info("doing mouse over "+data);
		TestBase.logExtentReport("doing mouse over "+data);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[contains(text()='"+data+"']"))).build().perform();
	}
}
