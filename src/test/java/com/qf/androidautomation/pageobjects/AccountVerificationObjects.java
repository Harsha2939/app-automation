package com.qf.androidautomation.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qf.androidautomation.manager.SetUpManager;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AccountVerificationObjects {

	AndroidDriver androidDriver = SetUpManager.androidDriverManager();

	WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(60));

	private By accountVerification = By.xpath("//android.widget.TextView[@text=\"Account Verification\"]");
	private By bankSelection = By.xpath("//android.widget.TextView[@text=\"Al Rajhi Bank\"]");
	private By bankSelectButton = By.xpath(
			"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup");
	private By ibanNumberFeild = By.xpath("//android.widget.EditText[@text=\"SA-00-00-000000000000000000\"]");
	private By pdfUploadFeild = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]");
	private By pdfFile = By.xpath(
			"//android.widget.LinearLayout[@resource-id=\"com.google.android.documentsui:id/item_root\"]/android.widget.LinearLayout/android.widget.LinearLayout");
	private By confirmCheckbox = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup");
	private By confirmButton = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]");
	
	
	public void accountVerificationScreen() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(accountVerification));
			WebElement accountVerificationMessage = androidDriver.findElement(accountVerification);
			if (accountVerificationMessage.isDisplayed()) {
				System.out.println("User on account verification screen");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void bankNameSelection() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(bankSelection));
			WebElement accountVerificationMessage = androidDriver.findElement(bankSelection);
			accountVerificationMessage.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(bankSelectButton));
			WebElement accountVerificationButton = androidDriver.findElement(bankSelectButton);
			if (accountVerificationButton.isEnabled()) {
				accountVerificationButton.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterAccountNumber(String IBANnumber) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(ibanNumberFeild));
			WebElement ibanNumberInputFeild = androidDriver.findElement(ibanNumberFeild);
			ibanNumberInputFeild.sendKeys(IBANnumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void uploadBankCertificateFile() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(pdfUploadFeild));
			WebElement pdfUpload = androidDriver.findElement(pdfUploadFeild);
			pdfUpload.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(pdfFile));
			WebElement pdfFileElement = androidDriver.findElement(pdfFile);
			pdfFileElement.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkBoxAndConfirm() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(confirmCheckbox));
			WebElement confirmCheckboxElement = androidDriver.findElement(confirmCheckbox);
			confirmCheckboxElement.click();
			Thread.sleep(3000);
			androidDriver.findElement(
					AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(confirmButton));
			WebElement confirmButtonElement = androidDriver.findElement(confirmButton);
			if (confirmButtonElement.isEnabled()) {
				confirmButtonElement.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
