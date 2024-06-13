package com.qf.androidautomation.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qf.androidautomation.manager.SetUpManager;
import com.qf.androidautomation.utils.ScreenShot;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumBy.ByAndroidUIAutomator;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class NewLoanObjects {

	AndroidDriver androidDriver = SetUpManager.androidDriverManager();

	WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(60));

	SignUpObjects signUpObjects = new SignUpObjects();

	private By Banner = By.xpath(
			"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup");
	private By banner = By.xpath(
			"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup");
	private By applyloan = By.xpath(
			"//android.widget.TextView[@text=\"Get a new loan\"]");
	private By getLoanText = By.xpath("//android.widget.TextView[@text='Get a new loan']");
	private By initialEligible = By.xpath("//android.widget.TextView[@text=\"Initial Eligibility Check\"]");
	private By loanAmountFeild = By.xpath("(//android.widget.EditText[@text=\"0\"])[1]");
	private By tenurePlanFeild = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup");
	private By tenureMonths = By.xpath("//android.widget.TextView[@text=\"12 Months\"]");
	private By dateOfBirth = By.xpath("//android.widget.EditText[@resource-id=\"dateOfBirth\"]");
	private By birthDate = By.xpath("//android.widget.TextView[@text=\"10\"]");
	private By dobMonth = By.xpath("//android.widget.EditText[@text=\"Month\"]");
	private By birthMonth = By.xpath("//android.widget.TextView[@text=\"Rabi al-Thani\"]");
	private By select = By.xpath("//android.view.ViewGroup[@resource-id=\"primaryButton\"]");
	private By dobYear = By.xpath("//android.widget.EditText[@text=\"Year\"]");
//	private By birthYear = By.xpath("//android.widget.TextView[@text=\"1414\"]");
	private By employment = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup");
	private By sector = By.xpath("//android.widget.TextView[@text=\"Private\"]");
	private By dayOfJoining = By.xpath("//android.widget.EditText[@resource-id=\"dateOfJoining\"]");
	private By dayJoining = By.xpath(
			"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[3]");
	private By monthOfJoining = By.xpath("(//android.widget.EditText[@text=\"Month\"])[1]");
	private By monthJoining = By.xpath("//android.widget.TextView[@text=\"Rabi al-Thani\"]");
	private By yearOfJoining = By.xpath("(//android.widget.EditText[@text=\"Year\"])[1]");
	private By dayOfSalary = By.xpath("//android.widget.EditText[@resource-id=\"lastSalaryReceived\"]");
	private By daySalary = By.xpath("//android.widget.TextView[@text=\"10\"]");
	private By monthOfSalary = By.xpath("//android.widget.EditText[@text=\"Month\"]");
