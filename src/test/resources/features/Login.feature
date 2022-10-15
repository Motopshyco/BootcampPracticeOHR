Feature: Login
  Scenario: : The user can login into the page
    Given the user navigates to the page
    When the user submit the username and password
    Then the user should be logged into the page

  Scenario: The user can log out of the page
    Given the user navigates to the page
    And the user submit the username and password
    When the user log out of the page
    Then the user should be in the login page