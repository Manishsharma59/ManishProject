package com.uiFramework.companyName.projectName.helper.wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class WaitHelper {
	
	private Logger log = LoggerHelper.getLogger(WaitHelper.class);
	private WebDriver driver;
	
	public WaitHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	/**
	 * This is ImplicitWait Method
	 * @param timeOut
	 * @param unit
	 */
	public void setImplicitWait(long timeOut, TimeUnit unit) {
		log.info("ImplicitWait has been set to "+timeOut+" "+unit);
		driver.manage().timeouts().implicitlyWait(timeOut, unit);
	}
	/**
	 * This method will ensure for page load
	 * @param timeOutInSeconds
	 * @param unit
	 */
	public void pageLoadTimeOut(int timeOutInSeconds, TimeUnit unit) {
		log.info("waiting for page to load for : "+ unit+ " seconds");	
		driver.manage().timeouts().pageLoadTimeout(timeOutInSeconds, unit);
		log.info("page is loaded");
	}
	
	/**
	 * This method will help to get WebDriverWait object
	 * @param timeOutInSeconds
	 * @param PollingEveryInMiliSec
	 * @return
	 */
	private WebDriverWait getWait(int timeOutInSeconds, int PollingEveryInMiliSec) {
		
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
		wait.pollingEvery(PollingEveryInMiliSec, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
		
	}
	
	/**
	 * This method will make sure element is visible
	 * @param element
	 * @param timeOutInSeconds
	 * @param PollingEveryInMiliSec
	 */
	public void waitForElementVisible(WebElement element,int timeOutInSeconds,int PollingEveryInMiliSec) {
		log.info("Waiting for element "+element.toString()+" for "+timeOutInSeconds+" seconds");
		WebDriverWait wait = getWait(timeOutInSeconds, PollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("Element is visisble now");
	}
	
	/**
	 * This method will make sure element to be click able
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForElementClickable(WebElement element,int timeOutInSeconds) {
		log.info("Waiting for element "+element.toString()+" for "+timeOutInSeconds+" seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("Element is visisble now");
	}
	
	/**
	 * This method make sure element is not present
	 * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	public boolean waitForElementNotPresent(WebElement element,int timeOutInSeconds ) {
		log.info("Waiting for element "+element.toString()+" for "+timeOutInSeconds+" seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("Element is visisble now");
		return status;
	}
	
	/**
	 * This method will wait for frameToBeAvailableAndSwitchToIt 
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForframeToBeAvailableAndSwitchToIt(WebElement element, int timeOutInSeconds) {
		log.info("Waiting for element "+element.toString()+" for "+timeOutInSeconds+" seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("Frame is available and switched to it");
	}
	/**
	 * This method will return us fluent wait
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 * @return
	 */
	public FluentWait<WebDriver> getFluentWait(int timeOutInSeconds,int pollingEveryInMiliSec){
		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(timeOutInSeconds,TimeUnit.SECONDS)
				.pollingEvery(pollingEveryInMiliSec,TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);
		return  fWait;
		
	}
	/**
	 * This method will return web element after checking visibility
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 * @return
	 */
	
	public WebElement waitForElementWithFluentWait(WebElement element,int timeOutInSeconds,int pollingEveryInMiliSec) {
		FluentWait<WebDriver> fWait = getFluentWait(timeOutInSeconds, pollingEveryInMiliSec);
		fWait.until(ExpectedConditions.visibilityOf(element));
		return element;
		
	}
	
	/**
	 * This method will wait for Element using WebDriverWait without polling
	 * @param element
	 * @param timeOutInSeconds
	 */
	
	public void waitForElement(WebElement element, int timeOutInSeconds) {
		log.info("Waiting for element "+element.toString()+" for "+timeOutInSeconds+" seconds");
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("Element is visisble now");
	}
	
	
}
