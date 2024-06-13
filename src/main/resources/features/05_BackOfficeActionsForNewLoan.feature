Feature: Back Office actions for new loan

  @ibanVerification
	Scenario: After contract sign IBAN number verification
  	Given user will we come back to main dashboard  
		When Tap on the IBAN verification 
		Then will be accepted 
	
	@creditApproval
	Scenario: After IBAN number verification is done
  	Given credit team should give credit approval 
		When get the payouts that are to be given credit approval 
		Then update payout status for given payouts
		Then after few minutes run a job to get the loan amount into wallet