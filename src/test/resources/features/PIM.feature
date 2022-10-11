Feature: PIM
  Background: The user login into the page
    Given the user navigates to the page
    When the user submit the username and password
    Then the user should be logged into the page

  Scenario: The user creates a new employee
    Given the user goes to the Add Employee tab
    When the user sets "Santiago" as a first name
    And the user sets "Andrei" as a middle name
    And the user sets "Raballo" as a last name
    And the user saves the new employee
    Then the new employee should be show in the Employee List
