// TODO: remove this file

//package com.splashlearn.test;
//
//import java.lang.reflect.Method;
//import java.net.MalformedURLException;
////import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Optional;
//import org.testng.annotations.Parameters;
//
//import com.splashlearn.app.library.DeviceFactory;
//import com.splashlearn.app.library.DeviceFactoryAndroid;
////import com.splashlearn.app.util.PropertiesFileReader;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;
//
//public class HooksAndroid {
//
//	protected ThreadLocal<String> testName = new ThreadLocal<>();
//    protected AppiumDriver<MobileElement> driver;
//
//
//    @BeforeMethod
//	@Parameters(value = { "Device" })
//	public void before(@Optional String device, Method method) throws MalformedURLException {
//		DeviceFactoryAndroid.getInstance().setAndroidriver(device);
//		driver = DeviceFactoryAndroid.getInstance().getDriver();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		testName.set(method.getName());
//	}
//	@AfterMethod
//	public void afterAll() {
//		DeviceFactoryAndroid.getInstance().close();
//		DeviceFactoryAndroid.tearDown();
//	}
//}