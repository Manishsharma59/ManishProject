package com.uiFramework.companyName.projectName.pageObject;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.frame.FrameHelper;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.testbase.TestBase;

public class Mens {

	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(HomePage.class);
	WaitHelper wait;
	FrameHelper frame;
	
	@FindBy(xpath="//*[text()='Topwear Store']")
	public WebElement topwearStore;
	
	
	@FindBy(xpath="//*[text()='T - Shirts']")
	public WebElement tShirts;
	
	
	@FindBy(xpath="//*[text()='Price']")
	public WebElement priceFilter;
	
	@FindBy(xpath="//*[text()='Brand']")
	public WebElement brandFilter;
	
	@FindBy(xpath="//*[text()='Color']")
	public WebElement colorFilter;
	
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
	
	
	public WebElement category(String category) {
		return driver.findElement(By.xpath("//*[text()='category']"));
	}
	
	public Mens(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WaitHelper(driver);
		wait.waitForElement(topwearStore, ObjectReader.reader.getImplicitWait());
		log.info("Mens class Object created");
		new TestBase().getNavigationScreen(driver);	
	}
	
	public void clickOnTopWear() {
		log.info("Clicking on Top Wear");
		category("Top Wear").click();
		TestBase.logExtentReport("Clicked on Top Wear");
	}
	
	public void clickOnTShirts() {
		log.info("Clicking on TShirts");
		category("TShirts").click();
		TestBase.logExtentReport("Clicked on TShirts");
	}
	
