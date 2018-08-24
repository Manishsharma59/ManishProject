package com.uiFramework.companyName.projectName.helper.frame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class FrameHelper {
	private WebDriver driver;
	private static Logger log = LoggerHelper.getLogger(FrameHelper.class);

	public FrameHelper(WebDriver driver) {
		this.driver = driver;

	}
	/**
	 * Switch to frame on the basis of index
	 * @param index
	 */
	public void switchToFrame(int index) {

		driver.switchTo().frame(index);
		log.info("switch to frame "+index);
	}
/**
 * Switch to frame on the basis of frame name
 * @param name
 */
	public void switchToFrame(String name) {

		driver.switchTo().frame(name);
		log.info("switch to frame "+name);
	}
/**
 * Switch the frame on the basis of element in frame
 * @param element
 */
	public void switchToFrame(WebElement element) {

		driver.switchTo().frame(element);
		log.info("switch to frame "+element.toString());
	}
}
