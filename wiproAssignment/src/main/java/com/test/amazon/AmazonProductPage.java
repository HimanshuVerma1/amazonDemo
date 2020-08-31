package com.test.amazon;

import com.main.test.BasePage;
import com.main.utility.UtilityCommand;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;

public class AmazonProductPage extends BasePage {

	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector()."
			+ "resourceIdMatches(\"buyNowCheckout|buyNow|buyNow_feature_div\"))")
	private MobileElement buyNowButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"priceblock_ourprice\")")
	private MobileElement productPrice;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"bylineInfo\")")
	private MobileElement productBrand;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"title\")")
	private MobileElement productTitle;

	@HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"title\")")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"image-block-row\")")
	private MobileElement productPage;

	public boolean isOnProductPage() {
		return UtilityCommand.isElementVisibleInTime(productPage, 30);
	}

	public String getProductDesctiption() {
		return UtilityCommand.waitVisible(productTitle, 30).getText();
	}

	public String getProductBrand() {
		return UtilityCommand.waitVisible(productBrand, 30).getAttribute("content-desc");
	}

	public String getProductPrice() {
		return UtilityCommand.waitVisible(productPrice, 30).getText();
	}

	public boolean isBuyNowButtonVisble() {
		return UtilityCommand.isElementVisibleInTime(buyNowButton, 20);
	}

	public void clickOnBuyNowButton() {
		UtilityCommand.clickWhenVisible(buyNowButton, 20);
	}
}