	public void clickOnPriceFilter() {
		log.info("Clicking on price filter");
		priceFilter.click();
		TestBase.logExtentReport("Clicked on price filter");
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
	
	public boolean sortedLowPrice() throws InterruptedException, IOException {
		clickOnTopWear();
		clickOnTShirts();
		NavigationMenu navigationMenu = new NavigationMenu(driver);
		Thread.sleep(2000);
		navigationMenu.mouseOverCss("div._32-f");
		Thread.sleep(2000);
		navigationMenu.clickOnMouseOverOption("Low Price");
		Thread.sleep(2000);
		boolean flag = true;
		List<WebElement> ruppeeList = listOfPriceWebelements;
		for(int i=0;i<= ruppeeList.size()-2;i++) {
			int first = Integer.parseInt(ruppeeList.get(i).getText());
			int second = Integer.parseInt(ruppeeList.get(i+1).getText());
			if(first<=second) {
			flag = true;
		}
			else {
				flag = false;
			break;
			}
		}
		return flag;
	}
	
	public boolean sortedHighPrice() throws InterruptedException, IOException {
		clickOnTopWear();
		clickOnTShirts();
		NavigationMenu navigationMenu = new NavigationMenu(driver);
		Thread.sleep(2000);
		navigationMenu.mouseOverCss("div._32-f");
		Thread.sleep(2000);
		navigationMenu.clickOnMouseOverOption("Low Price");
		Thread.sleep(2000);
		boolean flag = true;
		List<WebElement> ruppeeList = listOfPriceWebelements;
		for(int i=0;i<= ruppeeList.size()-2;i++) {
			int first = Integer.parseInt(ruppeeList.get(i).getText());
			int second = Integer.parseInt(ruppeeList.get(i+1).getText());
			if(first>=second) {
			flag = true;
		}
			else {
				flag = false;
			break;
			}
		}
		return flag;
	}
	
	
	public boolean checkPriceFilterRange(String min,String max) throws InterruptedException {
		clickOnTopWear();
		clickOnTShirts();
		clickOnPriceFilter();
		Thread.sleep(2000);
		enterMinPrice(min);
		Thread.sleep(2000);
		enterMaxPrice(max);
		clickOnCloseFilter();
		Thread.sleep(2000);
		boolean flag = true;
		List<WebElement> ruppeeList = listOfPriceWebelements;
		for(int i=0;i<= ruppeeList.size()-1;i++) {
			int price = Integer.parseInt(ruppeeList.get(i).getText());
			if(price>=Integer.parseInt(min)&&price<=Integer.parseInt(max)) {
			flag = true;
		}
			else {
				flag = false;
			break;
			}
		}
		return flag;
	}
	
	public boolean checkBrandFilter(String brand) throws InterruptedException {
		boolean flag = true;
		clickOnTopWear();
		clickOnTShirts();
		Thread.sleep(2000);
		clickOnBrandFilter();
		Thread.sleep(2000);
		clickOncheckBox(brand);
		clickOnCloseFilter();
		Thread.sleep(2000);
		List<WebElement> brandNameList = listOfBrandNameWebElement;
		
		for(int i=0;i<= brandNameList.size()-1;i++) {
			String brandName = brandNameList.get(i).getText();
			System.out.println(brandName);
			if(brandName.contains(brand)) {
			flag = true;
		}
			else {
				flag = false;
			break;
			}
		}
		
		return flag;
	}
	
	public boolean checkBrandFilter(String brand1, String brand2, String brand3) throws InterruptedException {
		boolean flag = true;
		clickOnTopWear();
		clickOnTShirts();
		Thread.sleep(2000);
		clickOnBrandFilter();
		Thread.sleep(2000);
		clickOncheckBox(brand1);
		clickOncheckBox(brand2);
		searchBrand(brand3);
		clickOncheckBox(brand3);
		clickOnCloseFilter();
		Thread.sleep(2000);
		List<WebElement> brandNameList = listOfBrandNameWebElement;
		System.out.println(searchResultPageCount());
		for(int j=2;j<= searchResultPageCount();j++) {
		for(int i=0;i<= brandNameList.size()-1;i++) {
			String brandName = brandNameList.get(i).getText();
			System.out.println(brandName);
			if(brandName.contains(brand1)||brandName.contains(brand2)||brandName.contains(brand3)) {
			flag = true;
		}
			else {
				flag = false;
			break;
			}
		}
		clickOnNext(j);
		Thread.sleep(2000);
		}
		return flag;
	}
	
	public boolean verifyDiscount() throws InterruptedException, IOException {
		int offerPrice;
		String dicountAndPrice;
		String[] arr;
		int priceWithoutDiscount;
		int priceAfterDicount;
		int discountPercentage;
		int j=0;
		clickOnTopWear();
		clickOnTShirts();
		Thread.sleep(2000);
		boolean flag = true;
		List<WebElement> ruppeeList = listOfPriceWebelements;
		List<WebElement> discountList = listOfDiscountWebelements;
		List<WebElement> productDetailsList = productDetails;
		for(int i=0;i<= ruppeeList.size()-1;i++) {
			System.out.println(productDetailsList.get(i).getText());
			if(!(productDetailsList.get(i).getText().contains("%"))) {	
				
			}
			else {
				offerPrice = Integer.parseInt(ruppeeList.get(i).getText());
				dicountAndPrice = discountList.get(j).getText();
				System.out.println(dicountAndPrice);
				arr = dicountAndPrice.split("-");
				System.out.println(arr[0]);
				System.out.println(arr[1].substring(0, 2));
					priceWithoutDiscount=Integer.parseInt(arr[0]);
					discountPercentage = Integer.parseInt(arr[1].substring(0, 2));
					double calculation = priceWithoutDiscount - priceWithoutDiscount*discountPercentage/100;
					priceAfterDicount = (int)(calculation);
					System.out.println("priceWithoutDiscount -" +priceWithoutDiscount+" discountPercentage -"+discountPercentage+" priceAfterDicount -"+priceAfterDicount+"offerPrice -"+offerPrice);
				if(offerPrice<=priceAfterDicount+5||offerPrice<=priceAfterDicount-5) {
				flag = true;
			}
				else {
					flag = false;
				break;
				}
				j++;
			}
		}
		
		return flag;
		
	}
	
	
}
