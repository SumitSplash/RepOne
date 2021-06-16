package com.splashlearn.app.screens.android;

import java.io.IOException;

import com.splashlearn.app.screens.ios.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class And_SelectFocusArea extends BasePage {

	public And_SelectFocusArea(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_select_grade")
	private MobileElement SelectGradeProgressBar;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]")
	private MobileElement SelectFocusAreaProgressBar;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_play_balloon")
	private MobileElement PlayProgressBar;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_selected_focus_area_text")
	private MobileElement FocusAreaHeading;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_selected_focus_area_description_text")
	private MobileElement FocusAreaSubHeading;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_selected_focus_area_change")
	private MobileElement ChangeFocusAreaText;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/a1.x.a.b/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView")
	private MobileElement CountingSequence;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/a1.x.a.b/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView")
	private MobileElement ShapesAndPatterns;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/a1.x.a.b/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView")
	private MobileElement CountingObjects;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/a1.x.a.b/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.TextView")
	private MobileElement SortingAndComparing;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/a1.x.a.b/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.TextView")
	private MobileElement AdditionAndSubtraction;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/btn_choose_for_me")
	private MobileElement chooseForMeButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/btn_done")
	private MobileElement DoneButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/iv_btn_on_boarding_back")
	private MobileElement BackButton;

	public boolean FocusAreaHeadingisDisplayed() {
		return appiumLibrary.isElementPresent(FocusAreaHeading);
	}

	public boolean FocusAreaSubHeadingisDisplayed() {
		return appiumLibrary.isElementPresent(FocusAreaSubHeading);
	}

	public boolean ChangeFocusAreaTextisDisplayed() {
		return appiumLibrary.isElementPresent(ChangeFocusAreaText);
	}

	public boolean GradePreKCountingSequenceisDisplayed() {
		return appiumLibrary.isElementPresent(CountingSequence);
	}

	public boolean GradePreKShapesAndPatternsisDisplayed() {
		return appiumLibrary.isElementPresent(ShapesAndPatterns);
	}

	public boolean GradePreKCountingObjectsisDisplayed() {
		return appiumLibrary.isElementPresent(CountingObjects);
	}

	public boolean GradePreKSortingAndComparingisDisplayed() {
		return appiumLibrary.isElementPresent(SortingAndComparing);
	}

	public boolean GradePreKAdditionAndSubtractionisDisplayed() {
		return appiumLibrary.isElementPresent(AdditionAndSubtraction);
	}

	public boolean DoneButtonisDisplayed() {
		return appiumLibrary.isElementPresent(DoneButton);
	}

	public boolean chooseForMeButtonisDisplayed() {
		return appiumLibrary.isElementPresent(chooseForMeButton);
	}

	public String FocusAreaHeadingGetText() {
		String FocusAreaHeadingText = appiumLibrary.getText(FocusAreaHeading);
		return FocusAreaHeadingText;
	}

	public String FocusAreaSubHeadingGetText() {
		String FocusAreaSubHeadingText = appiumLibrary.getText(FocusAreaSubHeading);
		return FocusAreaSubHeadingText;
	}

	public String ChangeFocusAreaTextGetText() {
		String ChangeFocusAreaGetText = appiumLibrary.getText(ChangeFocusAreaText);
		return ChangeFocusAreaGetText;
	}

	public String DoneButtonGetText() {
		String DoneButtonText = appiumLibrary.getText(DoneButton);
		return DoneButtonText;
	}

	public String chooseForMeButtonGetText() {
		String chooseForMeButtonText = appiumLibrary.getText(chooseForMeButton);
		return chooseForMeButtonText;
	}

	public void CountingSequenceIsTapped() throws IOException {
		appiumLibrary.click(CountingSequence);
	}

	public void ShapesAndPatternsIsTapped() throws IOException {
		appiumLibrary.click(ShapesAndPatterns);
	}

	public void CountingObjectsIsTapped() throws IOException {
		appiumLibrary.click(CountingObjects);
	}

	public void SortingAndComparingIsTapped() throws IOException {
		appiumLibrary.click(SortingAndComparing);
	}

	public void AdditionAndSubtractionIsTapped() throws IOException {
		appiumLibrary.click(AdditionAndSubtraction);
	}

	public void chooseForMeButtonIsTapped() throws IOException {
		appiumLibrary.click(chooseForMeButton);
	}

	public void DoneButtonIsTapped() throws IOException {
		appiumLibrary.click(DoneButton);
	}

	public void BackButtonIsTapped() throws IOException {
		appiumLibrary.click(BackButton);
	}

	public static void ClickFocusArea(AndroidDriver<MobileElement> driver, String TopicName) {
		MobileElement el = driver.findElementByAndroidUIAutomator(
				"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().text(\""
						+ TopicName + "\"));");
		el.click();
	}

	public static String GetTextFocusArea(AndroidDriver<MobileElement> driver, String TopicName) {
		MobileElement el = driver.findElementByAndroidUIAutomator(
				"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().text(\""
						+ TopicName + "\"));");
		return el.getText();
	}

	public static boolean DisplayedFocusArea(AndroidDriver<MobileElement> driver, String TopicName) {
		MobileElement el = driver.findElementByAndroidUIAutomator(
				"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().text(\""
						+ TopicName + "\"));");
		return el.isDisplayed();
	}

}
