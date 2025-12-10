Feature: Admin Login

  Scenario: Admin can login to OpenCart admin
    Given  Admin opens login page & press on login to login
    When Admin enters valid email & password
    And Admin submits login
    Then Admin sees dashboard
