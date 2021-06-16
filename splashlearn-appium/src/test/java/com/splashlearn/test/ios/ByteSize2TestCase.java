package com.splashlearn.test.ios;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.splashlearn.app.library.DeviceFactory;
import com.splashlearn.app.library.TeacherLibrary;
import com.splashlearn.app.model.Device;
import com.splashlearn.test.Hooks;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ByteSize2TestCase extends Hooks {

	@Test
	public void Login() throws MalformedURLException {
		Device device = DeviceFactory.getInstance().getDevice("ios", 8217);
		deviceThreadLocal.set(device);
		AppiumDriver<MobileElement> driver = device.getDriver();
		System.out.println(driver.getCapabilities().getCapability("udid"));
		new TeacherLibrary(driver).login();
	}

//	@Test(priority = 2)
//	public void Dashboard_Learning_Path_Button_Display() {
//		TeacherLibrary.Dashboard_Learning_Path_Button_Display();
//	}
//
//	@Test(priority = 3)
//	public void Dashboard_Math_Facts_Button_Display() {
//		TeacherLibrary.Dashboard_Math_Facts_Button_Display();
//	}
//
//	@Test(priority = 4)
//	public void Dashboard_Reports_Button_Display()  {
//		TeacherLibrary.Dashboard_Reports_Button_Display();
//	}
//
//	@Test(priority = 5)
//	public void Dashboard_Menu_Button_Display() {
//		TeacherLibrary.Dashboard_Menu_Button_Display();
//	}
//
//	@Test(priority = 6)
//	public void Dashboard_Curriculum_Tab_Display() {
//		TeacherLibrary.Dashboard_Curriculum_Tab_Display();
//	}
//
//	@Test(priority = 7)
//	public void Dashboard_Learning_Tab_Display() {
//		TeacherLibrary.Dashboard_Learning_Tab_Display();
//	}
//
//	@Test(priority = 8)
//	public void Dashboard_Child_Name_Child_Grade_Display() {
//		TeacherLibrary.Dashboard_Learning_Tab_Display();
//	}
//
//	@Test(priority = 9)
//	public void Learning_Path_screen_Display() {
//		TeacherLibrary.Learning_Path_screen_Display();
//	}
//
//	@Test(priority = 10)
//	public void Learning_Path_Daily_Cards_Scrolling() {
//		TeacherLibrary.Learning_Path_Daily_Cards_Scrolling();
//	}
//
//	@Test(priority = 11)
//	public void Learning_Path_1st_Daily_Cards_Play_All_Question(){
//		TeacherLibrary.Learning_Path_1st_Daily_Cards_Play_All_Question();
//	}
//
//	@Test(priority = 12)
//	public void Learning_Path_1st_Card_Completion_Popup_Displayed() {
//		TeacherLibrary.Learning_Path_1st_Card_Completion_Popup_Displayed();
//	}
//	@Test(priority = 13)
//	public void Learning_Path_2nd_Daily_Cards_Play_All_Question() {
//		TeacherLibrary.Learning_Path_2nd_Daily_Cards_Play_All_Question();
//	}
//
//	@Test(priority = 14)
//	public void Learning_Path_2nd_Daily_Completion_pitchstop() {
//		TeacherLibrary.Learning_Path_2nd_Daily_Completion_pitchstop();
//	}
//	@Test(priority = 15)
//	public void Learning_Path_3rd_Daily_Cards_Play_All_Question() {
//		TeacherLibrary.Learning_Path_3rd_Daily_Cards_Play_All_Question();
//	}
//
//	@Test(priority = 16)
//	public void Learning_Path_3rd_Card_Completion_pitstop() {
//		TeacherLibrary.Learning_Path_3rd_Card_Completion_pitstop();
//	}
//	@Test(priority = 17)
//	public void Learning_Path_pet_Congratulation_pitstop() {
//		TeacherLibrary.Learning_Path_pet_Congratulation_pitstop();
//	}
//
//	@Test(priority = 18)
//	public void Learning_Path_pet_Play_Now_pitstop()throws InterruptedException {
//		TeacherLibrary.Learning_Path_pet_Play_Now_pitstop();
//	}

}
