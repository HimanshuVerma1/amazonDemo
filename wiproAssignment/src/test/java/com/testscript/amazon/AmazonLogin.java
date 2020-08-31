package com.testscript.amazon;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.main.utility.FileUtility;
import com.test.amazon.AmazonBaseScript;
import com.test.amazon.AmazonHomePage;
import com.test.amazon.AmazonProductPage;
import com.test.amazon.AmazonSearchPage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AmazonLogin extends AmazonBaseScript {

	private AmazonHomePage amazonHomePage;
	private AmazonSearchPage amazonSearchPage;
	private AmazonProductPage amazonProductPage;
	private FileUtility fileUtility;
	private JsonObject jsonObject;
	private String testDataFile = System.getProperty("user.dir")
			+ "\\TestData\\AmazonLogin.json";

	public AmazonLogin() {
		super();
	}

	@Test(description = "Login to amazon mobile application and search for an item and add to cart and purchase it")
	public void amazonLoginTest() throws IOException, InterruptedException {

		init();

		String userName = fileUtility.getValue(jsonObject, "username");
		String password = fileUtility.getValue(jsonObject, "password");
		String productToSearch = fileUtility.getValue(jsonObject, "searchProduct");

		log.info("Check if login page is displayed");
		if (amazonHomePage.isOnSignInPage()) {
			log.info("Login to amazon app");
			amazonHomePage.loginToAmazon(userName, password);
		}

		log.info("Check if amazon home page displayed");
		Assert.assertTrue(amazonHomePage.isOnHomePage(), "Check if amazon home page displayed");

		amazonSearchPage.searchProduct(productToSearch);
		Assert.assertTrue(amazonSearchPage.isSearchedResultPresent(), "Check if searched product showing some results");

		log.info("Scroll and select searched product");
		amazonSearchPage.scrollAndSelectSearchedProduct();

		Assert.assertTrue(amazonProductPage.isOnProductPage(), "Check if product page is displayed");

		log.info("Product brand name : [{}]",amazonProductPage.getProductBrand());

		log.info("Product description : [{}]", amazonProductPage.getProductDesctiption());

		log.info("Product Price : [{}]", amazonProductPage.getProductPrice());

		Assert.assertTrue(amazonProductPage.isBuyNowButtonVisble(), "Check if Buy Now button is visible on selected product");

		log.info("Click on buy now button of product");
		amazonProductPage.clickOnBuyNowButton();
	}

	/**
	 * Initialize all the classes objects
	 */
	private void init() {
		amazonHomePage = new AmazonHomePage();
		amazonSearchPage = new AmazonSearchPage();
		amazonProductPage = new AmazonProductPage();
		fileUtility = new FileUtility();
		jsonObject = fileUtility.parseJsonFileToRead(testDataFile);
	}

}
