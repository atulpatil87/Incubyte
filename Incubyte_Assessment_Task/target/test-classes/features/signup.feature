Feature: User Signup

  Scenario: Successful account creation
    Given User is on the Signup page
    When User enters first name "John" and last name "Doe"
    And User enters email "johndoe123@example.com"
    And User enters password "Test@1234" and confirms password "Test@1234"
    And User clicks on Create an Account
    Then Account should be created successfully

  Scenario: Signup with already registered email
    Given User is on the Signup page
    When User enters first name "Jane" and last name "Doe"
    And User enters email "existinguser@example.com"
    And User enters password "Test@1234" and confirms password "Test@1234"
    And User clicks on Create an Account
    Then An error message should be displayed for signup failure

  Scenario: Signup with mismatched passwords
    Given User is on the Signup page
    When User enters first name "Alice" and last name "Smith"
    And User enters email "alice.smith@example.com"
    And User enters password "Test@1234" and confirms password "Test@5678"
    And User clicks on Create an Account
    Then An error message should be displayed for signup failure
