package com.splashlearn.app.screens.android;

import java.io.IOException;

import com.splashlearn.app.screens.ios.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class And_ContentGroup extends BasePage {

	public And_ContentGroup(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/iv_common_background_back_button")
	private MobileElement ContentGroupBackButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/iv_next_content_group_link")
	private MobileElement NextContentGroupButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_preferred_topic")
	private MobileElement SetPreferredTopicButton;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView[3]")
	private MobileElement LevelReaderFirstPlayable;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView[3]")
	private MobileElement BedTimsStoriesFirstPlayable;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView[2]")
	private MobileElement SightWordsFirstPlayable;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView[3]")
	private MobileElement DecodableBooksFirstPlayable;

	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	private MobileElement AllowNotificationpopup;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_pink_btn")
	private MobileElement LockedPopupOkBtn;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_title")
	private MobileElement LockedPopupHeading;

	public void LockedPopupOkBtnIsTapped() throws IOException {
		appiumLibrary.click(LockedPopupOkBtn);
	}

	public void ContentGroupBackButtonIsTapped() throws IOException {
		appiumLibrary.click(ContentGroupBackButton);

	}

	public void AllowNotificationpopupIsTapped() throws IOException {
		appiumLibrary.click(AllowNotificationpopup);

	}

	public void DecodableBooksFirstPlayableIsTapped() throws IOException {
		appiumLibrary.click(DecodableBooksFirstPlayable);

	}

	public void SetPreferredTopicButtonIsTapped() throws IOException {
		appiumLibrary.click(SetPreferredTopicButton);

	}

	public void SightWordsFirstPlayableIsTapped() throws IOException {
		appiumLibrary.click(SightWordsFirstPlayable);

	}

	public void BedTimsStoriesFirstPlayableIsTapped() throws IOException {
		appiumLibrary.click(BedTimsStoriesFirstPlayable);

	}

	public void NextContentGroupButtonIsTapped() throws IOException {
		appiumLibrary.click(NextContentGroupButton);
	}

	public void LevelReaderFirstPlayableIsTapped() throws IOException {
		appiumLibrary.click(LevelReaderFirstPlayable);
	}

	public String ElementGetText(AndroidDriver<MobileElement> driver, String text)
			throws InterruptedException, IOException {
		try {
			MobileElement el = driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
							+ text + "\").instance(0))"));

			Thread.sleep(4000);

			return el.getText();

		} catch (Exception e) {
			Thread.sleep(3000);
			if (LockedPopupHeading.isDisplayed() == true) {
				LockedPopupOkBtnIsTapped();
			}

			else if (LockedPopupHeading.isDisplayed() == false) {
				return "Element Not Found";
			}
			return "Element Not Found";
		}

	}

	public void scrollToTextAndClick(AndroidDriver<MobileElement> driver, String Text) {
		try {
			MobileElement el = driver.findElementByAndroidUIAutomator(
					"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
							+ "new UiSelector().text(\"" + Text + "\"));");

			el.click();

		}

		catch (Exception e) {
			System.out.println("Element Not Found: " + e);
		}
	}

}
