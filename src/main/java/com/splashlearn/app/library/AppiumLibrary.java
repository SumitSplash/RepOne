//This is very second commit

//this is 3rd commit

//this is 4th commit

package com.splashlearn.app.library;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.splashlearn.app.util.SplashMathConstants;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumLibrary extends BaseLibrary {

	public AppiumLibrary(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	public void click(MobileElement e) {
		waitForElement(e);
		e.click();
	}

	public void click(By by) {
		waitForElement(by);
		getElement(by).click();
	}

	public void tap(int x, int y) {
		SplashMathLibrary.sleep(5000);
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(PointOption.point(x, y)).waitAction().perform();
	}

	public void waitForElement(MobileElement ele) {
		waitForElement(ele, 60);
	}

	public void waitForElement(MobileElement ele, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(ele));
		} catch (Exception e) {
			Assert.fail("Unable to find element " + e);
		}
	}

	public void waitForElement(By by, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Exception e) {
			Assert.fail("Unable to find element " + e);
		}
	}

	public void waitForElement(By by) {
		waitForElement(by, 60);
	}

	public boolean isElementVisible(By by) {
		waitForElement(by);
		return isElementPresent(driver.findElement(by));
	}

	public boolean isElementPresent(MobileElement ele) {
		return isElementPresent(ele, SplashMathConstants.DEFAULT_TIMEOUT);
	}

	public boolean isElementPresent(By by) {
		return isElementPresent(by, 60);
	}

	public boolean isElementPresent(By by, int timeout) {
		try {
			waitForElement(by, timeout);
			return true;
		} catch (AssertionError e) {
			return false;
		}
	}

	public boolean isElementPresent(MobileElement ele, int timeout) {
		try {
			waitForElement(ele, timeout);
			return true;
		} catch (AssertionError e) {
			return false;
		}
	}

	public String getText(By by) {
		return getElement(by).getText();
	}

	public String getText(MobileElement e) {
		return e.getText();
	}

	public void scroll(int startX, int startY, int endX, int endY, int duration) {
		new TouchAction(driver).press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration))).moveTo(PointOption.point(endX, endY))
				.release().perform();
	}

	public MobileElement getElement(By by) {
		return driver.findElement(by);
	}

	public List<MobileElement> getElements(By by) {
		return driver.findElements(by);
	}

	public void enterText(MobileElement element, String value) {
		waitForElement(element);
		element.clear();
		element.sendKeys(value);
	}

	public void scrollDown(By by) {
		TouchActions action = new TouchActions(driver);
		action.scroll(driver.findElement(by), 10, 100);
		action.perform();
	}

	public void scrollDown(MobileElement e) {
		TouchActions action = new TouchActions(driver);
		action.scroll(e, 10, 100);
		action.perform();
	}

	public void ScrollUptoElement(MobileElement element) {
		waitForElement(element);
		JavascriptExecutor js = driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	public static void scrollToText(AndroidDriver<MobileElement> driver, String text) {
		MobileElement el = driver.findElementByAndroidUIAutomator("new UiScrollable("
				+ "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().text(\"" + text + "\"));");
	}

	public static void scrollToTextAndClick(AndroidDriver<MobileElement> driver, String text) {
		MobileElement el = driver.findElementByAndroidUIAutomator("new UiScrollable("
				+ "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().text(\"" + text + "\"));");

		el.click();

	}

	public static void PressDeviceBackButton() {

		driver.navigate().back();
	}

	public void matchChildName() {
		List<String> childNames = new ArrayList<>();
		childNames.add(driver.findElement(By.xpath("//XCUIElementTypeCell[7]/XCUIElementTypeStaticText[1]"))
				.getAttribute("name"));
		childNames.add(driver.findElement(By.xpath("//XCUIElementTypeCell[8]/XCUIElementTypeStaticText[1]"))
				.getAttribute("name"));
		childNames.add(driver.findElement(By.xpath("//XCUIElementTypeCell[9]/XCUIElementTypeStaticText[1]"))
				.getAttribute("name"));
		System.out.println(childNames);
		String selectedChildName = ("Raju");
		boolean matchFound = false;
		for (String childName : childNames) {
			if (selectedChildName.contains(childName)) {
				matchFound = true;
			}
		}
		System.out.println(matchFound);

	}

	public void PressDeviceBackBtn() {
		driver.navigate().back();
	}

	public void stopRecording(String destination) throws IOException {
		String base64String = ((CanRecordScreen) driver).stopRecordingScreen();
		byte[] data = Base64.decodeBase64(base64String);
		String destinationPath = destination;
		Path path = Paths.get(destinationPath);
		Files.write(path, data);

	}

	public static void DeleteFilesAll(File directory) throws IOException {

		FileUtils.cleanDirectory(directory);

	}

}
