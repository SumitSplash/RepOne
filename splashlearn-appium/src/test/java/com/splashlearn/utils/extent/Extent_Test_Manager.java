package com.splashlearn.utils.extent;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Extent_Test_Manager {
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	static ExtentReports extent = Extent_Manager.getInstance();
	public SoftAssert softAssertion = new SoftAssert();
	public ITestResult result;

	public static synchronized ExtentTest getTest() {
		return extentTestMap.get((int) (Thread.currentThread().getId()));
	}

	public static synchronized void endTest() {
		extent.flush();
	}

	public static synchronized ExtentTest startTest(String testName) {
		ExtentTest test = extent.createTest(testName);
		extentTestMap.put((int) (Thread.currentThread().getId()), test);
		return test;
	}

	public static synchronized void AssertEquals(String childNodeDesc, String actual, String expected)
			throws IOException {

		ExtentTest test = extentTestMap.get((int) (Thread.currentThread().getId()));
		ExtentTest cn = test.createNode(childNodeDesc);
//		System.out.println(actual);
//		System.out.println(expected);
		if (actual.equals(expected)) {

			cn.log(Status.PASS, "Pass");
//			System.out.println("Pass part is played");

		} else {
//			System.out.println("Fail part is played");
			cn.log(Status.FAIL, "Fail");
			String Screenhot = com.splashlearn.app.util.Report_Failure_ScreenShot.ScreenshotTaken(childNodeDesc);
			Extent_Test_Manager.getTest().log(Status.FAIL, "Failure");
			Extent_Test_Manager.getTest().addScreenCaptureFromPath(Screenhot, "Failure");
		}
	}

	public static synchronized void AssertEqualsList(String childNodeDesc, List<String> actual, List<String> expected)
			throws IOException {

		ExtentTest test = extentTestMap.get((int) (Thread.currentThread().getId()));
		ExtentTest cn = test.createNode(childNodeDesc);

		if (actual.equals(expected)) {
			cn.log(Status.PASS, "Pass");

		} else if (actual != expected) {

			cn.log(Status.FAIL, "Fail");
			String Screenhot = com.splashlearn.app.util.Report_Failure_ScreenShot.ScreenshotTaken(childNodeDesc);
			Extent_Test_Manager.getTest().log(Status.FAIL, "Failure");
			Extent_Test_Manager.getTest().addScreenCaptureFromPath(Screenhot, "Failure");
		}
	}

	public static synchronized void AssertTrue(String childNodeDesc1, boolean actual, String Message)
			throws IOException {

		ExtentTest test = extentTestMap.get((int) (Thread.currentThread().getId()));
		ExtentTest cn = test.createNode(childNodeDesc1);

		if (actual == true) {
			cn.log(Status.PASS, "Pass");
		} else if (actual == false)

		{
			cn.log(Status.FAIL, "Fail");
			String Screenhot = com.splashlearn.app.util.Report_Failure_ScreenShot.ScreenshotTaken(childNodeDesc1);
			Extent_Test_Manager.getTest().log(Status.FAIL, "Failure");
			Extent_Test_Manager.getTest().addScreenCaptureFromPath(Screenhot, "Failure");
		}
	}

	public static synchronized void AssertFail(String childNodeDesc1, String Message) throws IOException {
		ExtentTest test = extentTestMap.get((int) (Thread.currentThread().getId()));
		ExtentTest cn = test.createNode(childNodeDesc1);
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.fail(Message);
		cn.log(Status.FAIL, "Fail");
		String Screenhot = com.splashlearn.app.util.Report_Failure_ScreenShot.ScreenshotTaken(childNodeDesc1);
		Extent_Test_Manager.getTest().log(Status.FAIL, "Failure");
		Extent_Test_Manager.getTest().addScreenCaptureFromPath(Screenhot, "Failure");

	}

}