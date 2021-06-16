package com.splashlearn.app.screens.android;

import java.io.IOException;

import com.splashlearn.app.screens.ios.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class And_ChangeProfileScreen extends BasePage {

	public And_ChangeProfileScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/iv_change_profile_cross_button")
	private MobileElement CloseButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/iv_add_child")
	private MobileElement AddChildButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/et_player_name")
	private MobileElement EnterChildNameTexField;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/btn_add_player_done")
	private MobileElement EnterChildNameDoneBtn;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/iv_btn_cancel")
	private MobileElement EnterChildCrossBtn;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.ImageView")
	private MobileElement FirstChild;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.ImageView")
	private MobileElement SecondChild;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_pink_btn")
	private MobileElement LockedPopupOkBtn;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_title")
	private MobileElement LockedPopupHeading;

	public void LockedPopupOkBtnIsTapped() throws IOException {
		appiumLibrary.click(LockedPopupOkBtn);
	}

	public void CloseButtonIsTapped() throws IOException {
		appiumLibrary.click(CloseButton);
	}

	public void AddChildButtonIsTapped() throws IOException {
		appiumLibrary.click(AddChildButton);
	}

	public void FirstChildIsTapped() throws IOException {
		appiumLibrary.click(FirstChild);
	}

	public void SecondChildIsTapped() throws IOException {
		appiumLibrary.click(SecondChild);
	}

	public void EnterChildCloseBtn() throws IOException {
		appiumLibrary.click(EnterChildCrossBtn);
	}

	public boolean FirstChildIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(FirstChild);

	}

	public boolean SecondChildIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(SecondChild);

	}

	public void EnterChildName(String value) throws IOException {
		appiumLibrary.enterText(EnterChildNameTexField, value);

	}

	public void DoneButtonIsTapped() throws IOException {
		appiumLibrary.click(EnterChildNameDoneBtn);

	}

	public boolean AddChildButtonIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(AddChildButton);

	}

	public boolean EnterChildNameTexFieldIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(EnterChildNameTexField);

	}

	public boolean EnterChildNameDoneBtnIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(EnterChildNameDoneBtn);

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
