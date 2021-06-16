package com.splashlearn.app.screens.ios;

import com.splashlearn.app.library.AppiumLibrary;
import com.splashlearn.app.library.SplashMathLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MathGamesPage extends BasePage {
    public MathGamesPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "curriculumBackButton")
    private MobileElement curriculumBAckButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]")
    public MobileElement levelOneMathGame;

    public void clickBackButtonMathGames() {
        appiumLibrary.click(curriculumBAckButton);
    }

    public void clickLevelOneMathGames() {
        appiumLibrary.click(levelOneMathGame);
    }

    public void checkGamePlay(String accessibilityID) throws InterruptedException {
        driver.findElement(MobileBy.AccessibilityId(accessibilityID)).click();
        SplashMathLibrary.sleep(20000);
        int i = 0;
        while (!appiumLibrary.isElementPresent(levelOneMathGame, 1) && i < 10) {
            driver.findElement(MobileBy.AccessibilityId(accessibilityID)).click();
            SplashMathLibrary.sleep(5000);
            i++;
        }
//        appiumLibrary.click(levelOneMathGame);
//        appiumLibrary.tap(980, 25);
//        appiumLibrary.tap(400, 440);
        appiumLibrary.click(curriculumBAckButton);


    }
}
