package com.uiFramework;

import org.testng.annotations.Test;

import com.uiFramework.companyName.projectName.testbase.TestBase;

import org.testng.Assert;

public class C extends TestBase{
	int i=1;
	@Test
	public void testLoginC() {
		
		if(i==3) {
		Assert.assertTrue(true);
		}
		else {
			System.out.println(i);
			i++;
			Assert.assertTrue(false);
		}
	}

}
