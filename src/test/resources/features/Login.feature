@login
Feature: OpenEMR Login
  This is a feature to validate the login functionality of OpenEMR application
  It has the following scenarios covered
  1. Successful Login and Logout
  2. Invalid username and password
  3. Register username and empty password

  #this is a comment
  @s1
  Scenario Outline: Successful Login and Logout
    Given I am able to navigate onto openEMR Login page
    When I update the username as "<id>"
    And I update the password as "<password>"
    And I click on the login button
    Then I should see the user as "<name>"

    Examples: 
      | id        | password  | name        |
      | admin     | pass      | Billy Smith |
      | physician | physician | Donna Lee   |

