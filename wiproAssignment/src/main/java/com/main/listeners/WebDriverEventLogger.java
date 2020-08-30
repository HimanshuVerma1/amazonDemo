package com.main.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.events.api.general.AppiumWebDriverEventListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebDriverEventLogger implements AppiumWebDriverEventListener {

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		log.info("Looking for element : {} {}", String.valueOf(element), by.toString());

	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		 log.info("Found element {} {}", String.valueOf(element), by.toString());

	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		log.info("Clicking on element : {}", String.valueOf(element));

	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		log.info("Found element to click : {}", String.valueOf(element));

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver,
			CharSequence[] keysToSend) {
		log.info("Typing [{}] in {}", keysToSend, String.valueOf(element));

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver,
			CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub

	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub

	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterGetText(WebElement element, WebDriver driver,
			String text) {
		log.info("Text get [{}] from element {}", element.getText(), String.valueOf(element));

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

}
