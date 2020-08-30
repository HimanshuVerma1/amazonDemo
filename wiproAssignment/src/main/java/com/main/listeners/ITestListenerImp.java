package com.main.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ITestListenerImp implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		log.info("Script [{}] is failed due to : \n{}", result.getName(),
				result.getThrowable().getStackTrace());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		log.info("Starting test [{}]", context.getName());

	}

	public void onFinish(ITestContext context) {
		log.info("[{}] is completed", context.getName());

	}

}
