@smoke
Feature: User should be able to login the Cydeo application


  @validLogin
  Scenario: User should be able to login the application with valid credentials
    Given User is on the login page
    When User enters the valid username
    And User enters the valid password
    And User clicks the Continue button
    Then Verify the user is on the dashboard page


  @cydeo @invalidLogin
  Scenario: User should not be able to login the application with invalid credentials
    Given User is on the login page
    When User enters the invalid username as "invalid@cydeo.com"
    And User enters the invalid password as "invalidPassword"
    And User clicks the Continue button
    Then Verify the user is on the login page

