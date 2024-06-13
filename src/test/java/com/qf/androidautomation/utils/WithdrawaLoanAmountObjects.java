package com.qf.androidautomation.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qf.androidautomation.manager.SetUpManager;

import io.appium.java_client.android.AndroidDriver;

public class WithdrawaLoanAmountObjects {

	AndroidDriver androidDriver = SetUpManager.androidDriverManager();

	Config configProperty = new Config();

	AccessTokenApi accessTokenApi = new AccessTokenApi();

	String accessToken = accessTokenApi.getAccessToken();

	WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(60));

	private By currentBalance = By.xpath("//android.widget.TextView[@text=\"35000.00 SAR\"]");
	private By transactionsTab = By.xpath(
			"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[4]");
	private By transactionaScreen = By.xpath("(//android.widget.TextView[@text=\"Transactions\"])[1]");
	private By withdrawalButton = By.xpath("//android.widget.TextView[@text=\"Withdraw\"]");
	private By withdrawalTab = By.xpath("//android.widget.TextView[@text=\"Withdrawal\"]");
	private By confirmation = By.xpath("//android.widget.TextView[@text=\"Confirm\"]");
	private By otpFeild = By.xpath(
			"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]");
	private By processingFeild = By.xpath("//android.widget.TextView[@text=\"Your transaction is being processed.\"]");
	private By dashboardButton = By.xpath("//android.widget.TextView[@text=\"Go To Dashboard\"]");
	private By dashboardTab = By.xpath(
			"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[1]");
	private By processRequest = By.xpath(
			"//android.widget.TextView[@text=\"Your Withdraw request is being processed. Please wait for it to end.\"]");
	private By balanceWithdraw = By.xpath("(//android.widget.TextView[@text=\"Balance withdrawal\"])[1]");

	public void checkCurrentBalance() {
		try {
			WebDriverWait waitTime = new WebDriverWait(androidDriver, Duration.ofSeconds(180));
			waitTime.until(ExpectedConditions.visibilityOfElementLocated(currentBalance));
			WebElement currentBalanceFeild = androidDriver.findElement(currentBalance);
			if (currentBalanceFeild.getText() != "0.00 SAR") {
				System.out.println("Now customer loan amount was transfered");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickTransactionTab() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(transactionsTab));
			WebElement transactionsTabFeild = androidDriver.findElement(transactionsTab);
			if (transactionsTabFeild.isDisplayed()) {
				transactionsTabFeild.click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(transactionaScreen));
				WebElement transactionsScreenFeild = androidDriver.findElement(transactionaScreen);
				if (transactionsScreenFeild.isDisplayed()) {
					System.out.println("Customer is on Transaction Screen");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void withDrawProcess() {
		try {

			WebDriverWait waitTime = new WebDriverWait(androidDriver, Duration.ofSeconds(60));
			waitTime.until(ExpectedConditions.visibilityOfElementLocated(withdrawalButton));
			WebElement withdrawButton = androidDriver.findElement(withdrawalButton);
			if (withdrawButton.isEnabled()) {
				withdrawButton.click();
				waitTime.until(ExpectedConditions.visibilityOfElementLocated(withdrawalTab));
				WebElement withdrawalScreen = androidDriver.findElement(withdrawalTab);
				if (withdrawalScreen.isDisplayed()) {
					System.out.println("Customer is on Withdrawal Screen");
					System.out.println("Customer need to confrim the transaction");
					waitTime.until(ExpectedConditions.visibilityOfElementLocated(confirmation));
					WebElement confrimButton = androidDriver.findElement(confirmation);
					confrimButton.click();
				}
			} else {
				wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardTab));
				WebElement transactionsScreenFeild = androidDriver.findElement(dashboardTab);
				transactionsScreenFeild.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterOtp() {
		try {
			String getOTP = "1234";
			Actions action = new Actions(androidDriver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(otpFeild));
			WebElement digit1 = androidDriver.findElement(otpFeild);
			action.sendKeys(digit1, getOTP.substring(0)).perform();
//				androidDriver.configuratorSetWaitForIdleTimeout(Duration.ofSeconds(15));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loanProcessingMessage() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(processingFeild));
			WebElement processingMessage = androidDriver.findElement(processingFeild);
			if (processingMessage.isDisplayed()) {
				String message = processingMessage.getText();
				System.out.println(message);
				wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardButton));
				WebElement dashBoard = androidDriver.findElement(dashboardButton);
				dashBoard.click();
			} else {
				wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardTab));
				WebElement transactionsScreenFeild = androidDriver.findElement(dashboardTab);
				transactionsScreenFeild.click();
			}
		} catch (Exception e) {
			System.out.println("customer loan withdraw request is being processed");
		}
	}

	public void financialPayoutsRequest() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(processRequest));
			WebElement processRequestFeild = androidDriver.findElement(processRequest);
			PayoutRequestApi getPayouts = new PayoutRequestApi();
			PayoutsApprovalApi creditApproval = new PayoutsApprovalApi();
			String nationalId = configProperty.getSendKeys("nationalId");
			if (processRequestFeild.isDisplayed()) {
				String accessToken = accessTokenApi.getAccessToken();
				String status = configProperty.getSendKeys("financeApproval.status");
				String payoutStatus = configProperty.getSendKeys("financeApproval.payoutStatus");
				Thread.sleep(5000);
				String ObjectId = getPayouts.getPayoutRequest(nationalId, accessToken, status);
				System.out.println(accessToken);
				System.out.println("ObjectId for the nationalId" + nationalId + ObjectId);
				Thread.sleep(5000);
				int financeApprovalStatus = creditApproval.creditApproval(ObjectId, accessToken, payoutStatus);
				System.out.println(financeApprovalStatus);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkTransactionsHistory() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(transactionsTab));
			WebElement transactionsTabFeild = androidDriver.findElement(transactionsTab);
			if (transactionsTabFeild.isDisplayed()) {
				transactionsTabFeild.click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(transactionaScreen));
				WebElement transactionsScreenFeild = androidDriver.findElement(transactionaScreen);
				if (transactionsScreenFeild.isDisplayed()) {
					wait.until(ExpectedConditions.visibilityOfElementLocated(balanceWithdraw));
					WebElement history = androidDriver.findElement(balanceWithdraw);
					if (history.isDisplayed()) {
						System.out.println("Customer Transaction Done");
					}
					wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardTab));
					WebElement dashboardScreenFeild = androidDriver.findElement(dashboardTab);
					dashboardScreenFeild.click();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
