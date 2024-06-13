package com.qf.androidautomation.manager;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import com.qf.androidautomation.utils.Config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

/**
 * The Class SetUpManager.
 */
public class SetUpManager {

	/** The android driver. */
	public static AndroidDriver androidDriver;

	/** The server. */
	public static AppiumDriverLocalService server;

	/**
	 * Android driver manager.
	 *
	 * @return the android driver
	 */
	public static AndroidDriver androidDriverManager() {
		if (androidDriver == null) {
			try {
				Config configProperty = new Config();
				UiAutomator2Options automator = new UiAutomator2Options();
				automator.setDeviceName(configProperty.getProperty("android.devicename"));
				automator.setApp(configProperty.getProperty("app.path"));
				automator.setPlatformName(configProperty.getProperty("android.platform"));

				androidDriver = new AndroidDriver(new URL(configProperty.getProperty("appium.server")), automator);
				androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
				Thread.sleep(3000);
			} catch (MalformedURLException | InterruptedException e) {
				e.printStackTrace();
			}
		}
		return androidDriver;
	}

	/**
	 * Appium manager.
	 *
	 * @return the appium driver local service
	 */
	public static AppiumDriverLocalService appiumManager() {
		// PortKiller.killPort(4723);
		Config configProperty = new Config();
		AppiumDriverLocalService service = new AppiumServiceBuilder()
				.withAppiumJS(new File(configProperty.getProperty("appium.main")))
				.withIPAddress(configProperty.getProperty("appium.ipaddress")).usingPort(4723).build();
		service.start();
		return service;
	}

	/**
	 * Server teardown.
	 *
	 * @return the appium driver local service
	 */
	public static void serverTeardown() {
		appiumManager().stop();
	}

	/**
	 * Tear down.
	 *
	 * @return the android driver
	 */
	public static void tearDown() {
		androidDriverManager().quit();
	}
}
