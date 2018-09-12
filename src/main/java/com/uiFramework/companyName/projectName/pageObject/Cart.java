package com.uiFramework.companyName.projectName.pageObject;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.testbase.TestBase;

public class Cart {
	
	private WebDriver driver;
	private Logger log =LoggerHelper.getLogger(Cart.class);
	WaitHelper wait;
	
	@FindBy(xpath="//input[@type='search']")
	public WebElement search;
	
	@FindBy(css = "div._1tmI")
	WebElement bagText;
	
	@FindBy(css = "div._3dIQ")
	List <WebElement> remove;
	
	@FindBy(linkText = "Continue Shopping")
	WebElement continueShopping;
	
	@FindBy(xpath = "//div[@class='_-naE'][1]")
	WebElement removeConfirmCancel;
	
	@FindBy(xpath = "//div[@class='_-naE'][2]")
	WebElement removeConfirmYes;
	
	
	@FindBy(css = "div._35Zs")
	WebElement cartEmptyMessage;
	
	@FindBy(css = "div._2Pja")
	WebElement loginToProceed;
	
	
	public Cart(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WaitHelper(driver);
		wait.waitForElement(search, ObjectReader.reader.getImplicitWait());
		log.info("Cart object created");
		TestBase.logExtentReport("Cart object created");
	}
	
	public PaytmMall clickOnContinueShopping() throws IOException {
		log.info("Click on Continue Shopping");
		continueShopping.click();
		TestBase.logExtentReport("Click on Continue Shopping");
		return new PaytmMall(driver);
	}
	
	public void clickOnRemove(int itemNumber) {
		log.info("Click on remove");
		remove.get(itemNumber).click();
		TestBase.logExtentReport("Click on remove");
	}
	
	public void clickOnRemoveConfirmationYes() {
		log.info("Click on remove yes");
		removeConfirmYes.click();
		TestBase.logExtentReport("Click on remove yes");
	}
	
	public void clickOnRemoveConfirmationCancel() {
		log.info("Click on remove cancel");
		removeConfirmCancel.click();
		TestBase.logExtentReport("Click on remove cancel");
	}
	
	public String cartEmptyMessage() {
		String msg = cartEmptyMessage.getText();
		return msg;
	}
	
	public boolean checkCartEmpty() {
		boolean flag=false;
		String ActualMsg = "Oops! Your Cart is Empty";
		String msg = cartEmptyMessage.getText();
		if(ActualMsg.equals(msg)) {
			flag=true;
		}
		else {
			flag = false;
		}
		return flag;
	}
	
	public LoginPage clickOnLoginToProceed() throws IOException{
		log.info("Click On login to proceed");
		clickOnLoginToProceed();
		TestBase.logExtentReport("Click On login to proceed");
		return new LoginPage(driver);
	}

}
