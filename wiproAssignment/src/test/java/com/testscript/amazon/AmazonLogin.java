package com.testscript.amazon;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.main.test.BaseTest;
import com.test.amazon.AmazonHomePage;
import com.test.amazon.AmazonSearchPage;

public class AmazonLogin extends BaseTest {

	private AmazonHomePage amazonHomePage;
	private AmazonSearchPage amazonSearchPage;

	public AmazonLogin() {
		super(AmazonHomePage.APP_PACKAGE, AmazonHomePage.APP_ACTIVITY);
	}

	@Test(description = "Login to amazon mobile application and search for an item and add to cart and purchase it")
	public void amazonLoginTest() throws IOException, InterruptedException {
		init();

		if (amazonHomePage.isOnSignInPage()) {
			amazonHomePage.loginToAmazon("8909043740", "Password@123#");
		}

		Assert.assertTrue(amazonHomePage.isOnHomePage(), "Check if user is on home page of the Amazon app");

		amazonSearchPage.searchProduct("65 inch TV");
		Assert.assertTrue(amazonSearchPage.isSearchedResultPresent(), "Check if searched product showing some results");

	}

	private void init() {
		amazonHomePage = new AmazonHomePage();
		amazonSearchPage = new AmazonSearchPage();
	}

}
