package com.splashlearn.utils.listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.splashlearn.app.util.Report_Failure_ScreenShot;
import com.splashlearn.utils.extent.Extent_Manager;
import com.splashlearn.utils.extent.Extent_Test_Manager;

public class Test_Listener implements ITestListener {

	// @Override
	@Override
	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	// @Override
	@Override
	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		Extent_Test_Manager.endTest();
		Extent_Manager.getInstance().flush();
	}

	// @Override
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		Extent_Test_Manager.startTest(result.getMethod().getMethodName());

	}

	// @Override
	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		Extent_Test_Manager.getTest().log(Status.PASS, "Test passed");
	}

	// @Override
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		try {
			String Screenhot = Report_Failure_ScreenShot.ScreenshotTaken(result.getName());
			Extent_Test_Manager.getTest().log(Status.FAIL, "Failure");
			Extent_Test_Manager.getTest().addScreenCaptureFromPath(Screenhot, "Failure");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// @Override
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		Extent_Test_Manager.getTest().log(Status.SKIP, "Test Skipped");
	}

	// @Override
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

}