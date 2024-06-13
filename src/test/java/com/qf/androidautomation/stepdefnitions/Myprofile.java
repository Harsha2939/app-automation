package com.qf.androidautomation.stepdefnitions;

import com.qf.androidautomation.pageobjects.LanguageChange;
//import com.qf.androidautomation.pageobjects.LogInObjects;
import com.qf.androidautomation.pageobjects.LogoutObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Myprofile {

	LanguageChange langChange = new LanguageChange();

	LogoutObjects logout = new LogoutObjects();

	@Given("Click on the myprofile icon on the dashboard page")
	public void click_on_the_myprofile_icon_on_the_dashboard_page() throws InterruptedException {
		langChange.profileMenu();

	}

	@Then("Verify that user is able to see the my profile page menu options")
	public void verify_that_user_is_able_to_see_the_my_profile_page_menu_options() {
		langChange.menuOptions();
	}

	@When("click on the Language change option")
	public void click_on_the_language_change_option() throws InterruptedException {
		langChange.languageChange();
		langChange.langChooseOption();
	}

	@Then("Language changed successfully")
	public void language_changed_successfully() {
		langChange.isHeadingNameCorrect();
	}

	@Then("convert to English")
	public void language_changed() throws InterruptedException {
		langChange.languageConvert();
	}

	@When("click on the Logout option")
	public void click_on_the_logout_option() throws InterruptedException {
		logout.logout();
	}

	@Then("Verify that user see the logout options")
	public void verify_that_user_see_the_logout_options() throws InterruptedException {
		logout.logoutOptions();
		logout.isHeadingNameVerification();
	}

}
