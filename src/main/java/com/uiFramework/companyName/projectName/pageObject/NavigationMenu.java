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
	private Logger log = LoggerHelper.getLogger(NavigationMenu.class);
	WaitHelper wait;
	
	
	public NavigationMenu(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		log.info("NavigationMenu object created");
	}
	
	public void mouseOverXpath(String xpath) {
		log.info("doing mouse over "+xpath);
		TestBase.logExtentReport("doing mouse over "+xpath);
		WebElement ele = driver.findElement(By.xpath("//*[contains(text()='"+xpath+"']"));
		wait = new WaitHelper(driver);
		wait.waitForElement(ele, 10);
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}
	
	public void mouseOverCss(String css) {
		log.info("doing mouse over "+css.toString());
		TestBase.logExtentReport("doing mouse over "+css.toString());
		WebElement ele = driver.findElement(By.cssSelector(css));
		wait = new WaitHelper(driver);
		wait.waitForElement(ele, 10);
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}
	
	public void clickOnMouseOverOption(String data) {
		log.info("clicking on option "+data.toString());
		TestBase.logExtentReport("clicked on option "+data.toString());
		WebElement ele = driver.findElement(By.xpath("//*[text()='"+data+"']"));
		wait = new WaitHelper(driver);
		wait.waitForElement(ele, 10);
		ele.click();
	}
	
public void navigateBackward() {
		
		log.info("Doing navigate backward");
		TestBase.logExtentReport("Doing navigate backward");
		//WebElement ele = driver.findElement(By.xpath("//*[contains(text()='"+xpath+"']"));
		//wait = new WaitHelper(driver);
		//wait.waitForElement(ele, 10);
		driver.navigate().back();
	}
}
