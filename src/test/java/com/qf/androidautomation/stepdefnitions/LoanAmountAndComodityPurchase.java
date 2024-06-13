package com.qf.androidautomation.stepdefnitions;

import com.qf.androidautomation.pageobjects.LoanAmountAndComodityPurchaseObjects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoanAmountAndComodityPurchase {
	
	LoanAmountAndComodityPurchaseObjects loanComodityPurchaseObjects = new LoanAmountAndComodityPurchaseObjects();

	@Given("if user entered financial details are eligible for loan")
	public void if_user_entered_financial_details_are_eligible_for_loan() {
		loanComodityPurchaseObjects.eligibleOrNot();
	}

	@Then("user can able to see congratulations and click on the proceed button")
	public void user_can_able_to_see_congratulations_and_click_on_the_proceed_button() {
		loanComodityPurchaseObjects.clickProceed();
	}

	@Then("user can able to see loan and payment plan screen and click on the proceed button")
	public void user_can_able_to_see_loan_and_payment_plan_screen_and_click_on_the_proceed_button() {
		loanComodityPurchaseObjects.loanAndPaymentPlan();
	}

	@When("user can able to see comodity purchase screen , here user should click on proceed button")
	public void user_can_able_to_see_comodity_purchase_screen_here_user_should_click_on_proceed_button() {
		loanComodityPurchaseObjects.commodityPurchaseOffer();
	}

	@Then("user able to see the comodity purchase acceptence screen")
	public void user_able_to_see_the_comodity_purchase_acceptence_screen() {
		loanComodityPurchaseObjects.commodityPurchaseAccept();
	}
}
