package com.uiFramework.companyName.projectName.helper.browserConfiguration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.uiFramework.companyName.projectName.helper.resource.ResouceHelper;

public class IExplorerBrowser {
	
	public InternetExplorerOptions getIExplorerBrowserOptions() {
		
		
		DesiredCapabilities ie = DesiredCapabilities.internetExplorer();
		ie.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, ElementScrollBehavior.BOTTOM);
		ie.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		ie.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		ie.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		ie.setJavascriptEnabled(true);
		InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions(ie);
		
		return internetExplorerOptions;
		
		
	}
	
	public WebDriver getInternetExplorerDriver(InternetExplorerOptions internetExplorerOptions) {
		if(System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.ie.driver", ResouceHelper.getResources("src\\main\\resources\\driver\\iedriver"));
		return new InternetExplorerDriver(internetExplorerOptions);
		}
		if(System.getProperty("os.name").contains("Window")) {
			System.setProperty("webdriver.ie.driver", ResouceHelper.getResources("src\\main\\resources\\driver\\iedriver.exe"));
		return new InternetExplorerDriver(internetExplorerOptions);
		}
		if(System.getProperty("os.name").contains("Linux")) {
			System.setProperty("webdriver.ie.driver", ResouceHelper.getResources("\\usr\\bin\\iedriver"));
		return new InternetExplorerDriver(internetExplorerOptions);
		}
		return null;
	}
		

}
