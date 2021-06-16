package com.splashlearn.test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.splashlearn.app.library.AppiumLibrary;
import com.splashlearn.app.library.DeviceFactory;
import com.splashlearn.app.model.Device;
import com.splashlearn.app.util.Sending_Mail_Folder;

public class Hooks {

	protected ThreadLocal<String> testName = new ThreadLocal<>();
	protected ThreadLocal<Device> deviceThreadLocal = new ThreadLocal<>();
	private static final File AutomationReport = new File(
			System.getProperty("user.dir") + "//TestReport//Test-Automaton-Report.html");
	private static final File AutomationReportZip = new File(System.getProperty("user.dir") + "//TestReport.zip");
	private static final File FailScreenShot = new File(
			System.getProperty("user.dir") + "//TestReport//FailedScreenshot//");

	@BeforeSuite
	@Parameters("overallDevicesRequired")
	protected void beforeSuite(@Optional("1") String overallDevicesRequired) throws IOException {
		DeviceFactory.setInstance(Integer.parseInt(overallDevicesRequired));
		AppiumLibrary.DeleteFilesAll(FailScreenShot);
		AutomationReportZip.delete();
		AutomationReport.delete();

	}

	@BeforeMethod
	protected void beforeMethod(Method method) {
		testName.set(method.getName());
	}

	@AfterMethod
	protected void afterMethod() {
		if (deviceThreadLocal.get() != null) {
			DeviceFactory.getInstance().addDeviceToQueue(deviceThreadLocal.get());
			deviceThreadLocal.get().getDriver().closeApp();
		}
	}

	@AfterSuite
	protected void afterSuite(ITestContext context) throws IOException {
		Sending_Mail_Folder.SendMail("sumit.bansal@splashlearn.com", "sumit.bansal@splashlearn.com",
				context.getCurrentXmlTest().getSuite().getName(), "TestReport", " Automation Report ");
		DeviceFactory.getInstance().destroy();
	}

}
