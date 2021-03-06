package com.uiFramework.companyName.projectName.testScript;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.uiFramework.companyName.projectName.helper.assertion.AssertionHelper;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.generic.Category;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.pageObject.Cart;
import com.uiFramework.companyName.projectName.pageObject.HomePage;
import com.uiFramework.companyName.projectName.pageObject.LoginPage;
import com.uiFramework.companyName.projectName.pageObject.Mens;
import com.uiFramework.companyName.projectName.pageObject.NavigationMenu;
import com.uiFramework.companyName.projectName.pageObject.PaytmMall;
import com.uiFramework.companyName.projectName.pageObject.SignUpPage;
import com.uiFramework.companyName.projectName.testbase.TestBase;

public class Paytm extends TestBase{
	
	
	HomePage homePage;
	LoginPage loginPage;
	SignUpPage signUpPage;
	PaytmMall paytmMall;
	Mens mens;
	Cart cart;
	NavigationMenu navigation;
	/**
	 * This method will used to login
	 * @throws IOException
	 * @throws InterruptedException
	 */
	//@Test(priority = 0,description="Login test with invalid credentials")
	public void loginPatym() throws IOException, InterruptedException {
		getApplicationUrl(ObjectReader.reader.getURL());
		homePage = new HomePage(driver);
		loginPage = homePage.clickOnLogInOrSignUp();
		loginPage.login();
	}
	/**
	 * This method will used to sign up
	 * @throws IOException
	 * @throws InterruptedException
	 */
	//@Test(priority = 1,description="Sign up test with invalid details")
	public void signUp() throws IOException, InterruptedException {
		getApplicationUrl(ObjectReader.reader.getURL());
		homePage = new HomePage(driver);
		loginPage = homePage.clickOnLogInOrSignUp();
		signUpPage = loginPage.clickOnSignUp();
		signUpPage.signUp();
	}
	/**
	 * This method will ensure that item is sorted on the basis of price, Low to high
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	
	//@Test(priority = 2,description="Verify sorted list by low price")
	public void verifyPriceListSortedByLowPrice() throws IOException, InterruptedException {
		getApplicationUrl(ObjectReader.reader.getURL());
		homePage = new HomePage(driver);
		paytmMall = homePage.clickOnMenCategory();
		mens = paytmMall.clickOnTShirts();
		mens.searchMensItem("T-Shirts");
		boolean flag = mens.sortedLowPrice();
		Assert.assertTrue(flag,"Filter sorted ok");
		AssertionHelper.verifyTrue(flag);
	}
	
	
	/**
	 * This method will ensure that item is sorted on the basis of price, High to low
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	
	//@Test(priority = 3,description="Verify sorted list by high price")
	public void verifyPriceListSortedByHighPrice() throws IOException, InterruptedException {
		getApplicationUrl(ObjectReader.reader.getURL());
		homePage = new HomePage(driver);
		paytmMall = homePage.clickOnMenCategory();
		mens = paytmMall.clickOnTShirts();
		mens.searchMensItem("T-Shirts");
		boolean flag = mens.sortedHighPrice();
		AssertionHelper.verifyTrue(flag);
	}
	
	/**
	 * This method will ensure that item is filtered on the basis of price range
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	//@Test(priority = 4,description="Verify filter price range")
	public void verifyPriceFilterRange() throws IOException, InterruptedException {
		getApplicationUrl(ObjectReader.reader.getURL());;
		homePage = new HomePage(driver);
		paytmMall = homePage.clickOnMenCategory();
		mens = paytmMall.clickOnTShirts();
		mens.searchMensItem("T-Shirts");
		boolean flag = mens.checkPriceFilterRange(Category.MinRange, Category.MaxRange);
		AssertionHelper.verifyTrue(flag);
	}
	
	/**
	 * This method will ensure that item is filtered on the basis of brand
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	//@Test(priority = 5,description="Verify brand filter")
	public void verifyBrandFilter() throws IOException, InterruptedException {
		getApplicationUrl(ObjectReader.reader.getURL());;
		homePage = new HomePage(driver);
		paytmMall = homePage.clickOnMenCategory();
		mens = paytmMall.clickOnTShirts();
		mens.searchMensItem("T-Shirts");
		boolean flag = mens.checkBrandFilter(Category.BrandName1);
		AssertionHelper.verifyTrue(flag);
	}
	
	/**
	 * This method will ensure that item is filtered on the basis of multiple brand
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	//@Test(priority = 5,description="Verify multiple brand filter")
	public void verifyMultipleBrandFilter() throws IOException, InterruptedException {
		getApplicationUrl(ObjectReader.reader.getURL());;
		homePage = new HomePage(driver);
		paytmMall = homePage.clickOnMenCategory();
		mens = paytmMall.clickOnTShirts();
		mens.searchMensItem("T-Shirts");
		boolean flag = mens.checkBrandFilter(Category.BrandName1,Category.BrandName2,Category.BrandName3);
		AssertionHelper.verifyTrue(flag);
	}
	/**
	 * This method will ensure that item is filtered on the basis of multiple brand
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	//@Test(priority = 6,description="Verify Discount Price")
	public void verifyDiscountPrice() throws IOException, InterruptedException {
		getApplicationUrl(ObjectReader.reader.getURL());
		homePage = new HomePage(driver);
		paytmMall = homePage.clickOnMenCategory();
		mens = paytmMall.clickOnTShirts();
		mens.searchMensItem("T-Shirts");
		boolean flag = mens.verifyDiscount();
		AssertionHelper.verifyTrue(flag);
	}
	
	//@Test(priority = 7,description="Verify Size Filter")
	public void verifySizeFilter() throws IOException, InterruptedException {
		getApplicationUrl(ObjectReader.reader.getURL());;
		homePage = new HomePage(driver);
		paytmMall = homePage.clickOnMenCategory();
		mens = paytmMall.clickOnTShirts();
		mens.searchMensItem("T-Shirts");
		boolean flag = mens.checkSizeFilter(34,36,38);
		AssertionHelper.verifyTrue(flag);
	}
	
	//@Test(priority = 8,description="Verify General details")
	public void verifyGeneralDetails() throws IOException, InterruptedException {
		getApplicationUrl(ObjectReader.reader.getURL());;
		homePage = new HomePage(driver);
		paytmMall = homePage.clickOnMenCategory();
		mens = paytmMall.clickOnTShirts();
		mens.searchMensItem("T-Shirts");
		boolean flag = mens.checkGeneralOverview("RIGO", "XXL", "Cotton", "Green", "Solid", "Full Sleeves", "Round Neck");
		AssertionHelper.verifyTrue(flag);
	}
	
	@Test(priority = 8,description="Verify remove item details")
	public void verifyItemRemove() throws IOException, InterruptedException {
		getApplicationUrl(ObjectReader.reader.getURL());;
		homePage = new HomePage(driver);
		paytmMall = homePage.clickOnMenCategory();
		mens = paytmMall.clickOnTShirts();
		Thread.sleep(2000);
		mens.searchMensItem("T-Shirts");
		mens.selectItem(0);
		cart = mens.clickOnBuy();
		paytmMall = cart.clickOnContinueShopping();
		Thread.sleep(2000);
		mens = paytmMall.searchMensItem("T-Shirts");
		mens.selectItem(1);
		cart = mens.clickOnBuy();
		cart.clickOnRemove(0);
		cart.clickOnRemoveConfirmationYes();
		cart.clickOnRemove(1);
		cart.clickOnRemoveConfirmationYes();
		boolean flag = cart.checkCartEmpty();
		AssertionHelper.verifyTrue(flag);
	}
	
}