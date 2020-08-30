package com.main.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.main.test.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;


public class UtilityCommand {

	/**
	 * Wait for visibility of element and return true if visible and false if
	 * not visible
	 *
	 * @param element
	 *            element to wait for visible
	 * @param waitTime
	 *            wait time to wait for element visible
	 * @return true if element visible within the wait time else false
	 */
	public static boolean isElementVisibleInTime(MobileElement element, int waitTime) {
		try {
			new WebDriverWait(BaseTest.getDriver(), waitTime)
					.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Wait for element visibility
	 *
	 * @param element
	 *            element to wait for visible
	 * @param waitTime
	 *            time to wait for element visible
	 * @return return Element will return if visible else throw exception
	 */
	public static MobileElement waitVisible(MobileElement element, int waitTime) {
		new WebDriverWait(BaseTest.getDriver(), waitTime)
				.ignoring(StaleElementReferenceException.class, NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	/**
	 * Click on element when visible
	 *
	 * @param element
	 *            element to click on
	 * @param waitTime
	 *            wait time for element visible
	 */
	public static void clickWhenVisible(MobileElement element, int waitTime) {
		waitVisible(element, waitTime).click();
	}

	/**
	 * Send-keys in the located text box
	 *
	 * @param element
	 *            element to locate
	 * @param waitTime
	 *            wait time for element visibility
	 * @param sendKeys
	 *            text to send
	 */
	public static void sendKeysWhenVisible(MobileElement element, int waitTime, String sendKeys) {
		waitVisible(element, waitTime).sendKeys(sendKeys);
	}

	/**
	 * Click on element when click-able
	 *
	 * @param element
	 *            element to locate and click
	 * @param waitTime
	 *            wait time for element visibility
	 */
	public void clickWhenClickable(MobileElement element, int waitTime) {
		new WebDriverWait(BaseTest.getDriver(), waitTime)
				.until(ExpectedConditions.elementToBeClickable(element))
				.click();
	}

	public static void pressKey(KeyEvent key) {
		PressesKey press = new PressKey();
		press.pressKey(key);
	}
	public static void createTextFile(String textToWrite, String pathToSaveOutputFile) throws IOException {
		FileWriter writer = new FileWriter(new File(pathToSaveOutputFile));
		writer.write(textToWrite);
		writer.close();
	}
}
