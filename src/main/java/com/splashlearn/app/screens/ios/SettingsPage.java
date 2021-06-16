package com.splashlearn.app.screens.ios;

import com.splashlearn.app.library.AppiumLibrary;
import com.splashlearn.app.library.SplashMathLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;

public class SettingsPage extends BasePage {
    public SettingsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "SettingsCell20")
    private MobileElement childOne;

    @iOSXCUITFindBy(accessibility = "SettingsCell21")
    private MobileElement childTwo;

    @iOSXCUITFindBy(accessibility = "SettingsCell22")
    private MobileElement childThree;

    @iOSXCUITFindBy(accessibility = "EUDDelete")
    private MobileElement deleteButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert[@name=\"Confirmation Required\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther")
    private MobileElement deleteField;

    @iOSXCUITFindBy(accessibility = "Delete")
    private MobileElement delete;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"K-5 Splash Math\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
    private MobileElement editName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back\"]")
    private MobileElement backButton;

    @iOSXCUITFindBy(accessibility = "Sign out")
    private MobileElement signOut;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Sign out\"]")
    private MobileElement signOutA;

    @iOSXCUITFindBy(accessibility = "SettingsCell33")
    private MobileElement onlinesync;

    @iOSXCUITFindBy(accessibility = "SettingsCell00")
    private MobileElement signedinUser;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Home\"]")
    private MobileElement homeSettings;

    @iOSXCUITFindBy(accessibility = "Place Value & Number Sense")
    private MobileElement placeValueAndNumberSense;


    public void clickChildOne() {
        SplashMathLibrary.sleep(2000);
        appiumLibrary.click(childOne);
    }

    public void clickChildTwo() {
        SplashMathLibrary.sleep(2000);
        appiumLibrary.click(childTwo);
    }

    public void clickChildThree() {
        appiumLibrary.click(childThree);
    }

    public void clickDeleteButton() {
        SplashMathLibrary.sleep(2000);
        appiumLibrary.click(deleteButton);
    }

    public void clickDelete(String text) {
        driver.findElement(By.xpath("//XCUIElementTypeTextField")).sendKeys("DELETE");
        appiumLibrary.click(delete);

    }

    public void editChildName(String name) {
        appiumLibrary.enterText(this.editName, name);
    }

    public void clickBackButton() {
        appiumLibrary.click(backButton);
    }

    public void clickSignOut() {
        appiumLibrary.click(signOut);
    }

    public void clickSignOutA() {
        appiumLibrary.click(signOutA);
    }

    public void SignedInUser() {
        appiumLibrary.isElementPresent(signedinUser);
    }


    public void clickOnlineSync() {
        appiumLibrary.scrollDown(onlinesync);
        appiumLibrary.click(onlinesync);
    }

    public void clickHomeSettings() {
        appiumLibrary.click(homeSettings);
    }

    public void clickPlaceValue() {
        appiumLibrary.click(placeValueAndNumberSense);
    }
}
