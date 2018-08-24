package com.uiFramework.companyName.projectName.helper.browserConfiguration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.uiFramework.companyName.projectName.helper.resource.ResouceHelper;

public class FirefoxBrowser {
	
	public FirefoxOptions getFirefoxOptions() {
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);
		
		DesiredCapabilities firefox = DesiredCapabilities.firefox();
		firefox.setCapability(FirefoxDriver.PROFILE, profile);
		firefox.setCapability("marionette", true);
		
		FirefoxOptions firefoxOptions = new FirefoxOptions(firefox);
		//Linux
		if(System.getProperty("os.name").contains("Linux")) {
			firefoxOptions.addArguments("--headless","window-size=1024,768","--no-sandbox");
		}
		return firefoxOptions;
		
		
	}
	
	public WebDriver getFirefoxDriver(FirefoxOptions firefoxOptions) {
		
		if(System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.gecko.driver", ResouceHelper.getResources("src\\main\\resources\\driver\\chromedriver"));
		return new FirefoxDriver(firefoxOptions);
		}
		if(System.getProperty("os.name").contains("Window")) {
			System.setProperty("webdriver.gecko.driver", ResouceHelper.getResources("src\\main\\resources\\driver\\chromedriver.exe"));
		return new FirefoxDriver(firefoxOptions);
		}
		if(System.getProperty("os.name").contains("Linux")) {
			System.setProperty("webdriver.gecko.driver", ResouceHelper.getResources("\\usr\\bin\\chromedriver"));
		return new FirefoxDriver(firefoxOptions);
		}
		return null;
	}

}
