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
import com.qf.androidautomation.utils.PasswordGenerator;
import com.qf.androidautomation.utils.ScreenShot;

import io.appium.java_client.AppiumBy.ByAndroidUIAutomator;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class SignUpObjects {

	AndroidDriver androidDriver = SetUpManager.androidDriverManager();

	Config configProperty = new Config();

	public By nationalIdFeild = By.className("android.widget.EditText");
	private By idNotExsist = By.xpath(
			"//android.widget.TextView[@text=\"This national ID does not exist. Please enter it correctly or create an account\"]");
	private By signUpURL = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[3]/android.view.ViewGroup");
	private By nationaId = By.xpath("//android.widget.EditText[@text=\"National ID or IQAMA\"]");
	private By mobileField = By.xpath("//android.widget.EditText[@text=\"Enter phone number\"]");
	private By emailFeild = By.xpath("//android.widget.EditText[@text=\"username@domain.com\"]");
	private By continueFeild = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[5]");
	private By termsConditions = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[4]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup");
	private By nationalIDRequired = By.xpath("(//android.widget.TextView[@text=\"Field is required\"])[1]");
	private By otpField0 = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]");
	private By loanAmountFeild = By.xpath("(//android.widget.EditText[@text=\"0\"])[1]");
	private By tenurePlanFeild = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup");
	private By tenureMonths = By.xpath(
			"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[5]");
	private By dateOfBirth = By.xpath("//android.widget.EditText[@resource-id=\"dateOfBirth\"]");
	private By birthDate = By.xpath("//android.widget.TextView[@text=\"13\"]");
	private By dobMonth = By.xpath("//android.widget.EditText[@text=\"Month\"]");
	private By birthMonth = By.xpath("//android.widget.TextView[@text=\"Rabi al-Thani\"]");
	private By select = By.xpath("//android.view.ViewGroup[@resource-id=\"primaryButton\"]");
	private By dobYear = By.xpath("//android.widget.EditText[@text=\"Year\"]");
//	private By birthYear = By.xpath("//android.widget.TextView[@text=\"1414\"]");
	private By employment = By.xpath("//android.widget.TextView[@text=\"Select\"]");
	private By sector = By.xpath("(//android.widget.TextView[@text=\"Private\"])[1]");
	private By dayOfJoining = By.xpath("//android.widget.EditText[@resource-id=\"dateOfJoining\"]");
	private By dayJoining = By.xpath("//android.widget.TextView[@text=\"10\"]");
	private By monthOfJoining = By.xpath("(//android.widget.EditText[@text=\"Month\"])[1]");
	private By monthJoining = By.xpath("//android.widget.TextView[@text=\"Rabi al-Thani\"]");
	private By yearOfJoining = By.xpath("(//android.widget.EditText[@text=\"Year\"])[1]");
	private By dayOfSalary = By.xpath("//android.widget.EditText[@resource-id=\"lastSalaryReceived\"]");
	private By daySalary = By.xpath("//android.widget.TextView[@text=\"25\"]");
	private By monthOfSalary = By.xpath("(//android.widget.EditText[@text=\"Month\"])[1]");
