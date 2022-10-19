Feature: Login
  @Smoke @Functional
  Scenario: : The user can login into the page
    Given the user navigates to the page
    When the user submit the username and password
    Then the user should be logged into the page

  @Functional
  Scenario: The user can log out of the page
    Given the user navigates to the page
    And the user submit the username and password
    When the user log out of the page
    Then the user should be in the login page

  @Negative
  Scenario: the user can't login into the page without a password
    Given the user navigates to the page
    When the user submit the username
    Then the user should receive a required message

  @Negative
  Scenario: the user can't login into the page without a username
    Given the user navigates to the page
    When the user submit the password
    Then the user should receive a required message

  @Negative
  Scenario: the user can't login into the page with invalid credential
    Given the user navigates to the page
    When the user submit invalid credentials
    Then the user should receive a invalid credentials message