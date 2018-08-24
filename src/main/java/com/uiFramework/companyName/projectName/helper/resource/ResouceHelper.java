package com.uiFramework.companyName.projectName.helper.resource;


import org.apache.log4j.Logger;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class ResouceHelper {
	
	private static Logger log = LoggerHelper.getLogger(ResouceHelper.class);
	public static String getResources(String path) {
		
		String basePath = System.getProperty("user.dir");
		return basePath+"\\"+path;
		
	}
	
	public static void main(String[] args) {
		String path = ResouceHelper.getResources("src\\main\\resources\\configfile\\log4j.properties");
		
		System.out.println(path);
	}

}