//	private By monthSalary = By.xpath("//android.widget.TextView[@text=\"Jumada al-Awwal\"]");
	private By yearOfSalary = By.xpath("(//android.widget.EditText[@text=\"Year\"])[1]");
	private By netSalary = By.xpath("//android.widget.EditText[@text=\"0\"]");
	private By commitment = By.xpath("//android.widget.TextView[@text=\"No\"]");
	private By finalCheck = By.xpath(
			"//android.widget.TextView[@text=\"All this is initial check for financial eligibility and is not a final check.\"]");
	private By nextButton = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[8]/android.view.ViewGroup");
	private By acceptButton = By.xpath(
			"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]");
	private By conformation = By.xpath("//android.widget.TextView[@text=\"Confirm and Proceed\"]");
	private By verifyAccount = By.xpath("//android.widget.TextView[@text=\"Verify your account\"]");
	private By passwordFeild = By.xpath("//android.widget.EditText[@text=\"Type your new password\"]");
	private By passwordFieldforAAA = By.xpath(
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup");
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
			"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup");
	private By passwordDontMatch = By.xpath("//android.widget.TextView[@text=\"Password doesn't match\"]");
	private By inCompletePassword = By.xpath("//android.widget.EditText[@text=\"Aa123@\"]");
	private By passwordContinueButton = By.xpath("//android.widget.TextView[@text=\"Continue\"]");

	WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(20));

	public void enterNationalId() {
		String nationalId = configProperty.getSendKeys("signup.nationalId");
		wait.until(ExpectedConditions.visibilityOfElementLocated(nationalIdFeild));
		WebElement enterId = androidDriver.findElement(nationalIdFeild);
		enterId.clear();
		enterId.sendKeys(nationalId);
	}
	
	public void newUserSignup() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(idNotExsist));
		WebElement idNotEcsist = androidDriver.findElement(idNotExsist);
		if (idNotEcsist.isDisplayed()) {
			WebElement signUp = androidDriver.findElement(signUpURL);
			signUp.click();
			LocationPermission locationPermission = new LocationPermission();
			locationPermission.locationPermission();
		}
	}

	public void enterDetails() {
		String nationalId = configProperty.getSendKeys("signup.nationalId");
		String mobile = configProperty.getSendKeys("signup.mobile");
		String mail = configProperty.getSendKeys("signup.email");
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(nationaId));
			WebElement natilaId = androidDriver.findElement(nationaId);
			natilaId.click();
			androidDriver.configuratorSetWaitForIdleTimeout(Duration.ofSeconds(15));
			wait.until(ExpectedConditions.visibilityOfElementLocated(mobileField));

			WebElement mobileNumbwer = androidDriver.findElement(mobileField);
			mobileNumbwer.click();
			WebElement requiredFeild = androidDriver.findElement(nationalIDRequired);
			if (requiredFeild.isDisplayed()) {
				natilaId.clear();
				natilaId.sendKeys(nationalId);
				androidDriver.configuratorSetWaitForIdleTimeout(Duration.ofSeconds(15));

			}
			mobileNumbwer.sendKeys(mobile);
			WebElement gmail = androidDriver.findElement(emailFeild);
			gmail.sendKeys(mail);
//		gmail.click();
//		click.click();
			androidDriver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
			WebElement checkTerms = androidDriver.findElement(termsConditions);
			checkTerms.click();
			WebElement continueButton = androidDriver.findElement(continueFeild);
			if (continueButton.isEnabled()) {
				continueButton.click();
			}
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validteSignUpDetails() {

	}

	public void enterOTP() {
		String getOTP = "1234";
		Actions action = new Actions(androidDriver);
		WebElement digit1 = androidDriver.findElement(otpField0);
		action.sendKeys(digit1, getOTP.substring(0)).perform();
		androidDriver.configuratorSetWaitForIdleTimeout(Duration.ofSeconds(15));
	}

	public void enterEligibilityDetails() {
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

			wait.until(ExpectedConditions.visibilityOfElementLocated(verifyAccount));
			WebElement verifyYourAccount = androidDriver.findElement(verifyAccount);
			verifyYourAccount.click();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void setNewUserpassword() {
		try {

			PasswordGenerator passwordGen = new PasswordGenerator();
			String newPassword = passwordGen.password();
			System.out.println(newPassword);
			// All upper cases
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(passwordFeild)));
			WebElement password = androidDriver.findElement(passwordFeild);
			password.sendKeys("AAAAAAAA");
			wait.until(
					ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(passwordFieldforAAA)));
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
			wait.until(
					ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(minimumLettersError)));
			if (androidDriver.findElement(minimumLettersError).isDisplayed()) {
				androidDriver.findElement(lengthPassword).clear();
				androidDriver.findElement(passwordFeild).sendKeys(newPassword);
			}
			// Repeat password
			wait.until(
					ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(fieldRequiredMessage)));
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
				Thread.sleep(1000);
				ScreenShot image = new ScreenShot();
				image.takeScreenShot(androidDriver, "forgot-password");
				Thread.sleep(5000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void viewDashboard() {
		try {
			Thread.sleep(5000);
			androidDriver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
			Thread.sleep(5000);
			WebElement dashboard = androidDriver
					.findElement(By.xpath("//android.widget.TextView[@text=\"Dashboard\"]"));
			if (dashboard.isEnabled()) {
				System.out.println("User on the Dashboard");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
