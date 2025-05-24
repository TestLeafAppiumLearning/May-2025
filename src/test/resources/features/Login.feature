Feature: Login scenarios

  Scenario: Login - positive flow
    When I enter the username as "rajkumar@testleaf.com"
    And I enter the password as "Leaf@123"
    And I click the login button
    Then Verify Home page is displayed

  Scenario: Login - negative flow
    When I enter the username as "lokesh@testleaf.com"
    And I enter the password as "Leaf@123"
    And I click the login button for negative case
    But Error message is thrown in login page