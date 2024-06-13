     #
#	Feature: validating incorrect NationalID
#
    #@forgotpassword
#		 Scenario: Check error validation after entering wrong natioanl ID in confirm page
     #Given User enters Id <nationalID> and clicks the signin button
     #When user should click on forgot password
     #When User enter wrong <nationalID2> and <invalidmobileNo> in confirm page
     #When validate error message, reenter correct <nationalID>
     #When validate error message reenter correct <mobileNo>
     #When User  should give OTP on Enter verification screen <nationalID>
     #Then User will verify Resetpassword validations for <nationalID>    
#
#
    #Examples: 
      #| nationalID | mobileNo  | nationalID2 | invalidmobileNo |
      #| 1925629667 | 505552745 | 1645665636  |     543966329   |