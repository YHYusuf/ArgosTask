
Feature: Login

  Scenario: Login with valid credentials
    Given the user is on login page
    When the user navigates to "Account" page
    And fills fields with valid credentials
    Then the user should land on homepage

  Scenario Outline: Login with invalid credentials
    Given the user is on login page
    When the user navigates to "Account" page
    And enters "<username>" and "<password>"
    Then title should still be "Sign in | Argos"
    Examples:
      | username              | password   |
      | y.h.yusuf@hotmail.com | $%^        |
      | .                     | a20212021a |
      | pass                  |            |

