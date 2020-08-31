package com.main.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.common.base.Preconditions;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileUtility {

	/**
	 * Method to read the json file
	 *
	 * @param filePath
	 * @return
	 */
	public JsonObject parseJsonFileToRead(String filePath) {
		Preconditions.checkNotNull(filePath);
		JsonParser parser = new JsonParser();

		try {
			Object object = parser.parse(new FileReader(filePath));
			JsonObject jsonObject = (JsonObject) object;
			return jsonObject;

		} catch (FileNotFoundException e) {
			log.error(e.getStackTrace().toString());
		} catch (Exception e) {
			log.error(e.getStackTrace().toString());
		}
		return null;
	}

	public String getValue(JsonObject jsonObject, String jsonArrayKey) {
		Preconditions.checkNotNull(jsonObject, "Json object is null hence cannot get the data");
		return jsonObject.get(jsonArrayKey).toString().replaceAll("\"", "");
	}
}
