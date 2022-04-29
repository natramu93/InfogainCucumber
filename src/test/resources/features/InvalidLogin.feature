@invalid @login
Feature: Invalid Login of OpenEMR

  Background: 
    Given I am able to navigate onto openEMR Login page

	@s1
  Scenario: Invalid username and password
    When I update the username as "admin"
    And I update the password as "password"
    And I click on the login button
    Then I should get the error message as "Invalid username or password"

	@s2
  Scenario: Register username and empty password
    When I update the username as "admin"
    And I update the password as ""
    And I click on the login button
    Then I should get the error message as "Invalid username or password"
