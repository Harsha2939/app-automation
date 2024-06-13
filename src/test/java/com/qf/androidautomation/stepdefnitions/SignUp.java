package com.qf.androidautomation.stepdefnitions;

import com.qf.androidautomation.pageobjects.ForgotPasswordObjects;
import com.qf.androidautomation.pageobjects.LogInObjects;
import com.qf.androidautomation.pageobjects.SignUpObjects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUp {

//	protected static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

	LogInObjects logInObjects = new LogInObjects();

	SignUpObjects signUpObjects = new SignUpObjects();
	
	ForgotPasswordObjects forgotPasswordObjects = new ForgotPasswordObjects();

	@Given("User enter nationalId")
	public void user_enter_national_id() {
		signUpObjects.enterNationalId();
		logInObjects.signUp();
//		LOGGER.info("This is a message of type: info");

	}

	@When("If the user entered nationalId not exsist")
	public void if_the_user_entered_national_id_not_exsist() throws Exception {
		signUpObjects.newUserSignup();
		Thread.sleep(5000);
	}

	@Then("User able to signup")
	public void user_able_to_signup() {
	}

	@Given("User enterd nationalId, mobile and email")
	public void user_enterd_and() throws InterruptedException {
		signUpObjects.enterDetails();
	}

	@Given("Verify the details")
	public void verify_the_details() {
		signUpObjects.validteSignUpDetails();
	}

	@When("User valid details")
	public void user_valid_details() {
		signUpObjects.enterOTP();
	}

	@Then("Click on continue button")
	public void click_on_continue_button() {
		signUpObjects.enterEligibilityDetails();
	}
	
	@Then("Verify Resetpassword validations for nationalID")
	public void verify_resetpassword_validations_for_national_id() {
	   signUpObjects.setNewUserpassword();
	}
	
	@When("customer sign up done , customer can apply loan")
	public void customer_sign_up_done_customer_can_apply_loan() {
	  
	}
}
