package com.qf.androidautomation.pageobjects;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qf.androidautomation.manager.SetUpManager;
import com.qf.androidautomation.utils.GetOTP;
import com.qf.androidautomation.utils.PasswordGenerator;
import com.qf.androidautomation.utils.ScreenShot;

import io.appium.java_client.android.AndroidDriver;

public class ForgotPasswordObjects {

	AndroidDriver androidDriver = SetUpManager.androidDriverManager();

	WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(60));

	private By nationalID = By.className("android.widget.EditText");
	private By signUpButton = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]");
	private By forgotPasswordUrl = By.xpath("//android.widget.TextView[@text=\"Forgot Your password?\"]");
	private By passwordFeild = By.xpath("//android.widget.EditText[@text=\"Type your new password\"]");
	private By nationalIdField = By.xpath("//android.widget.EditText[@text=\"National ID or IQAMA\"]");
	private By mobileNumberField = By.xpath("//android.widget.EditText[@text=\"Enter phone number\"]");
	private By continueButton = By.xpath("//android.widget.TextView[@text=\"Continue\"]");
	private By otpForForget = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]");
	private By passwordFieldforAAA = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup");
	private By lowerCaseMessage = By.xpath("//android.widget.TextView[@text=\"Password must have lowercase letters\"]");
	private By resetCapitalPassword = By.xpath("//android.widget.EditText[@text=\"AAAAAAAA\"]");
	private By upperCaseMessage = By.xpath("//android.widget.TextView[@text=\"Password must have uppercase letters\"]");
	private By resetLowerCasePassword = By.xpath("//android.widget.EditText[@text=\"aaaaaaaa\"]");
	private By lowerErrorMessage = By
			.xpath("//android.widget.TextView[@text=\"Password must have lowercase letters\"]");
	private By resetNumberPassword = By.xpath("//android.widget.EditText[@text=\"12345678\"]");
	private By symbolPassword = By.xpath("//android.widget.EditText[@text=\"@#$%^&*()\"]");
	private By minimumLettersError = By
			.xpath("//android.widget.TextView[@text=\"Password must have at least 8 signs\"]");
	private By lengthPassword = By.xpath("//android.widget.EditText[@text=\"Aa1234@\"]");
	private By fieldRequiredMessage = By.xpath("//android.widget.TextView[@text=\"Field is required\"]");
	private By confirmPassword = By.xpath("//android.widget.EditText[@text=\"Confirm your new password\"]");
	private By passwordVisibility = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup");
	private By passwordDontMatch = By.xpath("//android.widget.TextView[@text=\"Password doesn't match\"]");
	private By inCompletePassword = By.xpath("//android.widget.EditText[@text=\"Aa123@\"]");
	private By passwordContinueButton = By.xpath("//android.widget.TextView[@text=\"Continue\"]");
	private By wrongNationalID = By.xpath("//android.widget.EditText[@text=\"National ID or IQAMA\"]");
	private By wrongMobileNumber = By.xpath("//android.widget.EditText[@text=\"Enter phone number\"]");
	private By continueButtonForDetails = By.xpath("//android.widget.TextView[@text=\"Continue\"]");
	private By nationalIdNotExist = By.xpath(
			"//android.widget.TextView[@text=\"This national ID does not exist. Please enter it correctly or create an account\"]");
	private By textField = By.className("android.widget.EditText");
	private By continueField = By.xpath("//android.widget.TextView[@text=\"Continue\"]");
	private By notExists = By.xpath(
			"//android.widget.TextView[@text=\"This Mobile number does not exist. Please enter it correctly or create an account\"]");
	private By resetExistMobileNumber = By.xpath("//android.widget.EditText[@text=\"543966329\"]");

	public void enternationalID(String nationalId) throws InterruptedException {
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(nationalID)));
		WebElement NationalID = androidDriver.findElement(nationalID);
		if (NationalID.isDisplayed()) {
			NationalID.sendKeys(nationalId);

		}
		androidDriver.findElement(signUpButton).click();
		androidDriver.configuratorSetWaitForIdleTimeout(Duration.ofSeconds(15));
	}

	public void clickforgotpw() {
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(forgotPasswordUrl)));
		WebElement Test4 = androidDriver.findElement(forgotPasswordUrl);
		if (Test4.isDisplayed()) {
			Test4.click();
		}
	}

	public void revalidate(String nationalID, String mobileNO) {
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(nationalIdField)));
		androidDriver.findElement(nationalIdField).sendKeys(nationalID);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(mobileNumberField)));
		androidDriver.findElement(mobileNumberField).sendKeys(mobileNO);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(continueButton)));
		androidDriver.findElement(continueButton).click();
	}

	public void verifyOTP(String nationalID) {
		try {
			Thread.sleep(5000);
//			GetOTP otpHandler = new GetOTP();
//			String reciveOtp = otpHandler.sendRequest(nationalID, "PASSWORD_FORGET", "generateOtpCode");
			String otp = "1234";
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(otpForForget)));
			WebElement digit1 = androidDriver.findElement(otpForForget);
			Actions action = new Actions(androidDriver);
			String test = otp.substring(0);
			action.sendKeys(digit1, test).perform();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void resetpassword(String nationalID) {
		PasswordGenerator passwordGen = new PasswordGenerator();
		String newPassword = passwordGen.password();
		System.out.println(newPassword);
		// All upper cases
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(passwordFeild)));
		WebElement password = androidDriver.findElement(passwordFeild);
		password.sendKeys("AAAAAAAA");
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(passwordFieldforAAA)));
		WebElement eyesymbol = androidDriver.findElement(passwordFieldforAAA);
		eyesymbol.click();
		// All lower cases
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(lowerCaseMessage)));
		if (androidDriver.findElement(lowerCaseMessage).isDisplayed()) {
			androidDriver.findElement(resetCapitalPassword).clear();
			androidDriver.findElement(passwordFeild).sendKeys("aaaaaaaa");
		}
		// All digits
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(upperCaseMessage)));
		if (androidDriver.findElement(upperCaseMessage).isDisplayed()) {
			androidDriver.findElement(resetLowerCasePassword).clear();
			androidDriver.findElement(passwordFeild).sendKeys("12345678");
		}
		// All special char's
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(lowerErrorMessage)));
		if (androidDriver.findElement(lowerErrorMessage).isDisplayed()) {
			androidDriver.findElement(resetNumberPassword).clear();
			androidDriver.findElement(passwordFeild).sendKeys("@#$%^&*()");
		}
		// less than 8 digits
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(lowerErrorMessage)));
		if (androidDriver.findElement(lowerErrorMessage).isDisplayed()) {
			androidDriver.findElement(symbolPassword).clear();
			androidDriver.findElement(passwordFeild).sendKeys("Aa1234@");
		}
		// correct password format
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(minimumLettersError)));
		if (androidDriver.findElement(minimumLettersError).isDisplayed()) {
			androidDriver.findElement(lengthPassword).clear();
			androidDriver.findElement(passwordFeild).sendKeys(newPassword);
		}
		// Repeat password
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(fieldRequiredMessage)));
		if (androidDriver.findElement(fieldRequiredMessage).isDisplayed()) {
			WebElement confirm = androidDriver.findElement(confirmPassword);
			confirm.sendKeys("Aa123@");
		}
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(passwordVisibility)));
		WebElement eyesymbol1 = androidDriver.findElement(passwordVisibility);
		eyesymbol1.click();
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(passwordDontMatch)));
		if (androidDriver.findElement(passwordDontMatch).isDisplayed()) {
			WebElement confirm = androidDriver.findElement(inCompletePassword);
			confirm.clear();
			confirm.sendKeys(newPassword);
			System.out.println("generated new password=" + newPassword);
			androidDriver.findElement(passwordContinueButton).click();
			try {
				Thread.sleep(1000);
				ScreenShot image = new ScreenShot();
				image.takeScreenShot(androidDriver, "forgot-password");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(nationalID);
		}
	}

	public void wrongNationalID(String nationalID2, String invalidmobileNo) {
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(wrongNationalID)));
		androidDriver.findElement(wrongNationalID).sendKeys(nationalID2);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(wrongMobileNumber)));
		androidDriver.findElement(wrongMobileNumber).sendKeys(invalidmobileNo);
		wait.until(
				ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(continueButtonForDetails)));
		androidDriver.findElement(continueButtonForDetails).click();
	}

	public void NationalIDerrormessage(String nationalID) {
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(nationalIdNotExist)));
		WebElement Errormessage = androidDriver.findElement(nationalIdNotExist);
		String message = Errormessage.getText();
		String defaultMessage = "This national ID does not exist. Please enter it correctly or create an account";
		if (Errormessage.isDisplayed()) {
			if (message.equals(defaultMessage)) {
				WebElement Test = androidDriver.findElement(textField);
				Test.sendKeys(nationalID);
				androidDriver.findElement(continueField).click();
			}

		}
	}

	public void wrongmobilenumber(String nationalID, String invalidmobileNo) {
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(wrongNationalID)));
		androidDriver.findElement(wrongNationalID).sendKeys(nationalID);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(wrongMobileNumber)));
		androidDriver.findElement(wrongMobileNumber).sendKeys(invalidmobileNo);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(continueField)));
		androidDriver.findElement(continueField).click();
	}

	public void mobileerrormessage(String mobileNo) {
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(notExists)));
		WebElement Errormessage2 = androidDriver.findElement(notExists);
		String message2 = Errormessage2.getText();
		System.out.print(message2);
		String defaultMessage2 = "This Mobile number does not exist. Please enter it correctly or create an account";
		if (message2.equals(defaultMessage2)) {
			WebElement Test = androidDriver.findElement(resetExistMobileNumber);
			Test.sendKeys(mobileNo);
			System.out.println("correct mobile number entered");
			androidDriver.findElement(continueField).click();
		}
	}
}