Feature: Sorting products

  Scenario: User should be able to sorts products
    Given the user is on login page
    When the user navigates to "Account" page
    And fills fields with valid credentials
    Then the user should land on homepage
    When the user navigates to "Appliances" and "Hobs"
    And the user sorts product by "Price: Low - High"
    Then the products should be listed accordingly