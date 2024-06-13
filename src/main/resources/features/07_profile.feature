Feature: My profile scenarios

	@languagechange
  Scenario: User tries changing the language
    Given Click on the myprofile icon on the dashboard page
    Then Verify that user is able to see the my profile page menu options
    When click on the Language change option
    Then Language changed successfully 
    Then convert to English
    

	@logout
	 Scenario: User will logout from app
    When click on the Logout option
    Then Verify that user see the logout options
    
