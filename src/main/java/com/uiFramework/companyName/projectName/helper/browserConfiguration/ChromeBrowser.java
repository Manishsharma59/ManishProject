package com.uiFramework.companyName.projectName.helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.uiFramework.companyName.projectName.helper.resource.ResouceHelper;

public class ChromeBrowser {
	
	public ChromeOptions getChromeOptions() {
		
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		chrome.setCapability(ChromeOptions.CAPABILITY, chrome);
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--test-type");
		option.addArguments("--disable-popup-blocking");
		//Linux
		if(System.getProperty("os.name").contains("Linux")) {
			option.addArguments("--headless","window-size=1024,768","--no-sandbox");
		}
		
		return option;
	}
	
	public WebDriver getChromeDriver(ChromeOptions chromeoptions) {
		if(System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.driver.chromedriver", ResouceHelper.getResources("src\\main\\resources\\driver\\chromedriver"));
			return new ChromeDriver(chromeoptions);
		}
		
		if(System.getProperty("os.name").contains("Window")) {
			System.setProperty("webdriver.driver.chromedriver", ResouceHelper.getResources("src\\main\\resources\\driver\\chromedriver.exe"));
			return new ChromeDriver(chromeoptions);
		}
		
		if(System.getProperty("os.name").contains("Linux")) {
			System.setProperty("webdriver.driver.chromedriver", ResouceHelper.getResources("\\usr\\bin\\chromedriver"));
			return new ChromeDriver(chromeoptions);
		}
		
		return null;
		
	}

}
