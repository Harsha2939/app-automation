package com.qf.androidautomation.stepdefnitions;

import com.qf.androidautomation.pageobjects.NewLoanObjects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewLoan {
	NewLoanObjects newloan = new NewLoanObjects();

	@Given("Validate that user is on the dashboard and Click on the Get a New Loan button")
	public void validate_that_user_should_land_on_the_dashboard_after_entering_valid_otp() throws InterruptedException {
		newloan.newLoan();
	}
	
	@When("User should fill the initial eligibility if it get displayed")
	public void user_should_fill_the_initial_eligibility_if_it_get_displayed() {
	    
	}

	@Then("^provide the requested loan amount details (.+)$")
	public void provide_the_requested_loan_amount_details(String loanAmount) {
		newloan.requestedAmount(loanAmount);
	}

	@Then("choose one of the reason of getting fincance")
	public void choose_one_of_the_reason_of_getting_finance() throws InterruptedException {
		newloan.loanReason();
	}

	@When("^provide the income details (.+) ,accomidation details$")
	public void provide_the_income_details(String Amount) throws InterruptedException {
		newloan.monthlyIncomeDeatails(Amount);
		newloan.accomidationType();
	}

	@Then("click on the submit button")
	public void click_on_the_sumbit_button() throws InterruptedException {
		System.out.println("Reached till continue button");
		newloan.confirm();
	}

}