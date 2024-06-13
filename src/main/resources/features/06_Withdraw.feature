Feature: Withdraw loam amount from wallet to customer bank account

  @withdrawal
  Scenario: To withdrawal loan amount
    Given after completion of loan process, to withdram amount
    When customer can able to see the loan amount on the dashboard
    Then click on the transactions on the dashboard
    When customer can able to see the current balance 
    Then enter otp for confrimation
    When withdraw request is being processed
    Then to withdraw loan amount customer need financial approval
    When after financial approval 
    Then customer loan amount get transferd into bank account
