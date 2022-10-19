Feature: My Info
  Background: The user login into the page
    Given the user navigates to the page
    When the user submit the username and password
    Then the user should be logged into the page

  @Functional
  Scenario: The user can see his name in my info tab
    Given the user goes to the My Info Tab
    When the user reviews his name
    Then the name of the user should be in the tittle

  @Functional
  Scenario: the user can review his personal information in my info tab
    Given the user goes to the My Info Tab
    When the user reviews his personal information
    Then the personal information of  the user should appears in the tab
