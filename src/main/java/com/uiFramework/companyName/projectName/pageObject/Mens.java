package com.uiFramework.companyName.projectName.pageObject;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
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
	private Logger log = LoggerHelper.getLogger(Mens.class);
	WaitHelper wait;
	FrameHelper frame;
	NavigationMenu navigationMenu;
	
	public static final String PRICE_FILTER = "Price";
	public static final String Brand_FILTER = "Brand";
	public static final String Size_FILTER = "Size";
	public static final String Material_FILTER = "Material";
	public static final String Color_FILTER = "Color";
	public static final String Sleeve_FILTER = "Sleeve";
	public static final String NeckType_FILTER = "Neck Type";
	public static final String Pattern_FILTER = "Pattern";
	public static final String AuthorisedMerchant_FILTER = "Authorised Merchant";
	public static final String FulfilledByPaytm_FILTER = "Fulfilled By Paytm";
	public static final String Length_FILTER = "length";
	public static final String SetContent_FILTER = "Set Content";

	
	@FindBy(xpath="//input[@type='search']")
	public WebElement search;
	
	@FindBy(xpath = "//span[contains(@class,'_2Ysz')]")
	WebElement searchIcon;
	
	@FindBy(xpath="//a[@class='_36-R']")
	public WebElement orders;
	
	@FindBy(xpath="//a[@class='Tk9i']")
	public WebElement mensFashion;
	
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
	
	@FindBy(xpath = "//a[@class='_1Kbo _24ml']")
	WebElement selectedSize;

	@FindBy(xpath = "//*[text()='Size']/following::div[1]")
	WebElement selectedSizeInGeneral;
	
	@FindBy(xpath = "//button[@class='_2EmN']")
	WebElement moreButton;
	
	@FindBy(css = "button._2CNI")
	WebElement buy;
	
	
	  public WebElement filter(String filter) { 			
				               return driver.findElement(By.xpath("//*[text()='" + filter + "']")); 			
			   }
	  
	  public WebElement productGeneralDetails(String detail) { 			
          return driver.findElement(By.xpath("//*[text()='"+detail+"']/following::div[@class='_2LOI'][1]")); 			
}
	
	public Mens(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WaitHelper(driver);
		wait.waitForElement(search, ObjectReader.reader.getImplicitWait());
		log.info("Mens class Object created");
		new TestBase().getNavigationScreen(driver);	
	}
	
	
	
	
	public void clickOnPriceFilter() {
		log.info("Clicking on price filter");
		filter(PRICE_FILTER).click();
		TestBase.logExtentReport("Clicked on price filter");
	}
	
	public void clickOnBrandFilter() {
		log.info("Clicking on brand filter");
		wait.waitForElement(filter(Brand_FILTER), ObjectReader.reader.getImplicitWait());
		filter(Brand_FILTER).click();
		TestBase.logExtentReport("Clicked on brand filter");
	}
	
	public void clickOnSizeFilter() {
		log.info("Clicking on Size filter");
		wait.waitForElement(filter(Size_FILTER), ObjectReader.reader.getImplicitWait());
		filter(Size_FILTER).click();
		TestBase.logExtentReport("Clicked on Size filter");
	}

	public void clickOnMaterialFilter() {
		log.info("Clicking on Material filter");
		wait.waitForElement(filter(Material_FILTER), ObjectReader.reader.getImplicitWait());
		filter(Material_FILTER).click();
		TestBase.logExtentReport("Clicked on Material filter");
	}

	public void clickOnColorFilter() {
		log.info("Clicking on Color filter");
		wait.waitForElement(filter(Color_FILTER), ObjectReader.reader.getImplicitWait());
		filter(Color_FILTER).click();
		TestBase.logExtentReport("Clicked on Color filter");
	}

	public void clickOnSleeveFilter() {
		log.info("Clicking on Sleeve filter");
		wait.waitForElement(filter(Sleeve_FILTER), ObjectReader.reader.getImplicitWait());
		filter(Sleeve_FILTER).click();
		TestBase.logExtentReport("Clicked on Sleeve filter");
	}

	public void clickOnNeckTypeFilter() {
		log.info("Clicking on Neck Type filter");
		wait.waitForElement(filter(NeckType_FILTER), ObjectReader.reader.getImplicitWait());
		filter(NeckType_FILTER).click();
		TestBase.logExtentReport("Clicked on Neck Type filter");
	}

	public void clickOnPatternFilter() {
		log.info("Clicking on Pattern filter");
		wait.waitForElement(filter(Pattern_FILTER), ObjectReader.reader.getImplicitWait());
		filter(Pattern_FILTER).click();
		TestBase.logExtentReport("Clicked on Pattern filter");
	}

	public void clickOnAuthorisedMerchantFilter() {
		log.info("Clicking on Authorised Merchant filter");
		wait.waitForElement(filter(AuthorisedMerchant_FILTER), ObjectReader.reader.getImplicitWait());
		filter(AuthorisedMerchant_FILTER).click();
		TestBase.logExtentReport("Clicked on Authorised Merchant filter");
	}

	public void clickOnFulfilledByPaytmFilter() {
		log.info("Clicking on Ful filled By Paytm filter");
		wait.waitForElement(filter(FulfilledByPaytm_FILTER), ObjectReader.reader.getImplicitWait());
		filter(FulfilledByPaytm_FILTER).click();
		TestBase.logExtentReport("Clicked on Ful filled By Paytm filter");
	}

	public void clickOnLengthFilter() {
		log.info("Clicking on Length filter");
		wait.waitForElement(filter(Length_FILTER), ObjectReader.reader.getImplicitWait());
		filter(Length_FILTER).click();
		TestBase.logExtentReport("Clicked on Length filter");
	}

	public void clickOnSetContentFilter() {
		log.info("Clicking on Set Content filter");
		wait.waitForElement(filter(SetContent_FILTER), ObjectReader.reader.getImplicitWait());
		filter(SetContent_FILTER).click();
		TestBase.logExtentReport("Clicked on Set Content filter");
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
	
	public void clickOnMoreButton() {
		if(moreButton.isDisplayed()) {
			try {
		log.info("click on more button ");
		moreButton.click();
		TestBase.logExtentReport("click on more page ");
			}catch(ElementNotVisibleException e) {
				e.printStackTrace();
			}
		}
		else {
			
		}
	}
	
	public void searchSize(String size) {
		log.info("Search brand by name " + size);
		searchBrand.clear();
		searchBrand.sendKeys(size);
		TestBase.logExtentReport("Search brand by name " + size);
	}
	
	public int searchResultPageCount() {
		if(!(noOfSearchResultPages.isDisplayed())) {
		return 2;
		}
		else {
			return Integer.parseInt(noOfSearchResultPages.getText());
		}
	}
	
	public void searchMensItem(String item) throws IOException, InterruptedException {
		search.sendKeys(item);
		Thread.sleep(6000);
		search.sendKeys(Keys.ENTER);
		wait.waitForElement(filter(Brand_FILTER), ObjectReader.reader.getImplicitWait());
		
	}
	
	public WebElement checkBox(String data) {
		return driver.findElement(By.xpath("//*[text()='"+data+"']/preceding::span[@class='check'][1]"));
	}
	
	public WebElement checkBox(int data) {
		return driver.findElement(By.xpath("//*[text()='" + data + "']/preceding::span[@class='check'][1]"));
	}
	
	public void clickOncheckBox(String data) {
		if(checkBox(data).isSelected()) {
			
		}
		else {
			checkBox(data).click();
		}
	}
	
	public void clickOncheckBox(int size1) {
		if (checkBox(size1).isSelected()) {

		} else {
			checkBox(size1).click();
		}
	}
	
	public Cart clickOnBuy() {
		log.info("click on buy");
		buy.click();
		TestBase.logExtentReport("click on buy");
		return new Cart(driver);
	}
	
	public boolean sortedLowPrice() throws InterruptedException, IOException {
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
	
	public boolean checkSizeFilter(int size1, int size2, int size3) throws InterruptedException, IOException {
		navigationMenu = new NavigationMenu(driver);
		boolean flag = true;
		
		Thread.sleep(2000);
		clickOnSizeFilter();
		Thread.sleep(2000);
		clickOncheckBox(size1);
		clickOncheckBox(size2);
		searchSize(Integer.toString(size3));
		Thread.sleep(2000);
		clickOncheckBox(size3);
		clickOnCloseFilter();
		Thread.sleep(2000);
		List<WebElement> productList = listOfBrandNameWebElement;
		System.out.println(searchResultPageCount());
		for (int j = 2; j <= searchResultPageCount(); j++) {
			for (int i = 0; i <= productList.size() - 1; i++) {
				productList.get(i).click();
				int sizeSelected = Integer.parseInt(selectedSize.getText());
				int sizeSelectedInGeneral = Integer.parseInt(selectedSizeInGeneral.getText());
				System.out.println("sizeSelected "+ sizeSelected+"sizeSelectedInGeneral "+sizeSelectedInGeneral);
				
				if (sizeSelected == size1 || sizeSelected == (size2)
						|| sizeSelected == (size3) && sizeSelectedInGeneral == size1 || sizeSelectedInGeneral == (size2)
						|| sizeSelectedInGeneral == (size3)) {
					flag = true;
				} else {
					flag = false;
					break;
				}

				navigationMenu.navigateBackward();
			}
			clickOnNext(j);
			Thread.sleep(2000);
		}
		return flag;
	}

	public boolean checkSizeFilter(String size1, String size2, String size3) throws InterruptedException, IOException {
		navigationMenu = new NavigationMenu(driver);
		boolean flag = true;

		Thread.sleep(2000);
		clickOnSizeFilter();
		Thread.sleep(2000);
		clickOncheckBox(size1);
		clickOncheckBox(size2);
		searchSize(size3);
		clickOncheckBox(size3);
		Thread.sleep(2000);
		clickOnCloseFilter();
		
		List<WebElement> productList = listOfBrandNameWebElement;
		System.out.println(searchResultPageCount());
		for (int j = 2; j <= searchResultPageCount(); j++) {
			for (int i = 0; i <= productList.size() - 1; i++) {
				productList.get(i).click();
				String sizeSelected = selectedSize.getText();
				System.out.println(sizeSelected);
				if (sizeSelected.equals(size1) || sizeSelected.equals(size2) || sizeSelected.equals(size3)) {
					flag = true;
				} else {
					flag = false;
					break;
				}

				navigationMenu.navigateBackward();
			}
			clickOnNext(j);
			Thread.sleep(2000);
		}
		return flag;
	}

	public boolean checkGeneralOverview(String brand,String size,String material,String color,String pattern, String sleeve,String neckType) throws InterruptedException, IOException {
		navigationMenu = new NavigationMenu(driver);
		boolean flag = true;
		Thread.sleep(2000);
		searchMensItem("T-shirts");
		clickOnMoreButton();
		Thread.sleep(2000);
		clickOnBrandFilter();
		clickOncheckBox(brand);
		clickOnCloseFilter();
		Thread.sleep(2000);
		clickOnSizeFilter();
		clickOncheckBox(size);
		clickOnCloseFilter();
		Thread.sleep(2000);
		clickOnMaterialFilter();
		clickOncheckBox(material);
		clickOnCloseFilter();
		Thread.sleep(2000);
		clickOnColorFilter();
		clickOncheckBox(color);
		clickOnCloseFilter();
		Thread.sleep(2000);
		clickOnPatternFilter();
		clickOncheckBox(pattern);
		clickOnCloseFilter();
		Thread.sleep(2000);
		clickOnSleeveFilter();
		clickOncheckBox(sleeve);
		clickOnCloseFilter();
		Thread.sleep(2000);
		clickOnNeckTypeFilter();
		clickOncheckBox(neckType);
		clickOnCloseFilter();
		
		List<WebElement> productList = productDetails;
		//for (int j = 2; j <= searchResultPageCount(); j++) {
			for (int i = 0; i <= productList.size() - 1; i++) {
				productList.get(i).click();
				String generalDetailsBrand = productGeneralDetails("Brand").getText();
				String generalDetailsSize = productGeneralDetails("Size").getText();
				String generalDetailsMaterial = productGeneralDetails("Material").getText();
				String generalDetailsColor = productGeneralDetails("Color").getText();
				String generalDetailsPattern = productGeneralDetails("Pattern").getText();
				String generalDetailsSleeve = productGeneralDetails("Sleeve").getText();
				String generalDetailsNeckType = productGeneralDetails("Neck Type").getText();
				System.out.println("generalDetailsBrand : "+generalDetailsBrand+" generalDetailsSize : "+generalDetailsSize+
						" generalDetailsMaterial : "+generalDetailsMaterial+
						" generalDetailsColor : "+generalDetailsColor+
						" generalDetailsPattern : "+generalDetailsPattern+
						" generalDetailsSleeve : "+generalDetailsSleeve+
						" generalDetailsNeckType : "+generalDetailsNeckType);
				if (generalDetailsBrand.equalsIgnoreCase(brand)&& generalDetailsSize.equalsIgnoreCase(size) && generalDetailsMaterial.equalsIgnoreCase(material)&&
						generalDetailsColor.equalsIgnoreCase(color)&& generalDetailsPattern.equalsIgnoreCase(pattern)&& generalDetailsSleeve.equalsIgnoreCase(sleeve)&& 
						generalDetailsNeckType.equalsIgnoreCase(neckType)) {
					flag = true;
				} else {
					flag = false;
					break;
				}

				navigationMenu.navigateBackward();
			}
			//clickOnNext(j);
			//Thread.sleep(2000);
		//}
		return flag;
	}

	public void selectItem(int itemNumber) {
		listOfPriceWebelements.get(itemNumber).click();
	}
	
}
