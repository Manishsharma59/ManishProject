package com.uiFramework.companyName.projectName.pageObject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.testbase.TestBase;

public class PaytmMall {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(PaytmMall.class);
	WaitHelper wait;
	
	
	public static final String TOPWEARSTORE_CATEGORY = "Topwear Store";
	public static final String TSHIRTS_SUBCATEGORY = "T-Shirts";
	
	public WebElement category(String category) {
		return driver.findElement(By.xpath("//*[text()='" +category+ "']"));
	}
	
	@FindBy(xpath="//input[@type='search']")
	public WebElement search;
	
	public PaytmMall(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitHelper(driver);
		wait.waitForElement(search, ObjectReader.reader.getImplicitWait());
		log.info("PaytmMall Page Object created");
		new TestBase().getNavigationScreen(driver);
	}
	
	public Mens clickOnTopWear() throws IOException {
		log.info("Clicking on Top Wear");
		category(TOPWEARSTORE_CATEGORY).click();
		TestBase.logExtentReport("Clicked on Top Wear");
		return new Mens(driver);
	}
	
	public Mens clickOnTShirts() throws IOException {
		log.info("Clicking on TShirts");
		category(TSHIRTS_SUBCATEGORY).click();
		TestBase.logExtentReport("Clicked on TShirts");
		return new Mens(driver);
	}
	
	public Mens searchMensItem(String item) throws IOException, InterruptedException {
		search.sendKeys(item);
		Thread.sleep(6000);
		search.sendKeys(Keys.ENTER);
		wait.waitForElement(search, ObjectReader.reader.getImplicitWait());
		return new Mens(driver);
	}
	
}
