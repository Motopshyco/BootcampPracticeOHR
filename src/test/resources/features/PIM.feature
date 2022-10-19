Feature: PIM

  Background: The user login into the page
    Given the user navigates to the page
    When the user submit the username and password
    Then the user should be logged into the page
    And the user goes to the Add Employee tab
    And the user sets his information
      | firstName | middleName | lastName |
      | Santiago  | De jesus   | Raballo  |
    And the user saves the new employee

  @Smoke @Functional
  Scenario: The user creates a new employee since the add employee tab
    Then the new employee should be show in the Employee List
    And the user delete the employee

  @Functional
  Scenario: The user can delete an employee
    When the new employee should be show in the Employee List
    And the user delete the employee
    Then The employee should not appears in the Employee List

  @Functional
  Scenario: The user can edit and employee
    When the new employee should be show in the Employee List
    And the user changes the name of the employee to "Ilario" as first name and "Emilio" as second name
    Then the name of the employee should change in the Employee List
    And the user delete the employee

  @Functional
  Scenario: the user can filter employees by name
    Then the new employee should be filter by name in the Employee List
    And the user delete the employee

  @Negative
  Scenario: The user can't create two employees with the same id
    When the user goes to the Add Employee tab
    And The user tries to create another employee with the same id
    Then the user should to receive an error message
    And the user delete the employee

  @Negative
  Scenario: The user can't create an employee without name
    When the user goes to the Add Employee tab
    And the user saves the new employee
    Then the user get a required message

  @Boundary
  Scenario: the user can create an employee with specials characters for name
    And the user goes to the Add Employee tab
    And the user sets his information
      | firstName | middleName   | lastName |
      | $pec)@l   | */characters | Test     |
    And the user saves the new employee
    Then the new employee should be show in the Employee List
    And the user delete the employee


