Feature: PIM
  Background: The user login into the page
    Given the user navigates to the page
    When the user submit the username and password
    Then the user should be logged into the page

  Scenario: The user creates a new employee
    Given the user goes to the Add Employee tab
    When the user sets "Santiago" as a first name
    And the user sets "De Jesus" as a middle name
    And the user sets "Raballo" as a last name
    And the user saves the new employee
    Then the new employee should be show in the Employee List
    And the user delete the employee

  Scenario: The user can delete an employee
    Given the user goes to the Add Employee tab
    When the user sets "Santiago" as a first name
    And the user sets "De Jesus" as a middle name
    And the user sets "Raballo" as a last name
    And the user saves the new employee
    And the new employee should be show in the Employee List
    And the user delete the employee
    Then The employee should not appears in the Employee List
