Feature: User Login
  In order to get user page, As user i want to login with valid credentials

  Background:
    Given User navigates to Login Page

  Scenario Outline: Valid Login

    When User login with Valid Credentials <Username> and <Password>
    Then User can reach his homepage
    And User can print his Username

    Examples:
    | Username | Password |
    | "tomsmith" | "SuperSecretPassword!" |

  Scenario Outline: Invalid Login

    When User login with Invalid Credentials <Username> and <Password>
    Then Error Massage shall be displayed

    Examples:
      | Username | Password |
      | "yehiametwally" | "mypassword!" |