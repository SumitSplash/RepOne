package com.splashlearn.app.util;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;

import com.splashlearn.app.library.AppiumLibrary;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Page_ScreenShot_Capture extends AppiumLibrary implements ITestListener {
	public Page_ScreenShot_Capture(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static String ScreenshotTaken(String testcaseName, String ICont) throws IOException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy'_at_'hh:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		String Date = formatter.format(date);

		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String ScreenshotName = ICont + "_" + testcaseName + "_" + Date + ".png";

		String newFile = System.getProperty("user.dir") + "//PageScreenshot//" + ScreenshotName;
		/*
		 * String newFile =
		 * "/Users//STYLSUMITB//eclipse-workspace//com.splashlearn.appium.framework.android//TestReport//FailedScreenshot//"
		 * + ScreenshotName;
		 */
		FileUtils.copyFile(srcfile, new File(newFile), true);
		return newFile;

		// screenShotName = new File(newFile);

		// Reporter.log("<br><img src = '"+ newFile + "' height = '200' width
		// ='200'/><br>");
		// Reporter.log("<a href =//"+ newFile + "/ target=/_blank/>" +TestName
		// +"</a>");
		// Reporter.log("<br>");
		// Reporter.log("<a href =//"+ newFile + "/ target=/_blank/>" + "<img src = '"+
		// newFile + "' height = '200' width ='200'" +"/</a>");

	}

}
