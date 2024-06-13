package com.qf.androidautomation.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qf.androidautomation.manager.SetUpManager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class LoanAmountAndComodityPurchaseObjects {

	AndroidDriver androidDriver = SetUpManager.androidDriverManager();

	WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(60));

	private By eligible = By.xpath("//android.widget.TextView[@text=\"Eligible\"]");
	private By congratulations = By.xpath("//android.widget.TextView[@text=\"Congratulations!\"]");
	private By proceed = By.xpath("//android.widget.TextView[@text=\"Proceed\"]");
	private By loanAndPayment = By.xpath("//android.widget.TextView[@text=\"Loan & Payment Plan\"]");
	private By loanScreenProceed = By.xpath(
			"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup");
	private By comodityPurchaseOffer = By.xpath("//android.widget.TextView[@text=\"Commodity purchase offer\"]");
	private By commodityProceed = By.xpath(
			"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[4]/android.view.ViewGroup");
	private By commodityPurchaseAcceptance = By.xpath("//android.widget.TextView[@text=\"Commodity purchase\"]");
	private By commodityPurchaseAcceptButton = By.xpath("//android.widget.TextView[@text=\"Accept\"]");

	public void eligibleOrNot() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(eligible));
			WebElement elegibleMessage = androidDriver.findElement(eligible);
			if (elegibleMessage.isDisplayed()) {
				System.out.println("Customer initially eligible to receive");
			} else {
				System.out.println("Customer initially not eligible to receive");
				System.out.println("Try after 7 days");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickProceed() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(congratulations));
			WebElement congratulationsMessage = androidDriver.findElement(congratulations);
			if (congratulationsMessage.isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(proceed));
				WebElement proceedButton = androidDriver.findElement(proceed);
				proceedButton.click();
			} else {
				androidDriver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loanAndPaymentPlan() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(loanAndPayment));
			WebElement loanAndPaymentMessage = androidDriver.findElement(loanAndPayment);
			if (loanAndPaymentMessage.isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(loanScreenProceed));
				WebElement proceedButton = androidDriver.findElement(loanScreenProceed);
				proceedButton.click();
			} else {
				androidDriver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void commodityPurchaseOffer() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(comodityPurchaseOffer));
			WebElement comodityPurchaseOfferMessage = androidDriver.findElement(comodityPurchaseOffer);
			if (comodityPurchaseOfferMessage.isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(commodityProceed));
				WebElement proceedButton = androidDriver.findElement(commodityProceed);
				proceedButton.click();
			} else {
				androidDriver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void commodityPurchaseAccept() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(commodityPurchaseAcceptance));
			WebElement ccommodityPurchaseAcceptanceMessage = androidDriver.findElement(commodityPurchaseAcceptance);
			if (ccommodityPurchaseAcceptanceMessage.isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(commodityPurchaseAcceptButton));
				WebElement proceedButton = androidDriver.findElement(commodityPurchaseAcceptButton);
				proceedButton.click();
			} else {
				androidDriver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
