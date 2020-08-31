package com.main.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.main.listeners.WebDriverEventLogger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseTest extends BaseTestRunner {

	public static AppiumDriver<MobileElement> driver;

	private String APP_PACKAGE;
	private String APP_ACTIVITY;
	private String APP_Path;

	public BaseTest(String appPackage, String appActivity, String appPath) {
		this.APP_PACKAGE = appPackage;
		this.APP_ACTIVITY = appActivity;
		this.APP_Path = appPath;
	}

	@Parameters({"DeviceUDID", "PlatformVersion"})
	@BeforeClass
	public void startAppiumSession(String deviceUDID, String platformVersion) throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = getCapabilities(deviceUDID, platformVersion);

		driver = new AndroidDriver<MobileElement>(new URL(service.getUrl().toString()), desiredCapabilities);

		driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new WebDriverEventLogger());
    }

	private DesiredCapabilities getCapabilities(String deviceUDID, String platformVersion) {
        DesiredCapabilities desiredCap = new DesiredCapabilities();
        desiredCap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
		desiredCap.setCapability(MobileCapabilityType.UDID, deviceUDID);
        desiredCap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE);
		desiredCap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
        desiredCap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        desiredCap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "600");
		desiredCap.setCapability(MobileCapabilityType.NO_RESET, true);
		desiredCap.setCapability(MobileCapabilityType.FULL_RESET, false);
		desiredCap.setCapability(MobileCapabilityType.APP, APP_Path);

        return desiredCap;
    }

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		log.info("Quit driver");
		driver.quit();
    }

    /**
     * Get the driver instance
     */
    public static AppiumDriver<MobileElement> getDriver(){
        return driver;
    }
}
