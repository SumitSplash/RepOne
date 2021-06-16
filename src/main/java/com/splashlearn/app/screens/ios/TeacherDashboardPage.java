package com.splashlearn.app.screens.ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;


public class TeacherDashboardPage extends BasePage {
    public TeacherDashboardPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"SPTeacherChooseClassBg”])[1]")
    private MobileElement classOne;

    public List<String> getClassNames() {
        List<MobileElement> allClasses = driver.findElements(By.name("SPTeacherChooseClassBg"));
        List<String> classNames = new ArrayList<>();
        for (MobileElement c : allClasses) {
            classNames.add(c.findElement(By.xpath(".//following-sibling::XCUIElementTypeStaticText[1]")).getAttribute("name"));
        }
        return classNames;
    }

    public int getClassCount() {
        return getClassNames().size();
    }


    public void switchToClass(String s) {
        driver.findElement(By.xpath("(//XCUIElementTypeImage[@name=\"SPTeacherChooseClassBg”])[2]")).click();
    }


}
