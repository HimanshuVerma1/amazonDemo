package com.test.amazon;

import com.main.test.BaseTest;

public class AmazonBaseScript extends BaseTest {

	/*
	 * Constant variable for app package and activity
	 */
	public static final String APP_PACKAGE = "com.amazon.mShop.android.shopping";
	public static final String APP_ACTIVITY = "com.amazon.mShop.splashscreen.StartupActivity";
	public static final String APK_PATH = System.getProperty("user.dir") + "\\TestAPK\\Amazon_shopping.apk";

	public AmazonBaseScript() {
		super(APP_PACKAGE, APP_ACTIVITY, APK_PATH);
	}
}
