package com.splashlearn.app.screens.ios;

import com.splashlearn.app.library.AppiumLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.System.out;


public class ChangeProfilePage extends BasePage {
    
    public ChangeProfilePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "Change Profile")
    private MobileElement changeProfile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"K-5 Splash Math\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeButton")
    private MobileElement secondChild;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"K-5 Splash Math\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeButton[1]")
    private MobileElement addPlayer;

    @iOSXCUITFindBy(accessibility = "NameFieldAddChild")
    private MobileElement name;

    @iOSXCUITFindBy(accessibility = "Next")
    private MobileElement next;

    @iOSXCUITFindBy(accessibility = "BoyButton")
    private MobileElement boy;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"SplashLearn\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
    private MobileElement enterChildName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
    private MobileElement doneEnterChildName;


    public void clickChangeProfile() {
        appiumLibrary.click(changeProfile);
    }

    public void clickSecondChild() {
        appiumLibrary.click(secondChild);
    }

    public List<String> getChildName() {
        List<MobileElement> e = driver.findElements(By.xpath("//XCUIElementTypeImage[@name='CSUnSelectedAvatar' or @name='CSSelectedAvatar']/following-sibling::XCUIElementTypeStaticText[1]"));
        List<String> names = new ArrayList<>();
        for (MobileElement m : e)
            names.add(m.getAttribute("name"));
        out.println("Names are:" + names);
        return names;
    }


    public int getChildCount() {
        int childCount = getChildName().size();
        out.println("Child Count is:" + childCount);
        if (childCount <= 1) {
            Assert.fail("User has only one child, So can not proceed further");
        }
        return childCount;
    }

    public void switchToChild(String s) {
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + s + "']/parent::XCUIElementTypeOther")).click();
    }

    public void clickAddPlayer() {
        appiumLibrary.click(addPlayer);
    }

    public String addChildName(String name) {
        appiumLibrary.enterText(this.name, name);
        appiumLibrary.click(doneEnterChildName);
        return name;
    }

    public String enterChildName(String name) {
        appiumLibrary.enterText(this.enterChildName, name);
        if (appiumLibrary.isElementPresent(doneEnterChildName, 1)) {
            appiumLibrary.click(doneEnterChildName);
        }
        driver.hideKeyboard();
        return name;
    }

    public void clickDoneAddChild() {
        appiumLibrary.click(doneEnterChildName);
    }

    public void clickBoy() {
        appiumLibrary.click(boy);
    }

    public void childPersona() {
        List<String> options = new ArrayList<>();
        options.add("Avoids it");
        options.add("Loves it");
        options.add("Indifferent");
        Random rand = new Random();
        String option = options.get(rand.nextInt(options.size()));
        appiumLibrary.click(MobileBy.AccessibilityId(option));
        out.println((option));
    }

    public void isChildPresent() {
        appiumLibrary.click(By.xpath("//XCUIElementTypeStaticText[@name=\"Add Player\"]/parent::XCUIElementTypeButton/parent::XCUIElementTypeOther"));
    }

    public String getSelectedChildName(String s) {
        String name = appiumLibrary.getText(By.xpath("//XCUIElementTypeImage[@name='CSSelectedAvatar']/following-sibling::XCUIElementTypeStaticText[1]"));
        out.println("Selected Child Name is: " + name);
        return name;
    }

    public String getSelectedChildName() {
        return appiumLibrary.getText(By.xpath("//XCUIElementTypeImage[@name='CSSelectedAvatar']/following-sibling::XCUIElementTypeStaticText[1]"));
    }
}
