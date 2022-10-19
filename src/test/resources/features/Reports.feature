Feature: Reports
  Background: The user login into the page
    Given the user navigates to the page
    When the user submit the username and password
    Then the user should be logged into the page

  @Functional
  Scenario: The user can create a report
    Given the user goes to the reports tab
    When the user creates a report with the name "test1"
    Then the new report should be show in the report list
    And the user goes to the reports tab
    And the user filters the reports using the name "test1"
    And the user deletes the created report

  @Functional
  Scenario: the user can filter a report by name
    Given the user goes to the reports tab
    And the user creates a report with the name "test2"
    And the user goes to the reports tab
    When the user filters the reports using the name "test2"
    Then the report should appears in the list
    And the user deletes the created report

  @Functional
  Scenario: the user can delete a report
    Given the user goes to the reports tab
    And the user creates a report with the name "test3"
    And the user goes to the reports tab
    And the user filters the reports using the name "test3"
    When the user deletes the created report
    Then the report should be deleted

  @Negative
  Scenario: the user can't create a report without name
    Given the user goes to the reports tab
    When the user tries to create a report without name
    Then the user should receive required message

  @Negative
  Scenario: the user can't create 2 reports with the same name
    Given the user goes to the reports tab
    And the user creates a report with the name "test4"
    And the user goes to the reports tab
    When the user tries to create another report with the same name
    Then the user should receive message the already exists
    And the user goes to the reports tab
    And the user filters the reports using the name "test4"
    And the user deletes the created report

  @Negative
  Scenario: the user can't create without display field
    Given the user goes to the reports tab
    When the user tries to create a project without display field
    Then the user should receive a warning message and continue in add report page
