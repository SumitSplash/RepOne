package com.splashlearn.app.library;

import static com.splashlearn.app.util.PropertiesFileReader.getPropertiesFromFile;

import java.net.MalformedURLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.splashlearn.app.model.Device;
import com.splashlearn.app.util.SplashLearnAutomationEnvironmentConfig;
import com.splashlearn.app.util.SplashMathConstants;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DeviceFactory extends DriverInitializer {

	private final Logger logger = LogManager.getRootLogger();
	private static DeviceFactory deviceFactory = null;
	private final BlockingQueue<Device> queue;
	private final String devicePropertiesPath = System.getProperty("user.dir") + "/src/test/resources/devices/";

	private final String runType = SplashLearnAutomationEnvironmentConfig.getInstance().getRunType();
	private final String deviceConnected = SplashLearnAutomationEnvironmentConfig.getInstance().getDeviceConnected();
	private final boolean staticSetup = SplashLearnAutomationEnvironmentConfig.getInstance().getStaticSetup();

	private final AtomicInteger counter = new AtomicInteger(0);

	private final String androidPropertyFileFormat = "android_%s.properties";
	private final String iosPropertyFileFormat = "ios_%s.properties";

	public enum Property {
		UDID("udid"), XCODEORGID("xcodeOrg.Id"), DEVICETYPE("device.type"), PLATFORMVERSION("platform.version"),
		USENEWWDA("useNewWDA"), XCODESIGNINID("xcodeSigningId"), DEVICENAME("device.name"),
		PLATFORMNAME("platform.name"), AUTOMATIONNAME("automation.Name"), APPACTIVITY("app_activity"),
		APPPACKAGE("app_package");

		private final String propertyValue;

		Property(final String property) {
			this.propertyValue = property;
		}

		@Override
		public String toString() {
			return propertyValue;
		}

	}

	private DeviceFactory(int s) {
		queue = new LinkedBlockingQueue<>();
	}

	public static synchronized DeviceFactory setInstance(int s) {
		if (deviceFactory == null) {
			deviceFactory = new DeviceFactory(s);
		}
		return deviceFactory;
	}

	public static DeviceFactory getInstance() {
		return deviceFactory;
	}

	public Device getDevice(String os, int number) throws MalformedURLException {
		Device device;
		if (queue.isEmpty()) {
			device = buildDevice(os, number);
		} else {
			device = queue.remove();
			device.reset();
		}
		return device;
	}

	private Device buildDevice(String os, int number) throws MalformedURLException {
		AppiumDriver<MobileElement> driver = null;

		if (staticSetup) { // Should only be used when runType = local
			String devicePropertyFileDirectory = devicePropertiesPath
					+ (deviceConnected.equalsIgnoreCase("pcloudy") ? "/pcloudy/" : "");

			driver = os.equalsIgnoreCase(SplashMathConstants.OSType.IOS.toString())
					? setIOsDriver(getPropertiesFromFile(devicePropertyFileDirectory
							+ String.format(iosPropertyFileFormat, counter.incrementAndGet())), deviceConnected)
					: setAndroidDriver(
							getPropertiesFromFile(devicePropertyFileDirectory
									+ String.format(androidPropertyFileFormat, counter.incrementAndGet())),
							deviceConnected, number);
		} else {
			if (runType.equalsIgnoreCase("jenkins")) {
				//
			} else { // local

			}
		}
		return new Device(os, deviceConnected, driver);
	}

	public void addDeviceToQueue(Device device) {
		if (device == null) {
			return;
		}
		queue.add(device);
		logger.debug("Device {} added to queue.", device.getId());
	}

	public void destroy() {
		while (!queue.isEmpty()) {
			queue.remove().close();
		}
	}

}
