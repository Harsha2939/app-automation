package com.qf.androidautomation.stepdefnitions;

import com.qf.androidautomation.pageobjects.ContractSignAndConfirmOTPObjects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContractSignAndConfirmOTP {
	
	ContractSignAndConfirmOTPObjects contractSignAndConfirmOTPObjects = new ContractSignAndConfirmOTPObjects();
	
	@Given("user click on the submit button after providing bank account details")
	public void user_click_on_the_submit_button_after_providing_bank_account_details() {
		contractSignAndConfirmOTPObjects.bankAccountDetailsSubmit();
	}

	@When("user will recive confirmation call")
	public void user_will_recive_confirmation_call() {
		System.out.println("User will recive confirmation call");
		contractSignAndConfirmOTPObjects.confirmedCall();
	}

	@Then("user will click on proceed for e-contract sign")
	public void user_will_click_on_proceed_for_e_contract_sign() {
		contractSignAndConfirmOTPObjects.contractSign();
	}

	@Then("check the contract details and click on sign the contrat button")
	public void check_the_contract_details_and_click_on_sign_the_contrat_button() {
		contractSignAndConfirmOTPObjects.submittSignedContract();
	}

	@When("user will recive an otp and need to enter the otp")
	public void user_will_recive_an_otp_and_need_to_enter_the_otp() {
		contractSignAndConfirmOTPObjects.enterOTP();
	}

	@Then("user e-contract get signed and click on proceed button")
	public void user_e_contract_get_signed_and_click_on_proceed_button() {
		contractSignAndConfirmOTPObjects.clickOnProceed();
	}
}
