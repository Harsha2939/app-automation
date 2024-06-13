package com.qf.androidautomation.utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.appium.java_client.android.AndroidDriver;

public class WebDriverWait {
	
	AndroidDriver driver = new AndroidDriver(null);
	
//    public static void waitForVisibility(AppiumDriver<MobileElement> driver, AndroidElement element) {
//        WebDriverWait wait = new WebDriverWait(driver, 30); 
//
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }
    
    Wait<AndroidDriver> wait = new FluentWait<AndroidDriver>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class);

}
