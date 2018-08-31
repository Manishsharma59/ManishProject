package com.uiFramework.companyName.projectName.helper.browserConfiguration.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.uiFramework.companyName.projectName.helper.browserConfiguration.BrowserType;
import com.uiFramework.companyName.projectName.helper.resource.ResouceHelper;

public class PropertyReader implements ConfigReader {

	private static FileInputStream file;
	public static Properties OR;

	public PropertyReader() {
		String filepath = ResouceHelper.getResources("src\\main\\resources\\configfile\\config.properties");
		try {
			file = new FileInputStream(new File(filepath));
			OR = new Properties();
			OR.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getImplicitWait() {
		
		return Integer.parseInt(OR.getProperty("implicitwait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(OR.getProperty("explicitwait"));
	}

	public int getPageLoadTime() {
		return Integer.parseInt(OR.getProperty("pageloadtime"));
	}

	public BrowserType getBrowserType() {
		return BrowserType.valueOf(OR.getProperty("browsertype"));
	}
	
	public String getURL() {
		return OR.getProperty("url");
	}
	
	public String getUserName() {
		return OR.getProperty("username");
	}
	
	public String getPassword() {
		return OR.getProperty("password");
	}

}