//	private By monthSalary = By.xpath("//android.widget.TextView[@text=\"Jumada al-Awwal\"]");
	private By yearOfSalary = By.xpath("//android.widget.EditText[@text=\"Year\"]");
	private By netSalary = By.xpath("//android.widget.EditText[@text=\"0\"]");
	private By commitment = By.xpath("//android.widget.TextView[@text=\"No\"]");
	private By finalCheck = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[7]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup");
	private By nextButton = By.xpath("//android.widget.TextView[@text=\"Next\"]");
	private By acceptButton = By.xpath("//android.widget.TextView[@text=\"Accept\"]");
	private By conformation = By.xpath("//android.widget.TextView[@text=\"Confirm and Proceed\"]");
	private By continueFeild = By.xpath("//android.widget.TextView[@text=\\\"Continue\\\"]");
	private By rqstLoanAmount = By.xpath("(//android.widget.EditText[@text='10000'])[1]");
	private By reason = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup");
	private By option = By.xpath(
			"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]");
	private By income = By.xpath("(//android.widget.EditText)[2]");
	private By accomodation = By.xpath("//android.widget.TextView[@text=\"Type of accommodation\"]");
	private By accomoptionOption = By.xpath("//android.widget.TextView[@text=\"Villa\"]");
	private By home = By.xpath("//android.widget.TextView[@text=\"Home ownership type\"]");
	private By homeOwnerShip = By.xpath(
			"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]");
	private By familyMem = By.xpath("(//android.widget.TextView[@text=\"No\"])[2]");
	private By consent = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[7]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup");
	private By Accept = By.xpath(
			"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]");
	private By comfrim = By.xpath("//android.widget.TextView[@text=\"Confirm\"]");

	ScreenShot screenShot = new ScreenShot();

	public void newLoan() {
		try {
			WebDriverWait waitTimmer = new WebDriverWait(androidDriver, Duration.ofSeconds(20));
			WebElement back = androidDriver.findElement(Banner);
			if (back.isDisplayed()) {
				WebElement cross = androidDriver.findElement(banner);
				cross.click();
				screenShot.takeScreenShot(androidDriver, "dashboard-screen");
			}
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(applyloan));
			WebElement newLoan = androidDriver.findElement(applyloan);
			newLoan.click();
			waitTimmer.until(ExpectedConditions.visibilityOfElementLocated(initialEligible));
			WebElement initialEligibleMessage = androidDriver.findElement(initialEligible);
			if (initialEligibleMessage.isDisplayed()) {
				System.out.println("User need to fill initial eligibility details");
				loanEligibilityCheck();
			}
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("User initial eligibility details are already filled");
		}
	}

	public void loanEligibilityCheck() {

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(loanAmountFeild));
			WebElement loanAmmount = androidDriver.findElement(loanAmountFeild);
			loanAmmount.sendKeys("8000");
			wait.until(ExpectedConditions.visibilityOfElementLocated(tenurePlanFeild));
			WebElement tenurePlan = androidDriver.findElement(tenurePlanFeild);
			tenurePlan.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(tenureMonths));
			WebElement months = androidDriver.findElement(tenureMonths);
			months.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(dateOfBirth));
			WebElement day = androidDriver.findElement(dateOfBirth);
			day.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(birthDate));
			WebElement dateOfBirth = androidDriver.findElement(birthDate);
			dateOfBirth.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(select));
			WebElement selectButton = androidDriver.findElement(select);
			if (selectButton.isEnabled()) {
				selectButton.click();
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(dobMonth));
			WebElement dobMonthElement = androidDriver.findElement(dobMonth);
			dobMonthElement.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(birthMonth));
			WebElement month = androidDriver.findElement(birthMonth);
			month.click();
			WebElement selectb = androidDriver.findElement(select);
			if (selectb.isEnabled()) {
				selectb.click();
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(dobYear));
			WebElement yearOfBirth = androidDriver.findElement(dobYear);
			yearOfBirth.click();

			Thread.sleep(3000);
			String year = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").index(0)).scrollIntoView(new UiSelector().text(\"1414\"))";

			WebElement birthYear = androidDriver.findElement(ByAndroidUIAutomator.androidUIAutomator(year));
			birthYear.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(select));
			WebElement selectYear = androidDriver.findElement(select);
			if (selectYear.isEnabled()) {
				selectYear.click();
			}
			Thread.sleep(3000);
			androidDriver.findElement(
					ByAndroidUIAutomator.androidUIAutomator("new UiScrollable(new UiSelector()).scrollForward()"));
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(employment));
			WebElement employSector = androidDriver.findElement(employment);
			employSector.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(sector));
			WebElement selectSector = androidDriver.findElement(sector);
			selectSector.click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(dayOfJoining));
			androidDriver.findElement(dayOfJoining).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(dayOfJoining));
			androidDriver.findElement(dayJoining).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(select));
			WebElement selectBu = androidDriver.findElement(select);
			if (selectBu.isEnabled()) {
				selectBu.click();
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(monthOfJoining));
			androidDriver.findElement(monthOfJoining).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(monthJoining));
			androidDriver.findElement(monthJoining).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(select));
			WebElement selectButt = androidDriver.findElement(select);
			if (selectButt.isEnabled()) {
				selectButt.click();
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(yearOfJoining));
			WebElement yearjoin = androidDriver.findElement(yearOfJoining);
			yearjoin.click();

			String etst = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").index(0)).scrollIntoView(new UiSelector().text(\"1440\"))";

			WebElement joiningYear = androidDriver.findElement(ByAndroidUIAutomator.androidUIAutomator(etst));
			joiningYear.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(select));
			WebElement selectBut = androidDriver.findElement(select);
			if (selectBut.isEnabled()) {
				selectBut.click();
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(dayOfSalary));
			WebElement salaryDay = androidDriver.findElement(dayOfSalary);
			salaryDay.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(daySalary));
			WebElement lastSalaryDay = androidDriver.findElement(daySalary);
			lastSalaryDay.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(select));
			WebElement primaryButton = androidDriver.findElement(select);
			if (primaryButton.isEnabled()) {
				primaryButton.click();
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(monthOfSalary));
			WebElement salaryMonth = androidDriver.findElement(monthOfSalary);
			salaryMonth.click();

			String monthSalary = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").index(0)).scrollIntoView(new UiSelector().text(\"Shawwal\"))";

			WebElement monthSal = androidDriver.findElement(ByAndroidUIAutomator.androidUIAutomator(monthSalary));
			monthSal.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(select));
			WebElement monthSelect = androidDriver.findElement(select);
			if (monthSelect.isEnabled()) {
				monthSelect.click();
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(yearOfSalary));
			WebElement salaryYear = androidDriver.findElement(yearOfSalary);
			salaryYear.click();

			String yearSalary = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").index(0)).scrollIntoView(new UiSelector().text(\"1445\"))";

			WebElement lastSalaryYear = androidDriver.findElement(ByAndroidUIAutomator.androidUIAutomator(yearSalary));
			lastSalaryYear.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(select));
			WebElement yearSelect = androidDriver.findElement(select);
			if (yearSelect.isEnabled()) {
				yearSelect.click();
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(netSalary));
			WebElement selectNetSalary = androidDriver.findElement(netSalary);
			selectNetSalary.sendKeys("10000");
			WebElement monthlyCommitment = androidDriver.findElement(commitment);
			monthlyCommitment.click();
			WebElement conditions = androidDriver.findElement(finalCheck);
			conditions.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(acceptButton));
			WebElement acceptance = androidDriver.findElement(acceptButton);
			acceptance.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(nextButton));
			WebElement nextContinue = androidDriver.findElement(nextButton);
			if (nextContinue.isEnabled()) {
				nextContinue.click();
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(conformation));
			WebElement conformationAndProcced = androidDriver.findElement(conformation);
			conformationAndProcced.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(continueFeild));
			WebElement continueButton = androidDriver.findElement(continueFeild);
			continueButton.click();

