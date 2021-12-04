Feature: Adding item to trolley

  Background: User has already logged in
    Given the user is on login page
#    When the user navigates to "Account" page
#    And fills fields with valid credentials
    Then the user should land on homepage
@wip
  Scenario: User should be able to add product to trolley
    When the user navigates to "Technology" and "Gaming Laptops"
    And the user sorts product by "Price: Low - High"
    And the user chooses the first product on the page
    Then the product should be seen on trolley page

  Scenario: User shouldn't be able to add out of stock product to trolley
    When the user searches for "Opti Vinyl Barbell and Dumbbell Set - 30kg"
    And the user chooses first product on the list
    Then "Add to trolley" button shouldn't appear on the page

  Scenario: User should be able to remove product from trolley
    When the user navigates to "Technology" and "Gaming Laptops"
    And the user sorts product by "Price: Low - High"
    And the user chooses the first product on the page
    When the user navigates to "Trolley" page
    And removes the product
    Then trolley should be empty
