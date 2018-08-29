package com.uiFramework.companyName.projectName.helper.assertion;

import org.apache.log4j.Logger;
import org.testng.Assert;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;



public class AssertionHelper {

	private static Logger log = LoggerHelper.getLogger(AssertionHelper.class);

	public static void verifyText(String s1, String s2) {
		log.info("Verifing text : "+s1+" with "+s2);
		Assert.assertEquals(s1, s2);
	}

	public static void makeTrue() {
		log.info("making script pass");
		Assert.assertTrue(true);
	}

	public static void makeTrue(String message) {
		log.info("making script pass "+message);
		Assert.assertTrue(true,message);
	}

	public static void makeFalse() {
		log.info("making script Fail");
		Assert.assertFalse(true);
	}

	public static void makeFalse(String message) {
		log.info("making script pass");
		Assert.assertFalse(true,message);
	}
	
	public void verifyTrue(boolean status) {
		Assert.assertTrue(status);
	}
	
	public void verifyFalse(boolean status) {
		Assert.assertFalse(status);
	}
	
	public void verifyNull(String s1) {
		log.info("verify object is null");
		Assert.assertNull(s1);
	}
	public void verifyNotNull(String s1) {
		log.info("verify object is not null " +s1);
		Assert.assertNotNull(s1);
	}
}