//			wait.until(ExpectedConditions.visibilityOfElementLocated(verifyAccount));
//			WebElement verifyYourAccount = androidDriver.findElement(verifyAccount);
//			verifyYourAccount.click();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void newLoanText() {
		WebElement newLoanText = androidDriver.findElement(getLoanText);
		newLoanText.getText();
	}

	public void requestedAmount(String loanAmount) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(rqstLoanAmount));
		WebElement loanrqstAmount = androidDriver.findElement(rqstLoanAmount);
		loanrqstAmount.clear();
		loanrqstAmount.sendKeys(loanAmount);
	}

	public void loanReason() throws InterruptedException {
		WebElement loanReason = androidDriver.findElement(reason);
		loanReason.click();
		WebElement options = androidDriver.findElement(option);
		options.click();
	}

	public void monthlyIncomeDeatails(String Amount) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(income));
		WebElement monthlyIncome = androidDriver.findElement(income);
		monthlyIncome.clear();
		monthlyIncome.sendKeys(Amount);
		Thread.sleep(2000);
	}

	public void accomidationType() throws InterruptedException {
		androidDriver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(accomodation));
		WebElement accommodation = androidDriver.findElement(accomodation);
		accommodation.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(accomoptionOption));
		WebElement Option = androidDriver.findElement(accomoptionOption);
		Option.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(home));
		WebElement homeType = androidDriver.findElement(home);
		homeType.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(homeOwnerShip));
		WebElement homeOwnerShipType = androidDriver.findElement(homeOwnerShip);
		homeOwnerShipType.click();

		Thread.sleep(3000);
		String scroll = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").index(1)).scrollIntoView(new UiSelector().text(\"Relationship\"))";
		androidDriver.findElement(AppiumBy.androidUIAutomator(scroll));
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(familyMem));
		WebElement familyMember = androidDriver.findElement(familyMem);
		familyMember.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(consent));
		WebElement checkbox = androidDriver.findElement(consent);
		checkbox.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Accept));
		WebElement accept = androidDriver.findElement(Accept);
		accept.click();
		Thread.sleep(3000);
	}

	public void confirm() throws InterruptedException {
		WebElement Confirm = androidDriver.findElement(comfrim);
		Confirm.click();
		Thread.sleep(3000);
		screenShot.takeScreenShot(androidDriver, "loan-applied-sucessfully");
	}
}