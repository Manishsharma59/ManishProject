package com.uiFramework.companyName.projectName.pageObject;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.select.DropDownHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.testbase.TestBase;

public class SearchCategoryWiseItem {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(SearchCategoryWiseItem.class);
	WaitHelper wait;
	DropDownHelper dropDownHelper;
	
	
	@FindBy(xpath="//input[@type='search']")
	public WebElement search;
	
	@FindBy(css="select._1Bqn")
	public WebElement selectCategoryFromDropDown;

	public SearchCategoryWiseItem(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitHelper(driver);
		wait.waitForElement(search, ObjectReader.reader.getImplicitWait());
		log.info("SearchCategoryWiseItem class Object created");
		new TestBase().getNavigationScreen(driver);
	}
	
	public Mens searchMensItem(String item) throws IOException, InterruptedException {
		dropDownHelper = new DropDownHelper(driver);
		dropDownHelper.selectUsingVisibleText(selectCategoryFromDropDown, "Men's Fashion");
		search.clear();
		search.sendKeys(item);
		Thread.sleep(6000);
		search.sendKeys(Keys.ENTER);
		wait.waitForElement(search, ObjectReader.reader.getImplicitWait());
		return new Mens(driver);
	}
	
	public Womens searchWomensItem(String item) throws IOException, InterruptedException {
		dropDownHelper = new DropDownHelper(driver);
		dropDownHelper.selectUsingVisibleText(selectCategoryFromDropDown, "Women's Fashion");
		search.clear();
		search.sendKeys(item);
		Thread.sleep(6000);
		search.sendKeys(Keys.ENTER);
		wait.waitForElement(search, ObjectReader.reader.getImplicitWait());
		return new Womens(driver);
	}
	
	public Electronics searchElectronicsItem(String item) throws IOException, InterruptedException {
		dropDownHelper = new DropDownHelper(driver);
		dropDownHelper.selectUsingVisibleText(selectCategoryFromDropDown, "Electronics");
		search.clear();
		search.sendKeys(item);
		Thread.sleep(6000);
		search.sendKeys(Keys.ENTER);
		wait.waitForElement(search, ObjectReader.reader.getImplicitWait());
		return new Electronics(driver);
	}
	
	public HomeKitchen searchHomeKitchenItem(String item) throws IOException, InterruptedException {
		dropDownHelper = new DropDownHelper(driver);
		dropDownHelper.selectUsingVisibleText(selectCategoryFromDropDown, "Home & Kitchen");
		search.clear();
		search.sendKeys(item);
		Thread.sleep(6000);
		search.sendKeys(Keys.ENTER);
		wait.waitForElement(search, ObjectReader.reader.getImplicitWait());
		return new HomeKitchen(driver);
	}
	
	public MobileAccessories searchMobileAccessoriesItem(String item) throws IOException, InterruptedException {
		dropDownHelper = new DropDownHelper(driver);
		dropDownHelper.selectUsingVisibleText(selectCategoryFromDropDown, "Mobile & Accessories");
		search.clear();
		search.sendKeys(item);
		Thread.sleep(6000);
		search.sendKeys(Keys.ENTER);
		wait.waitForElement(search, ObjectReader.reader.getImplicitWait());
		return new MobileAccessories(driver);
	}
	
	public BabyKidsToys searchBabyKidsToysItem(String item) throws IOException, InterruptedException {
		dropDownHelper = new DropDownHelper(driver);
		dropDownHelper.selectUsingVisibleText(selectCategoryFromDropDown, "Baby, Kids & Toys");
		search.clear();
		search.sendKeys(item);
		Thread.sleep(6000);
		search.sendKeys(Keys.ENTER);
		wait.waitForElement(search, ObjectReader.reader.getImplicitWait());
		return new BabyKidsToys(driver);
	}
	public Stationery searchStationeryItem(String item) throws IOException, InterruptedException {
		dropDownHelper = new DropDownHelper(driver);
		dropDownHelper.selectUsingVisibleText(selectCategoryFromDropDown, "Stationery");
		search.clear();
		search.sendKeys(item);
		Thread.sleep(6000);
		search.sendKeys(Keys.ENTER);
		wait.waitForElement(search, ObjectReader.reader.getImplicitWait());
		return new Stationery(driver);
	}
	public Automotive searchAutomotiveItem(String item) throws IOException, InterruptedException {
		dropDownHelper = new DropDownHelper(driver);
		dropDownHelper.selectUsingVisibleText(selectCategoryFromDropDown, "Automotive");
		search.clear();
		search.sendKeys(item);
		Thread.sleep(6000);
		search.sendKeys(Keys.ENTER);
		wait.waitForElement(search, ObjectReader.reader.getImplicitWait());
		return new Automotive(driver);
	}
	public SportsHealth searchSportsHealthItem(String item) throws IOException, InterruptedException {
		dropDownHelper = new DropDownHelper(driver);
		dropDownHelper.selectUsingVisibleText(selectCategoryFromDropDown, "SportsHealth");
		search.clear();
		search.sendKeys(item);
		Thread.sleep(6000);
		search.sendKeys(Keys.ENTER);
		wait.waitForElement(search, ObjectReader.reader.getImplicitWait());
		return new SportsHealth(driver);
	}
	public CarsBikes searchCarsBikesItem(String item) throws IOException, InterruptedException {
		dropDownHelper = new DropDownHelper(driver);
		dropDownHelper.selectUsingVisibleText(selectCategoryFromDropDown, "Cars & Bikes");
		search.clear();
		search.sendKeys(item);
		Thread.sleep(6000);
		search.sendKeys(Keys.ENTER);
		wait.waitForElement(search, ObjectReader.reader.getImplicitWait());
		return new CarsBikes(driver);
	}
	public Supermarket searchSupermarketItem(String item) throws IOException, InterruptedException {
		dropDownHelper = new DropDownHelper(driver);
		dropDownHelper.selectUsingVisibleText(selectCategoryFromDropDown, "Supermarket");
		search.clear();
		search.sendKeys(item);
		Thread.sleep(6000);
		search.sendKeys(Keys.ENTER);
		wait.waitForElement(search, ObjectReader.reader.getImplicitWait());
		return new Supermarket(driver);
	}
	

}
