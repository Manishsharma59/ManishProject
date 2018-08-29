package com.uiFramework.companyName.projectName.helper.browserConfiguration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import com.uiFramework.companyName.projectName.helper.resource.ResouceHelper;

public class EdgeBrowser {
	

	
	public WebDriver getEdgeDriver() {
		if(System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.edge.driver", ResouceHelper.getResources("src\\main\\resources\\driver\\MicrosoftWebDriver"));
			return new EdgeDriver();
		}
		
		if(System.getProperty("os.name").contains("Window")) {
			System.setProperty("webdriver.edge.driver", ResouceHelper.getResources("src\\main\\resources\\driver\\MicrosoftWebDriver.exe"));
			return new EdgeDriver();
		}
		
		if(System.getProperty("os.name").contains("Linux")) {
			System.setProperty("webdriver.edge.driver", ResouceHelper.getResources("\\usr\\bin\\MicrosoftWebDriver"));
			return new EdgeDriver();
		}
		
		return null;
		
	}

}
