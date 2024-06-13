package com.qf.androidautomation.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qf.androidautomation.manager.SetUpManager;
import com.qf.androidautomation.utils.Config;
import io.appium.java_client.android.AndroidDriver;

public class ContractSignAndConfirmOTPObjects {

	AndroidDriver androidDriver = SetUpManager.androidDriverManager();

	Config configProperty = new Config();

	WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(60));

	private By submittedFeild = By.xpath("//android.widget.TextView[@text=\"Submitted\"]");
//	private By congratsFeild = By.xpath("//android.widget.TextView[@text=\"Congratulations!\"]");
	private By proceedButton = By.xpath("//android.widget.TextView[@text=\"Proceed\"]");
	private By contractSign = By.xpath(
			"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]");
	private By signTheContract = By.xpath("(//android.widget.TextView[@text=\"Sign the Contract\"])[1]");
	private By contractConfrimCheckBox = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup");
	private By contractConforimButton = By
			.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]");
	private By otpFeild = By.xpath(
			"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]");
	private By confirmendFeild = By.xpath("//android.widget.TextView[@text=\"Confirmed\"]");
	private By verifiedFeild = By.xpath("//android.widget.TextView[@text=\"Verified\"]");
	private By congratulationFeild = By.xpath("//android.widget.TextView[@text=\"Congratulations!\"]");
	private By continueButton = By.xpath("//android.widget.TextView[@text=\"Proceed\"]");

	public void bankAccountDetailsSubmit() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(submittedFeild));
			WebElement submittFeild = androidDriver.findElement(submittedFeild);
			if (submittFeild.isDisplayed()) {
				System.out.println("Submit back account details");
				wait.until(ExpectedConditions.visibilityOfElementLocated(proceedButton));
				WebElement submittButton = androidDriver.findElement(proceedButton);
				submittButton.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void confirmedCall() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(confirmendFeild));
			WebElement confirmend = androidDriver.findElement(confirmendFeild);
			wait.until(ExpectedConditions.visibilityOfElementLocated(congratulationFeild));
			WebElement congratulation = androidDriver.findElement(congratulationFeild);
			if (confirmend.isDisplayed() || congratulation.isDisplayed()) {
				System.out.println("User recived confirmation call");
				wait.until(ExpectedConditions.visibilityOfElementLocated(proceedButton));
				WebElement submittButton = androidDriver.findElement(proceedButton);
				submittButton.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void contractSign() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(signTheContract));
			WebElement signTheContractElement = androidDriver.findElement(signTheContract);
			if (signTheContractElement.isDisplayed()) {
				System.out.println("User will get the e-contrat");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void submittSignedContract() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(contractConfrimCheckBox));
			WebElement confrimCheckBox = androidDriver.findElement(contractConfrimCheckBox);
			confrimCheckBox.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(contractConforimButton));
			WebElement conforimButton = androidDriver.findElement(contractConforimButton);
			conforimButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterOTP() {
		try {
			String getOTP = "1234";
			Actions action = new Actions(androidDriver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(otpFeild));
			WebElement digit1 = androidDriver.findElement(otpFeild);
			action.sendKeys(digit1, getOTP.substring(0)).perform();
//			androidDriver.configuratorSetWaitForIdleTimeout(Duration.ofSeconds(15));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnProceed() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(congratulationFeild));
			WebElement verifiedFeildMessage = androidDriver.findElement(congratulationFeild);
			if (verifiedFeildMessage.isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));
				WebElement continueButon = androidDriver.findElement(continueButton);
				continueButon.click();
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(verifiedFeild));
			WebElement verified = androidDriver.findElement(verifiedFeild);
			if (verified.isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));
				WebElement continueFeild = androidDriver.findElement(continueButton);
				continueFeild.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
