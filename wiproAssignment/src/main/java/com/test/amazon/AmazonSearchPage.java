package com.test.amazon;

import java.io.IOException;

import org.openqa.selenium.Keys;

import com.main.test.BasePage;
import com.main.utility.UtilityCommand;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AmazonSearchPage extends BasePage {

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/rs_search_src_text\")")
	private MobileElement searchTextBox;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Results\")")
	private MobileElement resultsText;

	public void searchProduct(String searchProductName) throws IOException, InterruptedException {
		log.info("Search for the product {}", searchProductName);
		UtilityCommand.clickWhenVisible(searchTextBox, 10);
		UtilityCommand.sendKeysWhenVisible(searchTextBox, 10, searchProductName);
		UtilityCommand.pressKeyUsingKeyBoard(Keys.ENTER);
	}

	public boolean isSearchedResultPresent() {
		return UtilityCommand.isElementVisibleInTime(resultsText, 30);
	}
}
