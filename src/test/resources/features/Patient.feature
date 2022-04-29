Feature: Patient records

Scenario: Create Patient
Given I am able to navigate onto OpenEMR Home Page
When I update the username as "admin"
And I update the password as "pass"
And I click on the login button
And I choose the menu option "Patient"
And I click on "New/Search"
And I select the title as "Mr."
And I update the firstname as "Test"
And I update the lastname as "User"
And I update the DOB as today
And I select the gender as "Male"
And I click on Create Button
And I click on confirm create Button
Then I should see an alert message
And I should see a happy birthday message


