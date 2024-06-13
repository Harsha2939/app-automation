package com.qf.androidautomation.stepdefnitions;

import com.qf.androidautomation.pageobjects.BackOfficeActionsForNewLoanObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BackOfficeActionsForNewLoan {
	
	BackOfficeActionsForNewLoanObjects actionsForNewLoanObjects = new BackOfficeActionsForNewLoanObjects();
	
	@Given("user will we come back to main dashboard")
	public void user_will_we_come_back_to_main_dashboard() {
		actionsForNewLoanObjects.loanDisbursed();
	}

	@When("Tap on the IBAN verification")
	public void tap_on_the_iban_verification() {
	  	System.out.println("IBAN Number Verification To Be Done");
	  	actionsForNewLoanObjects.ibanRequestAndVerification();
	}

	@Then("will be accepted")
	public void will_be_accepted() {
	  	System.out.println("IBAN Number Verification Is Done");
	}

	@Given("credit team should give credit approval")
	public void credit_team_should_give_credit_approval() {
	  	System.out.println("After IBAN Number Verification Is Done, Credit Team Should give the credit approval");
	}

	@When("get the payouts that are to be given credit approval")
	public void get_the_payouts_that_are_to_be_given_credit_approval() {
		actionsForNewLoanObjects.creditRequestAndApproval();
	}

	@Then("update payout status for given payouts")
	public void update_payout_status_for_given_payouts() {
	  	System.out.println("Credit Approval Is Done");
	}
	
	@Then("after few minutes run a job to get the loan amount into wallet")
	public void after_few_minutes_run_a_job_to_get_the_loan_amount_into_wallet() {
	   
	}



}
