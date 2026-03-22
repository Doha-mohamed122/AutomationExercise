Feature: Signup to AutomationExercise
  In order to access homepage
  As a new user
  I want to signup

  Scenario Outline: valid signup with multiple users
    Given user is on home page
    When user navigates to signup page
    And user enters name "<name>" and email "<email>" to signup
    And user fills all required information
      | Field     | Value           |
      | title     | <title>         |
      | password  | <password>      |
      | day       | <dob_day>       |
      | month     | <dob_month>     |
      | year      | <dob_year>      |
      | firstName | <first_name>    |
      | lastName  | <last_name>     |
      | company   | <company>       |
      | address   | <address>       |
      | country   | <country>       |
      | state     | <state>         |
      | city      | <city>          |
      | zipcode   | <zipcode>       |
      | mobile    | <mobile>        |
    Then account should be created successfully for "<name>"

    Examples:
      | name    | email                    | title | password | dob_day | dob_month | dob_year | first_name | last_name | company  | address              | country | state | city  | zipcode | mobile      |
      | mohamed | mohamedhii0@gmail.com    | Mrs   | 123456   | 7       | November  | 2003     | Doha       | Mohamed   | personal | 10th of Ramadan city | Canada  | Cairo | Cairo | 12345   | 01000000000 |
      | Ismail  | Ismailhii0@gmail.com     | Mr    | 123456   | 15      | January   | 1995     | Ismail     | Ahmed     | tech     | Nasr City            | Canada  | Cairo | Cairo | 54321   | 01000000001 |
      | mohamed | mohamedhelooo0@gmail.com | Mr    | 123456   | 22      | March     | 1990     | Mohamed    | Ali       | finance  | Maadi                | Canada  | Cairo | Cairo | 67890   | 01000000002 |