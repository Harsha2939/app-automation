Feature: Apply new loan

	@newLoan
  Scenario: User fill out the financial eligibility form
    Given Validate that user is on the dashboard and Click on the Get a New Loan button
    When User should fill the initial eligibility if it get displayed
    Then provide the requested loan amount details <loanAmount>
    Then choose one of the reason of getting fincance 
    When provide the income details <Amount> ,accomidation details
    Then click on the submit button
    
    Examples:
    |loanAmount |	Amount	|
		|	18000	 		|	12000		|