package com.uiFramework.companyName.projectName.helper.javaScript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class JavaScriptHelper {

	private Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);
	private WebDriver driver;

	public JavaScriptHelper(WebDriver driver) {
		this.driver = driver;
		log.info("JavaScriptHelper has been initialised");
	}

	/**
	 * This method will return Object
	 * 
	 * @param script
	 * @return
	 */
	public Object executeScript(String script) {

		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script);

	}

	/**
	 * This method will return Object
	 * 
	 * @param script
	 * @param args
	 * @return
	 */

	public Object executeScript(String script, Object... args) {

		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script);

	}

	/**
	 * This method will scroll to Element
	 * 
	 * @param element
	 */
	public void scrollToElement(WebElement element) {
		log.info("Scroll to web element");
		executeScript("window.scrollTo(arguments[0],argument[1])", element.getLocation().x, element.getLocation().y);

	}

	/**
	 * This method will scroll to element and click
	 * 
	 * @param element
	 */
	public void scrollToElementAndClick(WebElement element) {

		scrollToElement(element);
		element.click();
		log.info("Element clicked " + element.toString());
	}

	/**
	 * This method will scroll to element
	 * 
	 * @param element
	 */
	public void scrollIntoView(WebElement element) {
		executeScript("argument[0].scrollIntoView()", element);
	}

	/**
	 * This method will scroll to element and click
	 * 
	 * @param element
	 */

	public void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
		log.info("Element clicked " + element.toString());
	}

	/**
	 * This method will scroll down vertically
	 */

	public void scrollDownVertically() {
		log.info("Scrolling down vertically");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	/**
	 * This method will scroll up vertically
	 */
	public void scrollUpVertically() {
		log.info("Scrolling up vertically");
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	
	/**
	 * This method will scroll down by pixel
	 * @param pixel
	 */
	public void scrollDownByPixel(int pixel) {
		log.info("Scrolling down by pixel");
		executeScript("window.scrollTo(0,"+pixel+")");
	}

	/**
	 * This method will scrool up by pixel-
	 * @param pixel
	 */
	public void scrollUpByPixel(int pixel) {
		log.info("Scrolling up by pixel");
		executeScript("window.scrollTo(0,-"+pixel+")");
	}
	/**
	 * This method will zoom page by 100%
	 */
	public void zoomInBy100Percentage() {
		log.info("Page zoomed 100%");
		executeScript("document.body.style.zoom='100%'");
	}
	
	/**
	 * This will zoom the page by percentage value
	 * @param percentage
	 */
	
	public void zoomInByPercentage(int percentage) {
		log.info("Page zoomed by percentage"+percentage+"%");
		executeScript("document.body.style.zoom='"+percentage+"'");
	}
	
	/**
	 * This method will click on element using java script method
	 * @param element
	 */
	public void clickElement(WebElement element) {
		executeScript("document[0].click()",element);
		log.info("click on element "+element.toString());
	}
}
