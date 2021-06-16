package com.splashlearn.app.screens.ios;

import com.splashlearn.app.library.AppiumLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ContentGroupPage extends BasePage {
    public ContentGroupPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Set as Focus Area\"]")
    private MobileElement setAsFocusArea;

    @iOSXCUITFindBy(accessibility = "curriculumBackButton")
    private MobileElement contentBackButton;


    public void clickSetAsFocusArea() {
        appiumLibrary.click(setAsFocusArea);
    }

    public void clickContentBackButton() {
        appiumLibrary.click(contentBackButton);
    }


    public List<String> getPlayableNames() {
        List<MobileElement> e = driver.findElements(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText"));
        List<String> names = new ArrayList<>();
        for (MobileElement m : e)
            names.add(m.getAttribute("name"));
        System.out.println("Playable name are: " + names);
        return names;
    }

}
