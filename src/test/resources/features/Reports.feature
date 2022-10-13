Feature: Reports
  Background: The user login into the page
    Given the user navigates to the page
    When the user submit the username and password
    Then the user should be logged into the page

  @Functional
  Scenario: The user can create a report
    Given the user goes to the reports tab
    When the user creates a report with the name "test report"
    Then the new report should be show in the report list


