package com.splashlearn.app.screens.android;

import java.io.IOException;

import com.splashlearn.app.screens.ios.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class And_SelectGradeScreen extends BasePage {
	public And_SelectGradeScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(xpath = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/k1.x.a.b/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView")
	private MobileElement GradeK;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_select_grade")
	private MobileElement SelectGradeProgressBar;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]")
	private MobileElement SelectFocusAreaProgressBar;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_play_balloon")
	private MobileElement PlayProgressBar;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_selected_grade_text")
	private MobileElement SelectGradeHeading;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_selected_grade_description_text")
	private MobileElement SelectGradeSubHeading;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/a1.x.a.b/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView")
	private MobileElement GradePreKButton;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/a1.x.a.b/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView")
	private MobileElement GradeKButton;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/a1.x.a.b/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView")
	private MobileElement Grade1Button;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/a1.x.a.b/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.TextView")
	private MobileElement Grade2Button;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/a1.x.a.b/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.TextView")
	private MobileElement Grade3Button;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/a1.x.a.b/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.TextView")
	private MobileElement Grade4Button;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/a1.x.a.b/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[7]/android.widget.TextView")
	private MobileElement Grade5Button;

	public boolean SelectGradeHeadingisDisplayed() {
		return appiumLibrary.isElementPresent(SelectGradeHeading);
	}

	public String SelectGradeProgressBarGetText() {
		String SelectGradeProgressBarText = appiumLibrary.getText(SelectGradeProgressBar);
		return SelectGradeProgressBarText;
	}

	public String GradeKGetText() {
		String SelectGradeProgressBarText = appiumLibrary.getText(GradeK);
		return SelectGradeProgressBarText;
	}

	public String SelectFocusAreaProgressBarGetText() {
		String SelectFocusAreaProgressBarText = appiumLibrary.getText(SelectFocusAreaProgressBar);
		return SelectFocusAreaProgressBarText;
	}

	public String PlayProgressBarGetText() {
		String PlayProgressBarText = appiumLibrary.getText(PlayProgressBar);
		return PlayProgressBarText;
	}

	public String SelectGradeHeadingGetText() {
		String SelectGradeHeadingText = appiumLibrary.getText(SelectGradeHeading);
		return SelectGradeHeadingText;
	}

	public String SelectGradeSubHeadingGetText() {
		String SelectGradeSubHeadingText = appiumLibrary.getText(SelectGradeSubHeading);
		return SelectGradeSubHeadingText;
	}

	public String GradePreKButtonGetText() {
		String GradePreKButtonText = appiumLibrary.getText(GradePreKButton);
		return GradePreKButtonText;
	}

	public String GradeKButtonGetText() {
		String GradeKButtonText = appiumLibrary.getText(GradeKButton);
		return GradeKButtonText;
	}

	public String TGrade1ButtonGetText() {
		String Grade1ButtonText = appiumLibrary.getText(Grade1Button);
		return Grade1ButtonText;
	}

	public String Grade2ButtonGetText() {
		String Grade2ButtonText = appiumLibrary.getText(Grade2Button);
		return Grade2ButtonText;
	}

	public String Grade3ButtonGetText() {
		String Grade3ButtonText = appiumLibrary.getText(Grade3Button);
		return Grade3ButtonText;
	}

	public String Grade4ButtonGetText() {
		String Grade4ButtonText = appiumLibrary.getText(Grade4Button);
		return Grade4ButtonText;
	}

	public String Grade5ButtonGetText() {
		String Grade5ButtonText = appiumLibrary.getText(Grade5Button);
		return Grade5ButtonText;
	}

	public void GradePreKButtonIsTapped() throws IOException {
		appiumLibrary.click(GradePreKButton);
	}

	public void GradeKButtonIsTapped() throws IOException {
		appiumLibrary.click(GradeKButton);
	}

	public void Grade1ButtonIsTapped() throws IOException {
		appiumLibrary.click(Grade1Button);
	}

	public void Grade2ButtonIsTapped() throws IOException {
		appiumLibrary.click(Grade2Button);
	}

	public void Grade3ButtonIsTapped() throws IOException {
		appiumLibrary.click(Grade3Button);
	}

	public void Grade4ButtonIsTapped() throws IOException {
		appiumLibrary.click(Grade4Button);
	}

	public void Grade5ButtonButtonIsTapped() throws IOException {
		appiumLibrary.click(Grade5Button);
	}

	public static void clickGrade(AndroidDriver<MobileElement> driver, String GradeName) {
		MobileElement el = driver.findElementByAndroidUIAutomator(
				"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().text(\""
						+ GradeName + "\"));");
		el.click();
	}

	public static String GetTextGrade(AndroidDriver<MobileElement> driver, String GradeName) {
		MobileElement el = driver.findElementByAndroidUIAutomator(
				"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().text(\""
						+ GradeName + "\"));");
		return el.getText();
	}

	public static boolean displayedGrade(AndroidDriver<MobileElement> driver, String GradeName) {
		MobileElement el = driver.findElementByAndroidUIAutomator(
				"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().text(\""
						+ GradeName + "\"));");
		return el.isDisplayed();
	}
}
