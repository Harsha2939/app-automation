package com.qf.androidautomation.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qf.androidautomation.manager.SetUpManager;
import com.qf.androidautomation.utils.ScreenShot;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class LogoutObjects {
	
	AndroidDriver androidDriver = SetUpManager.androidDriverManager();

	WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(60));
	
	ScreenShot screenShot = new ScreenShot();

	private By myProfileMenu = By.xpath(
			"//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup");
	private By logout = By.xpath("//android.widget.TextView[@text='Logout']");
	private By logoutoption = By.xpath("(//android.widget.TextView[@text=\"Log Out\"])[2]");
	private By headingNameVerification = By.xpath("//android.widget.TextView[@text='Welcome back,']");

	public void profileMenu() throws InterruptedException {
		Thread.sleep(2000);
		androidDriver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
		WebElement profileMenu = androidDriver.findElement(myProfileMenu);
		profileMenu.click();
	}

	public void logout() {
		WebElement logoutfunctionality = androidDriver.findElement(logout);
		logoutfunctionality.click();
	}

	public void logoutOptions() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(logoutoption));
		WebElement logoutfunctionality = androidDriver.findElement(logoutoption);
		Thread.sleep(2000);
		screenShot.takeScreenShot(androidDriver, "log-out");
		logoutfunctionality.click();

	}

	public String isHeading() {
		WebElement headingName = androidDriver.findElement(headingNameVerification);
		return headingName.getText();
	}

	public void isHeadingNameVerification() throws InterruptedException {
		Thread.sleep(2000);
		String expectedXpath = "Welcome back,";
		String actualXpath = isHeading();
		try {
			Assert.assertEquals(actualXpath, expectedXpath, "Locator mismatch!");
			System.out.println("Heading Text: " + actualXpath);
		} catch (AssertionError e) {
			System.out.println("Assertion failed: " + e.getMessage());
		}
	}

}
