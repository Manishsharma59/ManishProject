package com.uiFramework.companyName.projectName.pageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.testbase.TestBase;

public class Womens {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(Womens.class);
	WaitHelper wait;
	
	
	@FindBy(xpath="//*[text()='Price']")
	public WebElement priceFilter;
	
	@FindBy(xpath="//*[text()='Color']")
	public WebElement colorFilter;
	
	
	
	@FindBy(xpath="//*[text()='Brand']")
	public WebElement brandFilter;
	
	@FindBy(xpath="//*[text()='Material']")
	public WebElement materialFilter;
	
	@FindBy(xpath="//div[@class='_3GrL']/input")
	public WebElement minPrice;
	
	@FindBy(xpath="//div[@class='_3GrL uC94']/input")
	public WebElement maxPrice;
	
	@FindBy(css="div._3ysI")
	public WebElement closeIcon;
	
	@FindBy(css="span._1kMS")
	public List<WebElement> listOfPriceWebelements;
	
	@FindBy(xpath="//div[@class=\"dQm2\"]")
	public List<WebElement> listOfDiscountWebelements;
	
	@FindBy(css="div._2apC")
	public List<WebElement> listOfBrandNameWebElement;
	
	@FindBy(xpath="//div[@class='pCOS']")
	public List<WebElement> productDetails;
	
	@FindBy(xpath = "//input[@class='Q1U0']")
	WebElement searchBrand;
	
	@FindBy(xpath = "//span[@class='_34iq bq4I']")
	WebElement clearAll;
	
	@FindBy(xpath = "//li[@class='_2TzX']/preceding::li[1]")
	WebElement noOfSearchResultPages;
	
	@FindBy(xpath = "//li[@class='_2TzX']")
	WebElement nextButton;

	public Womens(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		log.info("Womens class Object created");
	}
	
	public void clickOnPriceFilter() {
		log.info("Clicking on price filter");
		priceFilter.click();
		TestBase.logExtentReport("Clicked on price filter");
	}
	
	public void clickOnColorFilter() {
		log.info("Clicking on color filter");
		colorFilter.click();
		TestBase.logExtentReport("Clicked on color filter");
	}
	
	public void clickOnMaterialFilter() {
		log.info("Clicking on material filter");
		materialFilter.click();
		TestBase.logExtentReport("Clicked on material filter");
	}
	
	public void clickOnBrandFilter() {
		log.info("Clicking on brand filter");
		wait.waitForElement(brandFilter, ObjectReader.reader.getImplicitWait());
		brandFilter.click();
		TestBase.logExtentReport("Clicked on brand filter");
	}
	
	public void enterMinPrice(String min) {
		log.info("entering min price "+min);
		wait.waitForElement(minPrice, ObjectReader.reader.getImplicitWait());
		minPrice.clear();
		minPrice.sendKeys(min);
		TestBase.logExtentReport("entering min price");
	}
	
	public void enterMaxPrice(String max) {
		log.info("entering on max price "+max);
		wait.waitForElement(maxPrice, ObjectReader.reader.getImplicitWait());
		maxPrice.clear();
		maxPrice.sendKeys(max);
		TestBase.logExtentReport("entering on max price");
	}
	
	public void clickOnCloseFilter() {
		log.info("click on close price range box");
		closeIcon.click();
		wait.waitForElement(clearAll, ObjectReader.reader.getImplicitWait());
		TestBase.logExtentReport("click on close price range box");
	}
	
	public void searchBrand(String brand) {
		log.info("Search brand by name " +brand);
		searchBrand.clear();
		searchBrand.sendKeys(brand);
		TestBase.logExtentReport("Search brand by name "+brand);
	}
	
	public void clickOnNext(int page) {
		log.info("click on next button "+page);
		nextButton.click();
		TestBase.logExtentReport("click on next page "+page);
	}
	
	public int searchResultPageCount() {
		if(noOfSearchResultPages.isDisplayed()) {
		return Integer.parseInt(noOfSearchResultPages.getText());
		}
		else {
			return 2;
		}
	}
	
	public WebElement checkBox(String data) {
		return driver.findElement(By.xpath("//*[text()='"+data+"']/preceding::span[@class='check'][1]"));
	}
	
	public void clickOncheckBox(String data) {
		if(checkBox(data).isSelected()) {
			
		}
		else {
			checkBox(data).click();
		}
	}
	
	
}
