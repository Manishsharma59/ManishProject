package com.uiFramework;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class B {
	int i=1;
	@Test
	public void testLoginB() {
		
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
