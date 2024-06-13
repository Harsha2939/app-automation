package com.qf.androidautomation.pageobjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qf.androidautomation.manager.SetUpManager;
import com.qf.androidautomation.utils.Config;
import com.qf.androidautomation.utils.LocationPermission;

import io.appium.java_client.android.AndroidDriver;

public class LogInObjects {

	AndroidDriver androidDriver = SetUpManager.androidDriverManager();

	Config configProperty = new Config();

	LocationPermission locationPermission = new LocationPermission();

	public By nationalIdFeild = By.className("android.widget.EditText");
	private By signInButton = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]");
	private By passwordFeild = By.xpath("//android.widget.EditText[@text=\"Type your password\"]");
	private By showPassword = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup");
	private By pwdFeildErrorMessage = By
			.xpath("//android.widget.TextView[@text='Incorrect password, please try again']");
	private By otpField0 = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]");
	private By updateMobileNumber = By.xpath("//android.widget.TextView[@text='Update mobile number']");
	private By mobileNumber = By.xpath("//android.widget.EditText[@text='Enter phone number']");
	private By date = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[3]/android.view.ViewGroup[1]");
	private By month = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[3]/android.view.ViewGroup[2]");
	private By year = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[3]/android.view.ViewGroup[3]");
	private By dateSelection = By.xpath("//android.widget.TextView[@text=\"8\"]");
	private By monthSelection = By.xpath("//android.widget.TextView[@text=\"Jumada al-Awwal\"]");
	private By yearSelection = By.xpath("//android.widget.TextView[@text=\"1385\"]");
	private By selectButton = By.xpath("//android.widget.TextView[@text=\"Select\"]");
	private By continueButton = By.xpath("//android.widget.TextView[@text=\"Continue\"]");

	WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(60));

	public void enterNationalId() {
		try {
			String nationalId = configProperty.getSendKeys("nationalId");
			wait.until(ExpectedConditions.visibilityOfElementLocated(nationalIdFeild));
			WebElement enterId = androidDriver.findElement(nationalIdFeild);
			enterId.clear();
			enterId.sendKeys(nationalId);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void enterNationalIdandclicktheSigninButton(String USERNAME) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(nationalIdFeild));
			WebElement enterId = androidDriver.findElement(nationalIdFeild);
			enterId.clear();
			enterId.sendKeys(USERNAME);
			signUp();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickSignUp() {
		try {
			signUp();
			wait.until(ExpectedConditions.visibilityOfElementLocated(updateMobileNumber));
			String actualHeadingName = androidDriver.findElement(updateMobileNumber).getText();
			String expectedString = "Update mobile number";

			if (actualHeadingName.contentEquals(expectedString)) {
				updateMobile();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void updateMobile() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumber));
		WebElement registeredMobileNo = androidDriver.findElement(mobileNumber);
		registeredMobileNo.clear(); // Clear any existing value
//		registeredMobileNo.sendKeys(MobileNo);
		registeredMobileNo.sendKeys("544918206");

		// Select Date
		WebElement selectDateField = androidDriver.findElement(date);
		selectDateField.click();
		WebElement selectDate = androidDriver.findElement(dateSelection);
		selectDate.click();
		clickSelectButton();

		// Select Month
		WebElement selectMonthField = androidDriver.findElement(month);
		selectMonthField.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(monthSelection));
		WebElement selectMonth = androidDriver.findElement(monthSelection);
		selectMonth.click();
		clickSelectButton();

		// Select Year
		WebElement selectYearField = androidDriver.findElement(year);
		selectYearField.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(yearSelection));
		WebElement selectYear = androidDriver.findElement(yearSelection);
		selectYear.click();
		clickSelectButton();

		// Click Continue Button
		WebElement updateContinue = androidDriver.findElement(continueButton);
		updateContinue.click();
	}

	private void clickSelectButton() {
		WebElement selecteddobButton = androidDriver.findElement(selectButton);
		selecteddobButton.click();
	}

	public void signUp() {
		WebElement signIn = androidDriver.findElement(signInButton);
		if (signIn.isEnabled())
			signIn.click();
	}

	public void enterPassword() throws InterruptedException {
		String wrongPassword = configProperty.getSendKeys("wrongpassword");

		WebElement pwd = androidDriver.findElement(passwordFeild);
		pwd.sendKeys(wrongPassword);
		WebElement passwordVisiblity = androidDriver.findElement(showPassword);
		passwordVisiblity.click();
		signUp();
		WebElement pwdError = androidDriver.findElement(pwdFeildErrorMessage);
		if (pwdError.isDisplayed()) {
			pwd.clear();
		}
	}

	public void reenterPassword() throws InterruptedException {
		String password = configProperty.getSendKeys("password");
		WebElement pwd = androidDriver.findElement(passwordFeild);
		pwd.sendKeys(password);
		WebElement passwordVisiblity = androidDriver.findElement(showPassword);
		passwordVisiblity.click();
		signUp();
		locationPermission.locationPermission();
		Thread.sleep(2000);
	}

	public void enterOTP() {
		LogInObjects log = new LogInObjects();
//		GetOTP sendRequest = new GetOTP();
//		String getOTP = sendRequest.sendRequest(nationalId, "LOGIN", "generateOtpCode");
//		System.out.println("LOGIN= " + getOTP);
		String getOTP = "1234";
		Actions action = new Actions(androidDriver);
		WebElement digit1 = androidDriver.findElement(log.otpField0);
		action.sendKeys(digit1, getOTP.substring(0)).perform();

	}

}