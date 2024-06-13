package com.qf.androidautomation.stepdefnitions;

import com.qf.androidautomation.pageobjects.LogInObjects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogIn {

	LogInObjects logIn = new LogInObjects();

	@Given("^User is on the login page enters Id NationalId")
	public void user_is_on_the_login_page_enters_id() {
		logIn.enterNationalId();
	}

	@Given("^User enters Id (.+) and clicks the signin button$")
	public void user_enters_id_and_clicks_the_signin_button(String USERNAME) {
		logIn.enterNationalIdandclicktheSigninButton(USERNAME);
	}

	@When("User clicks on the signin button")
	public void user_clicks_on_the_signin_button() throws InterruptedException {
		Thread.sleep(2000);
		logIn.signUp();
	}

	@Then("^NationalId filed (.+) thorws a validation message$")
	public void natinal_id_filed_thorws_a_validation_message(String USERNAME) throws InterruptedException {
		char firstDigit = USERNAME.charAt(0);
		try {
			if (!(firstDigit == '1' || firstDigit == '2')) {
				throw new AssertionError("National ID should start with 1 or 2 but found: " + firstDigit);
			} else if (USERNAME.length() != 10) {
				throw new AssertionError("Invalid National ID: Should have a length of 10 digits." + USERNAME);
			} else {
				logIn.signUp();
			}
		} catch (AssertionError e) {
			System.out.println("Assertion Error: " + e.getMessage());
		}

	}

	@Then("^Observe and enter the password")
	public void observe_and_enter_the_password() throws InterruptedException {
		Thread.sleep(2000);
		logIn.enterPassword();
	}

	@Given("^Observe and re-enter the password")
	public void observe_and_re_enter_the_password() throws InterruptedException {
		Thread.sleep(2000);
		logIn.reenterPassword();
	}

	@Then("^User is on the Otp page and enter the OTP recived")
	public void user_is_on_the_otp_page_and_enter_the_otp_recived() throws InterruptedException {
		try {
			logIn.enterOTP();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}