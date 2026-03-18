Feature: Signup to AutomationExercise
  In order to access homepage
  As a new user
  I want to signup

  Scenario Outline: valid signup with multiple users
    Given user is on home page
    When user navigates to signup page
    And user enters name "<name>" and email "<email>" to signup
    And user fills other information with password "<password>"
    Then account should be created successfully for "<name>"

    Examples:
      | name    | email                | password |
      | doha    | dohaA80@gmail.com    | 123456   |
      | Ismail  | Ismail80@gmail.com   | 123456   |
      | mohamed | mohamedA80@gmail.com | 123456   |