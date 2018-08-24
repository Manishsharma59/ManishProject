package com.uiFramework;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class A {
	int i=1;
	@Test
	public void testLogin() {
	
		if(i<3) {
		Assert.assertTrue(true);
		}
		else {
			System.out.println(i);
			i++;
			Assert.assertTrue(false);
		}
	}

}
