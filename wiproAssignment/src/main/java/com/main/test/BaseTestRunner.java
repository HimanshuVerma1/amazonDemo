package com.main.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseTestRunner {

	protected AppiumDriverLocalService service;
	protected AppiumServiceBuilder builder;

	@BeforeTest
    public void startAppiumServer() {
		builder = new AppiumServiceBuilder();
		builder.usingAnyFreePort();
		builder.withIPAddress("127.0.0.1");
		builder.withArgument(GeneralServerFlag.LOG_TIMESTAMP)
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE);
		service = AppiumDriverLocalService.buildService(builder);
		service.start();
    }

	@AfterTest(alwaysRun = true)
	public void globalTearDown() {
        service.stop();
    }
}
