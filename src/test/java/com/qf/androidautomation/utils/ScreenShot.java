package com.qf.androidautomation.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.android.AndroidDriver;

public class ScreenShot {

	public void takeScreenShot(AndroidDriver driver, String screenshotName) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");
		String presentDate = dateFormat.format(new Date());
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.move(screenshot.toPath(), new File("./Screenshots/" + screenshotName + "-" + presentDate + ".png").toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}