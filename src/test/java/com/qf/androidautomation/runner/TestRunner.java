package com.qf.androidautomation.runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.qf.androidautomation.manager.SetUpManager;
import com.qf.androidautomation.utils.EmailReports;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * The Class TestRunner.
 */
@CucumberOptions(features = "classes/features", 
				glue = {"com.qf.androidautomation.stepdefnitions" }, 
//				tags = "@password or @languagechange", 
				plugin = { "pretty", "html:target/cucumber.html" })
public class TestRunner extends AbstractTestNGCucumberTests {

	/**
	 * Sets the up.
	 */
	@BeforeSuite
	public void setUp() {
		// SetUpManager.appiumManager();
		SetUpManager.androidDriverManager();
	}

	/**
	 * Tear down.
	 * 
	 * @throws InterruptedException
	 */
	@AfterSuite
	public void tearDown() {
		SetUpManager.tearDown();
		 EmailReports.sendMail();
		// SetUpManager.serverTeardown();
	}

}
