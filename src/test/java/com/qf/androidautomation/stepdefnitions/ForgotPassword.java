package com.qf.androidautomation.stepdefnitions;

import java.net.MalformedURLException;

import com.qf.androidautomation.pageobjects.ForgotPasswordObjects;
import com.qf.androidautomation.utils.LocationPermission;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPassword {

	int secondID;
	int mobileNo;

	ForgotPasswordObjects forgotpw = new ForgotPasswordObjects();

	@When("user should click on forgot password")
	public void user_should_click_on_forgot_password() {
		forgotpw.clickforgotpw();
	}

	@When("User enter wrong (.+) and (.+) in confirm page$")
	public void User_enter_wrong_National_ID_and_invalidmobileNo_in_confirm_page(String nationalID2,
			String invalidmobileNo) {
		forgotpw.wrongNationalID(nationalID2, invalidmobileNo);
	}

	@When("validate error message, reenter correct (.+)$")
	public void validate_error_message_reenter_correct_national_ID(String nationalID) {
		forgotpw.NationalIDerrormessage(nationalID);
	}

	@When("^validate error message reenter correct (.+)$")
	public void validate_error_message_reenter_coorect_mobile_number(String mobileNo) {
		forgotpw.mobileerrormessage(mobileNo);
	}

	@When("User  should give OTP on Enter verification screen (.+)$")
	public void user_should_give_otp_on_enter_verification_screen(String nationalID)
			throws MalformedURLException, InterruptedException {
		forgotpw.verifyOTP(nationalID);
	}

	@Then("^User will verify Resetpassword validations for (.+)$")
	public void User_will_verify_Resetpassword_validations_and_relogin(String nationalID) {
		forgotpw.resetpassword(nationalID);
		LocationPermission locationPermission = new LocationPermission();
		locationPermission.locationPermission();
	}

}