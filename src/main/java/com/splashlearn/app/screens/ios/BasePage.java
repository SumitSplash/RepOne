package com.splashlearn.app.screens.ios;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.splashlearn.app.library.AppiumLibrary;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class BasePage {

	public AppiumDriver<MobileElement> driver;
	public AppiumLibrary appiumLibrary;

	protected BasePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		appiumLibrary = new AppiumLibrary(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"2\"]")
	private MobileElement digitTwo;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"0\"]")
	private MobileElement digitZero;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BSSideDrawerLogIn\"]/XCUIElementTypeStaticText")
	private MobileElement loginIphone;

	@iOSXCUITFindBy(accessibility = "OK")
	private MobileElement Ok;

	@iOSXCUITFindBy(accessibility = "Next")
	private MobileElement next;

	@iOSXCUITFindBy(accessibility = "SPLoginTypeSelectionHomeButton")
	public MobileElement homeLogin;

	@iOSXCUITFindBy(accessibility = "CSLogin")
	private MobileElement loginIpad;

	public void agePasscode() {
		appiumLibrary.click(digitTwo);
		for (int i = 0; i <= 2; i++) {
			appiumLibrary.click(digitZero);
		}
	}

	public void clickOk() {
		appiumLibrary.click(Ok);
	}

	public void clickNext() {
		appiumLibrary.click(next);
	}

	public void clickHomeLogin() {
		appiumLibrary.click(homeLogin);
	}

	public void clickLoginButton() {
		int i = 0;
		while (++i < 10) {
			if (appiumLibrary.isElementPresent(loginIpad, 10)) {
				appiumLibrary.click(loginIpad);
				return;
			} else if (appiumLibrary.isElementPresent(loginIphone, 10)) {
				appiumLibrary.click(loginIphone);
				return;
			}
		}
	}

	public void selectGrade() {
		List<String> grades = new ArrayList<>();
		if (!appiumLibrary.isElementPresent(MobileBy.AccessibilityId("\"Pre-Kindergarten\""))) {
			grades.add("Kindergarten");
			grades.add("Grade 1");
			grades.add("Grade 2");
			grades.add("Grade 3");
			grades.add("Grade 4");
			grades.add("Grade 5");
		}
		grades.add("Pre-Kindergarten");
		grades.add("Kindergarten");
		grades.add("Grade 1");
		grades.add("Grade 2");
		grades.add("Grade 3");
		grades.add("Grade 4");
		grades.add("Grade 5");
		Random rand = new Random();
		String grade = grades.get(rand.nextInt(grades.size()));
		appiumLibrary.click(MobileBy.AccessibilityId(grade));
		out.println(grade);
	}

	public void selectGradeCF() {
		List<String> grades = new ArrayList<>();
		grades.add("K");
		grades.add("1");
		grades.add("2");
		grades.add("3");
		grades.add("4");
		grades.add("5");
		Random rand = new Random();
		String grade = grades.get(rand.nextInt(grades.size()));
		appiumLibrary.click(MobileBy.AccessibilityId(grade));
		out.println(grade);
	}

	public void childPersona() {
		List<String> options = new ArrayList<>();
		options.add("Avoids it");
		options.add("Loves it");
		options.add("Indifferent");
		Random rand = new Random();
		String option = options.get(rand.nextInt(options.size()));
		appiumLibrary.click(MobileBy.AccessibilityId(option));
		out.println((option));
	}

	public void parentPersona() {
		List<String> options = new ArrayList<>();
		options.add(driver.findElement(By.xpath(
				"//XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeStaticText"))
				.getAttribute("name"));
		options.add(driver.findElement(By.xpath(
				"//XCUIElementTypeCollectionView/XCUIElementTypeCell[2]/XCUIElementTypeOther/XCUIElementTypeStaticText"))
				.getAttribute("name"));
		options.add(driver.findElement(By.xpath(
				"//XCUIElementTypeCollectionView/XCUIElementTypeCell[3]/XCUIElementTypeOther/XCUIElementTypeStaticText"))
				.getAttribute("name"));
		options.add(driver.findElement(By.xpath(
				"//XCUIElementTypeCollectionView/XCUIElementTypeCell[4]/XCUIElementTypeOther/XCUIElementTypeStaticText"))
				.getAttribute("name"));
		options.add(driver.findElement(By.xpath(
				"//XCUIElementTypeCollectionView/XCUIElementTypeCell[5]/XCUIElementTypeOther/XCUIElementTypeStaticText"))
				.getAttribute("name"));
//        options.add(driver.findElement(By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell[6]/XCUIElementTypeOther/XCUIElementTypeStaticText")).getAttribute("name"));
		Random rand = new Random();
		String option = options.get(rand.nextInt(options.size()));
		appiumLibrary.click(MobileBy.AccessibilityId(option));
		out.println(option);

	}

	public void chooseContentGroup() {
		List<String> contentGroups = new ArrayList<>();
		contentGroups.add(driver
				.findElement(
						By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeStaticText"))
				.getAttribute("name"));
		contentGroups.add(driver
				.findElement(
						By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell[2]/XCUIElementTypeStaticText"))
				.getAttribute("name"));
		contentGroups.add(driver
				.findElement(
						By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell[3]/XCUIElementTypeStaticText"))
				.getAttribute("name"));
		contentGroups.add(driver
				.findElement(
						By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell[4]/XCUIElementTypeStaticText"))
				.getAttribute("name"));
		contentGroups.add(driver
				.findElement(
						By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell[5]/XCUIElementTypeStaticText"))
				.getAttribute("name"));
		contentGroups.add(driver
				.findElement(
						By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell[6]/XCUIElementTypeStaticText"))
				.getAttribute("name"));
		contentGroups.add(driver
				.findElement(
						By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell[7]/XCUIElementTypeStaticText"))
				.getAttribute("name"));
		Random rand = new Random();
		String contentGroup = contentGroups.get(rand.nextInt(contentGroups.size()));
		appiumLibrary.click(MobileBy.AccessibilityId(contentGroup));
		out.println(contentGroup);
	}

}
