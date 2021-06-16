package com.splashlearn.app.screens.ios;

import com.splashlearn.app.library.AppiumLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class WorksheetPage extends BasePage {
    public WorksheetPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "Nah! Play anyway")
    private MobileElement playAnyway;

    @iOSXCUITFindBy(accessibility = "QPPause")
    private MobileElement pauseWorksheet;

    @iOSXCUITFindBy(accessibility = "QPHome")
    private MobileElement homeWorksheet;

    public void clickPause() {
        appiumLibrary.click(pauseWorksheet);
    }

    public void clickPlayAnyway() {
        appiumLibrary.click(playAnyway);
    }

    public void clickHome() {
        appiumLibrary.click(homeWorksheet);
    }

}
