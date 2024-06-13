package com.qf.androidautomation.stepdefnitions;

import com.qf.androidautomation.utils.WithdrawaLoanAmountObjects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WithdrawLoanAmount {

	WithdrawaLoanAmountObjects loanAmountObjects = new WithdrawaLoanAmountObjects();

	@Given("after completion of loan process, to withdram amount")
	public void after_completion_of_loan_process_to_withdram_amount() {

	}

	@When("customer can able to see the loan amount on the dashboard")
	public void customer_can_able_to_see_the_loan_amount_on_the_dashboard() {
		loanAmountObjects.checkCurrentBalance();
	}

	@Then("click on the transactions on the dashboard")
	public void click_on_the_transactions_on_the_dashboard() {
		loanAmountObjects.clickTransactionTab();
	}

	@When("customer can able to see the current balance")
	public void customer_can_able_to_see_the_current_balance() {
		loanAmountObjects.withDrawProcess();
	}

	@Then("enter otp for confrimation")
	public void enter_otp_for_confrimation() {
		loanAmountObjects.enterOtp();
	}
	
	@When("withdraw request is being processed")
	public void withdraw_request_is_being_processed() {
		loanAmountObjects.loanProcessingMessage();
	}
	
	@Then("to withdraw loan amount customer need financial approval")
	public void to_withdraw_loan_amount_customer_need_financial_approval() {
		loanAmountObjects.financialPayoutsRequest();
	}

	@When("after financial approval")
	public void after_financial_approval() {
		System.out.println("Financial Approval Is Done");
	}

	@Then("customer loan amount get transferd into bank account")
	public void customer_loan_amount_get_transferd_into_bank_account() {
		loanAmountObjects.checkTransactionsHistory();
	}

}
