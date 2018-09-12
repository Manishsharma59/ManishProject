package com.uiFramework.companyName.projectName.pageObject;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.testbase.TestBase;

public class Cart {
	
	private WebDriver driver;
	private Logger log =LoggerHelper.getLogger(Cart.class);
	WaitHelper wait;
	
	@FindBy(css = "div._1tmI")
	WebElement bagText;
	
	@FindBy(css = "div._3dIQ")
	List <WebElement> remove;
	
	@FindBy(linkText = "Continue Shopping")
	WebElement continueShopping;
	
	public Cart(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WaitHelper(driver);
		//wait.waitForElement(bagText, ObjectReader.reader.getImplicitWait());
		log.info("Cart object created");
		TestBase.logExtentReport("Cart object created");
	}
	
	public HomePage clickOnContinueShopping() throws IOException {
		log.info("Click on Continue Shopping");
		continueShopping.click();
		TestBase.logExtentReport("Click on Continue Shopping");
		return new HomePage(driver);
	}
	
	public void clickOnRemove(int itemNumber) {
		log.info("Click on remove");
		remove.get(itemNumber).click();
		TestBase.logExtentReport("Click on remove");
	}
	
	

}
