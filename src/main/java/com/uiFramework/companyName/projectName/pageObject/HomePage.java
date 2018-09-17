package com.uiFramework.companyName.projectName.pageObject;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.helpers.HeaderFooterHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.frame.FrameHelper;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.testbase.TestBase;

public class HomePage {
	
	private static final String GROCERY = "Grocery";
	private static final String MEN = "Men";
	private static final String WOMEN = "Women";
	private static final String MOBILES = "Mobiles";
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(HomePage.class);
	WaitHelper wait;
	FrameHelper frame;
	
	@FindBy(css="div._3ac-")
	public WebElement logInSignUp;
	
	
	@FindBy(xpath="//*[contains(text(),'Log In/Sign Up')]")
	public WebElement logInSignUpText;
	
	@FindBy(xpath="//input[@type='search']")
	public WebElement search;
	
	public WebElement superCategoryElement(String categoryName) {
		return driver.findElement(By.xpath("//*[text()='"+categoryName+"']"));
	}
	
	
	
	public HomePage(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WaitHelper(driver);
		wait.waitForElement(search, ObjectReader.reader.getImplicitWait());
		log.info("HomePage Object created");
		new TestBase().getNavigationScreen(driver);
		
	}

	public LoginPage clickOnLogInOrSignUp() throws IOException, InterruptedException{
		Thread.sleep(2000);
		logInSignUp.click();
		new FrameHelper(driver).switchToFrame(0);
		log.info("Clicked on login/Sign up");
		TestBase.logExtentReport("Clicked on login/Sign up "+logInSignUp.toString());
		return new LoginPage(driver);
	}
	
	public Mens searchMensItem(String item) throws IOException, InterruptedException {
		search.clear();
		search.sendKeys(item);
		Thread.sleep(6000);
		search.sendKeys(Keys.ENTER);
		return new Mens(driver);
	}
	
	public PaytmMall clickOnMenCategory() throws IOException {
		log.info("Click on Men Category");
		superCategoryElement(MEN).click();
		TestBase.logExtentReport("Click on Men Category");
		return new PaytmMall(driver);
	}
	
	public PaytmMall clickOnWomenCategory() throws IOException {
		superCategoryElement(WOMEN);
		return new PaytmMall(driver);
	}

}