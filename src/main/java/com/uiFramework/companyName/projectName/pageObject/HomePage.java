package com.uiFramework.companyName.projectName.pageObject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.helpers.HeaderFooterHelper;
import org.openqa.selenium.By;
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
	
	public WebElement CategoryElement(String categoryName) {
		return driver.findElement(By.xpath("//*[text()='"+categoryName+"']"));
	}
	
	public HomePage(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WaitHelper(driver);
		wait.waitForElement(logInSignUp, ObjectReader.reader.getImplicitWait());
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
	
	public Mens clickOnCategory(String categoryName) throws IOException {
		CategoryElement(categoryName).click();
		return new Mens(driver);
	}
	
	public Womens clickOnWomenCategory() throws IOException {
		CategoryElement(WOMEN);
		return new Womens(driver);
	}

}
