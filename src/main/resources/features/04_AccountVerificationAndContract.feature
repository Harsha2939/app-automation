Feature: ComodityPurchase and contract sign

  @loanAmountAndComodityPurchase
  Scenario: If User financial eligible to recive the loan
  	Given if user entered financial details are eligible for loan 
  	Then user can able to see congratulations and click on the proceed button
    Then user can able to see loan and payment plan screen and click on the proceed button
    When user can able to see comodity purchase screen , here user should click on proceed button
    Then user able to see the comodity purchase acceptence screen
    
  @accountVerification
  Scenario: After loan amount and comodity purchase user should verify the bank account
  	Given user should need to verify the bank account
		When user should select the name of the bank
		Then after selection  of bank user can usually provide <IBAN number>
		When user should add bank certificate to confirm your ownership of the bank account
		Then check the confirm checkbox and click on confirm button
		
		Examples:
		|				IBAN number				|
		| SA6680000389608016070725|
		
	@contractSignAndConfirmOtp
	Scenario: After entering the bank account user should sign the e-contract
  	Given user click on the submit button after providing bank account details
		When user will recive confirmation call
		Then user will click on proceed for e-contract sign
		Then check the contract details and click on sign the contrat button
		When user will recive an otp and need to enter the otp
		Then user e-contract get signed and click on proceed button
