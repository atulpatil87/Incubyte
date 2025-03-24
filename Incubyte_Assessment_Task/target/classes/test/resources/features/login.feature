Feature: User Login

  Scenario: Successful login
    Given User is on the Login page
    When User enters login email "johndoe123@example.com" and password "Test@1234"
    And User clicks on Sign In
    Then User should be logged in successfully

  Scenario: Login with incorrect password
    Given User is on the Login page
    When User enters login email "johndoe123@example.com" and password "WrongPass@123"
    And User clicks on Sign In
    Then An error message should be displayed for login failure

  Scenario: Login with unregistered email
    Given User is on the Login page
    When User enters login email "unregistered@example.com" and password "Test@1234"
    And User clicks on Sign In
    Then An error message should be displayed for login failure
