package com.uiFramework.companyName.projectName.testScript;

import org.testng.annotations.Test;

import com.uiFramework.companyName.projectName.testbase.TestBase;

public class TestScreenShot extends TestBase{

	
	@Test
	public void testScreen() {
	driver.get("https://www.seleniumhq.org");	
	captureScreen("firstScreen");
	}
}
