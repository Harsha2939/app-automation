package com.qf.androidautomation.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qf.androidautomation.manager.SetUpManager;
import com.qf.androidautomation.utils.AccessTokenApi;
import com.qf.androidautomation.utils.Config;
import com.qf.androidautomation.utils.IbanRequestIdApi;
import com.qf.androidautomation.utils.IbanVerificationApi;
import com.qf.androidautomation.utils.PayoutRequestApi;
import com.qf.androidautomation.utils.PayoutsApprovalApi;

import io.appium.java_client.android.AndroidDriver;

public class BackOfficeActionsForNewLoanObjects {

	AndroidDriver androidDriver = SetUpManager.androidDriverManager();
	
	Config configProperty = new Config();
		
	AccessTokenApi accessTokenApi = new AccessTokenApi();
	
	String accessToken = accessTokenApi.getAccessToken();

	WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(60));

	private By disbursedField = By.xpath("//android.widget.TextView[@text=\"Your loan will be disbursed shortly.\"]");
	
	public void loanDisbursed() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(disbursedField));
			WebElement disbursedFieldMessage = androidDriver.findElement(disbursedField);
			if (disbursedFieldMessage.isDisplayed()) {
				System.out.println("Now user loan will be disbursed shortly");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ibanRequestAndVerification() {
		IbanRequestIdApi getRequestId = new IbanRequestIdApi();
		IbanVerificationApi ibanVerification = new IbanVerificationApi();
		String nationalId = configProperty.getSendKeys("nationalId");
		try {
			Thread.sleep(5000);
			int requestId = getRequestId.getIbanRequestId(nationalId, accessToken);
			ibanVerification.ibanVerification(requestId, accessToken) ;
			System.out.println("IBAN Number verification done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void creditRequestAndApproval() {
		PayoutRequestApi getPayouts = new PayoutRequestApi();
		PayoutsApprovalApi creditApproval = new PayoutsApprovalApi(); 
		String nationalId = configProperty.getSendKeys("nationalId");
		try {
			String accessToken = accessTokenApi.getAccessToken();
			String status = configProperty.getSendKeys("creditApproval.status");
			String payoutStatus = configProperty.getSendKeys("creditApproval.payoutStatus");
			Thread.sleep(10000);
			String ObjectId = getPayouts.getPayoutRequest(nationalId, accessToken, status);
			System.out.println(accessToken);
			System.out.println("ObjectId for the nationalId" + nationalId + ObjectId);
			Thread.sleep(5000);
			int ibanVerificationStatus = creditApproval.creditApproval(ObjectId, accessToken, payoutStatus) ;
			System.out.println("Credit Approval done: " + ibanVerificationStatus);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void jobSchedular() {
		
	}
}
