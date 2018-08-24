package com.uiFramework;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class C {
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
