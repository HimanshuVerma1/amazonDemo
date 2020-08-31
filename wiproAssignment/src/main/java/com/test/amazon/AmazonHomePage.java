package com.test.amazon;

import com.main.test.BasePage;
import com.main.utility.UtilityCommand;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AmazonHomePage extends BasePage {

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Already a customer? Sign in\")")
	private MobileElement signInButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"ap_email_login\")")
	private MobileElement emailIdTextBox;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"ap_password\")")
	private MobileElement passwordTextBox;

	@AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"(?i)Continue\")")
	private MobileElement continueButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"(?i)Login\").className(\"android.widget.Button\")")
	private MobileElement loginButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/rs_search_src_text\")")
	private MobileElement searchTextBox;

	public boolean isOnSignInPage() {
		return UtilityCommand.isElementVisibleInTime(signInButton, 10);
	}

	public void loginToAmazon(String userName, String password) {
		UtilityCommand.clickWhenVisible(signInButton, 10);

		UtilityCommand.sendKeysWhenVisible(emailIdTextBox, 10, userName);
		UtilityCommand.clickWhenVisible(continueButton, 10);

		UtilityCommand.sendKeysWhenVisible(passwordTextBox, 30, password);
		UtilityCommand.clickWhenVisible(loginButton, 10);
	}

	public boolean isOnHomePage() {
		return UtilityCommand.isElementVisibleInTime(searchTextBox, 30);
	}
}
