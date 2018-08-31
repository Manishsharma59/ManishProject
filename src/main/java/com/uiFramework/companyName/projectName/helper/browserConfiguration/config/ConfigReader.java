package com.uiFramework.companyName.projectName.helper.browserConfiguration.config;

import com.uiFramework.companyName.projectName.helper.browserConfiguration.BrowserType;

public interface ConfigReader {
	
	public int getImplicitWait();
	public int getExplicitWait();
	public int getPageLoadTime();
	public BrowserType getBrowserType();
	public String getURL();
	public String getUserName();
	public String getPassword();

}
