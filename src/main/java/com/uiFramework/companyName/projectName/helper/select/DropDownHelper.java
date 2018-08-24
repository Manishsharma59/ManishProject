package com.uiFramework.companyName.projectName.helper.select;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class DropDownHelper {

	private Logger log = LoggerHelper.getLogger(DropDownHelper.class);
	private WebDriver driver;

	public DropDownHelper(WebDriver driver) {
		this.driver = driver;
		log.info("DropDownHelper class object created");
	}

	public void selectUsingValue(WebElement element, String value) {
		Select select = new Select(element);
		log.info("Select by value and value is " + value);
		select.selectByValue(value);
	}

	public void selectUsingIndex(WebElement element, int index) {
		Select select = new Select(element);
		log.info("Select by index and index is " + index);
		select.selectByIndex(index);
	}

	public void selectUsingVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		log.info("Select by visible text and text is " + text);
		select.selectByVisibleText(text);
	}

	public void deselectUsingValue(WebElement element, String value) {
		Select select = new Select(element);
		log.info("Deselect by value and value is " + value);
		select.deselectByValue(value);
	}

	public void deselectUsingIndex(WebElement element, int index) {
		Select select = new Select(element);
		log.info("Deselect by index and index is " + index);
		select.deselectByIndex(index);
	}

	public void deselectUsingVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		log.info("Deselect by visible text and text is " + text);
		select.deselectByVisibleText(text);
	}

	public List<String> getAllDropDownData(WebElement element) {
		Select select = new Select(element);
		List<WebElement> elementList = select.getOptions();
		List<String> valueList = new LinkedList<String>();
		for (WebElement ele : elementList) {
			valueList.add(ele.getText());
		}
		return valueList;
	}
}
