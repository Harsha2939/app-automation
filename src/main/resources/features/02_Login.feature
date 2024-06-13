Feature: Click on the New loan button on Dashboard
#@userid
 #Scenario: User login with invalid Id credentials
    #Given User enters Id <NationalId> and clicks the signin button
    #Then NationalId filed <NationalId> thorws a validation message
     #Examples:
#		|	NationalId |
#		|	3114209963 |
#		|	2109209963 |	
#		|	410abc9356 |
#		|	1952152427 |
#		
		
@password	
 Scenario: User login with invalid  password credentials
    Given User is on the login page enters Id NationalId
    When User clicks on the signin button 
    #Then Observe and enter the password <password> 
    Given Observe and re-enter the password
		Then User is on the Otp page and enter the OTP recived
    Examples:
		|	NationalId|	password	|	password2 |	
		|	1698884622|	Aa123456	|	Aa930860@	|	