package com.main.adb.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;

import io.appium.java_client.android.nativekey.AndroidKey;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdbDeviceCommand {

	/**
	 * Execute adb command and get the execution result
	 *
	 * @param commandToExecute
	 *            ADB command to execute on device
	 * @return result of execution
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String executeCommand(String commandToExecute) throws IOException, InterruptedException {
		log.info("Command to execute : {}", commandToExecute);
		Preconditions.checkNotNull(commandToExecute);

		Process process = Runtime.getRuntime().exec(commandToExecute);
		process.waitFor(5, TimeUnit.SECONDS);

		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

		String line = "";
		ArrayList<String> listOutput = new ArrayList<String>();

		while ((line = reader.readLine()) != null) {
			listOutput.add(line);
			log.info(line);
		}
		return StringUtils.join(listOutput);
	}

	public void pressKeyUsingAdb(AndroidKey key) throws IOException, InterruptedException {
		String command = String.format("adb shell keyevent %s", String.valueOf(key.getCode()));
		executeCommand(command);
	}

}
