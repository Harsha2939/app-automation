package com.qf.androidautomation.stepdefnitions;

import com.qf.androidautomation.pageobjects.AccountVerificationObjects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountVerification {
	
	AccountVerificationObjects accountVerificationObjects = new AccountVerificationObjects();

	@Given("user should need to verify the bank account")
	public void user_should_need_to_verify_the_bank_account() {
		accountVerificationObjects.accountVerificationScreen();
	}

	@When("user should select the name of the bank")
	public void user_should_select_the_name_of_the_bank() {
		accountVerificationObjects.bankNameSelection();
	}

	@Then("after selection  of bank user can usually provide (.+)$")
	public void after_selection_of_bank_user_can_usually_provide_IBANnumber(String IBANnumber) {
		accountVerificationObjects.enterAccountNumber(IBANnumber);
	}

	@When("user should add bank certificate to confirm your ownership of the bank account")
	public void user_should_add_bank_certificate_to_confirm_your_ownership_of_the_bank_account() {
		accountVerificationObjects.uploadBankCertificateFile();
	}

	@Then("check the confirm checkbox and click on confirm button")
	public void check_the_confirm_checkbox_and_click_on_confirm_button() {
		accountVerificationObjects.checkBoxAndConfirm();
	}

}
