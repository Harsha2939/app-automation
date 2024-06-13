package com.qf.androidautomation.utils;

import java.util.Random;

public class PasswordGenerator {

	public String password() {
		String staticPrefix = "Aa";
		String staticSuffix = "@";
		String dynamicNumber = generateRandomNumber();
		String generatedString = staticPrefix + dynamicNumber + staticSuffix;
		return generatedString;
	}

	private static String generateRandomNumber() {
		Random random = new Random();
		int randomNumber = 100000 + random.nextInt(900000);
		return String.valueOf(randomNumber);
	}

}
