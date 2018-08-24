package com.uiFramework.companyName.projectName.helper.window;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class WindowHelper {

	private Logger log = LoggerHelper.getLogger(WindowHelper.class);
	private WebDriver driver;

	public WindowHelper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method will switch to main window
	 */
	public void switchToParentWindow() {
		log.info("Switching to parent window");
		driver.switchTo().defaultContent();
	}

	/**
	 * This method will switch to window on the basis of index
	 * 
	 * @param index
	 */
	public void switchToWindow(int index) {

		Set<String> windows = driver.getWindowHandles();
		int i = 1;
		for (String window : windows) {
			if (i == index) {
				log.info("Switched to " +index+ " window");
				driver.switchTo().window(window);
			} else {
				i++;
			}
		}
	}

	/**
	 * This method will close all windows and switched to the main window
	 */
	public void closeAllTabsAndSwitchToMainWindow() {
		Set<String> windows = driver.getWindowHandles();
		String mainwindow = driver.getWindowHandle();
		for (String window : windows) {
			if (!window.equalsIgnoreCase(mainwindow)) {
				driver.close();
			}
		}
		log.info("All windows closed and switched into main window");
		driver.switchTo().window(mainwindow);
	}

	/**
	 * This will navigate the browser back
	 */
	public void navigateBack() {
		log.info("naviagte back");
		driver.navigate().back();
	}

	/**
	 * This will navigate the browser forward
	 */
	public void navigateForward() {
		log.info("naviagte forward");
		driver.navigate().forward();
	}
}
