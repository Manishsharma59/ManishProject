package com.uiFramework.companyName.projectName.testScript;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uiFramework.companyName.projectName.helper.assertion.AssertionHelper;
import com.uiFramework.companyName.projectName.testbase.TestBase;

public class Test1 extends TestBase{
	
	@DataProvider(name="testData")
	public Object[][] getData(){
		
		Object[][] data = getExcelData("Book1.xlsx", "loginData");
		return data;
		
	}

	@Test(dataProvider="testData")
	public void testLogin(String TestCase,String TestStep,String TestComments,String Status) {
		
		System.out.println("TestCase "+TestCase+"TestStep "+TestStep+"TestComments "+TestComments+"Status "+Status);
		//AssertionHelper.makeTrue();
	}

	
	
	//@Test
	public void testLogin2() {
		AssertionHelper.makeTrue();
	}

	
}
