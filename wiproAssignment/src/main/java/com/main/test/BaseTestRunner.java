package com.main.test;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
		builder.withLogFile(new File(getLogOutputPath()));
		builder.withArgument(GeneralServerFlag.LOG_TIMESTAMP)
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE);
		service = AppiumDriverLocalService.buildService(builder);
		service.start();
    }

	@AfterTest(alwaysRun = true)
	public void globalTearDown() {
        service.stop();
    }

	private String getLogOutputPath() {
    	return String.format(System.getProperty("user.dir") + "\\TestOutputLog\\testlog_%s.log",
    			LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-mm-yy hh:mm:ss")));
    }
}
