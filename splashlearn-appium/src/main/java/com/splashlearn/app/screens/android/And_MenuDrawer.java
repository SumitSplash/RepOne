package com.splashlearn.app.screens.android;

import java.io.IOException;

import com.splashlearn.app.screens.ios.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class And_MenuDrawer extends BasePage {

	public And_MenuDrawer(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_change_profile_and_login_button")
	private MobileElement ChangeProfileAndLoginButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_settings_button")
	private MobileElement SettingsButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_help_button")
	private MobileElement HelpButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_sound_button")
	private MobileElement SoundButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_music_button")
	private MobileElement MusicButton;

	public boolean ChangeProfileAndLoginButtonIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(ChangeProfileAndLoginButton);
	}

	public boolean SettingsButtonIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(SettingsButton);
	}

	public boolean HelpButtonIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(HelpButton);
	}

	public boolean SoundButtonIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(SoundButton);
	}

	public boolean MusicButtonIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(MusicButton);
	}

	public void ChangeProfileAndLoginButtonIsTapped() throws IOException {
		appiumLibrary.click(ChangeProfileAndLoginButton);
	}

	public void SettingsButtonIsTapped() throws IOException {
		appiumLibrary.click(SettingsButton);
	}

	public void HelpButtonIsTapped() throws IOException {
		appiumLibrary.click(HelpButton);
	}

	public void SoundButtonIsTapped() throws IOException {
		appiumLibrary.click(SoundButton);
	}

	public void MusicButtonIsTapped() throws IOException {
		appiumLibrary.click(MusicButton);
	}

}
