package com.qf.androidautomation.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qf.androidautomation.manager.SetUpManager;

import io.appium.java_client.android.AndroidDriver;

public class LocationPermission {

	AndroidDriver androidDriver = SetUpManager.androidDriverManager();

	WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(20));

	private By locationPermission = By
			.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");

	public void locationPermission() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locationPermission));
			WebElement premission = androidDriver.findElement(locationPermission);
			if (premission.isDisplayed()) {
				premission.click();
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
