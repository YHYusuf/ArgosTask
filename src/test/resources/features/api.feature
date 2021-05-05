Feature: Adding a new pet to store
@api
  Scenario: Create a pet
    Given the the user has logged in
    When the user posts a new pet
    Then status code should be 200, content type "application/json"
    And newly created pet should be under "available" pets