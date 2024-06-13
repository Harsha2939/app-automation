package com.qf.androidautomation.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * The Class Config.
 */
public class Config {

	/**
	 * Gets the property.
	 *
	 * @param Key the key
	 * @return the property
	 */
	public String getProperty(String Key) {
		String directory = System.getProperty("user.dir");

		String filePath = directory + "/target/classes/config.properties";
		File file = new File(filePath);
		Properties properties = null;
		try {
			FileReader fileReader = new FileReader(file);
			properties = new Properties();
			properties.load(fileReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(Key);
	}
	
	public String getSendKeys(String Key) {
		String directory = System.getProperty("user.dir");

		String filePath = directory + "/classes/sendkeys.properties";
		
		File file = new File(filePath);
		Properties properties = null;
		try {
			FileReader fileReader = new FileReader(file);
			properties = new Properties();
			properties.load(fileReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(Key);
	}
}
