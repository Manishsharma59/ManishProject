package com.uiFramework.companyName.projectName.helper.listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.utils.ExtentManager;

public class ExtentListener implements ITestListener{
	private Logger log = LoggerHelper.getLogger(ExtentListener.class);
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		//test.log(Status.INFO, result.getName()+" started..");
		Reporter.log(result.getMethod().getMethodName()+"Test start..");
		log.info(result.getMethod().getMethodName()+" started..");
	}

	public void onTestSuccess(ITestResult result) {
		//test.log(Status.PASS, result.getName()+" Passed");
		Reporter.log(result.getMethod().getMethodName()+" test passed.. ");
		log.info(result.getMethod().getMethodName()+" passed..");
	}

	public void onTestFailure(ITestResult result) {
		//test.log(Status.FAIL, result.getThrowable());
		Reporter.log(result.getMethod().getMethodName()+" test failed "+result.getThrowable());
		log.error(result.getMethod().getMethodName()+" test failed.."+result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		//test.log(Status.SKIP, result.getThrowable());
		Reporter.log(result.getMethod().getMethodName()+" test skipped "+result.getThrowable());
		log.warn(result.getMethod().getMethodName()+" skipped.."+result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		//extent = ExtentManager.getInstance();
		//test = extent.createTest(context.getName());
		Reporter.log(context.getName()+" class started..");
		log.info(context.getCurrentXmlTest().getName()+ " Class started");
	}

	public void onFinish(ITestContext context) {
		//extent.flush();
		Reporter.log(context.getName()+" test finished");
		log.info(context.getName()+ " Test finished");
	}

}
