Feature: Shopping Cart

Scenario: Add Product and Checkout
Given I am able to navigate onto amazon home page
When I search for "iphone 13"
And I select "Apple iPhone 13 (128GB) - Starlight"
And I click on buy now
And I update username as "test@gmail.com"
And I update password as "Welcome@123"
And I choose the delivery location
And I process the payment as "cash on delivery"
Then I should get a invoice summary generated
And I should receive an email about the order being placed
And I should navigate onto the orders page