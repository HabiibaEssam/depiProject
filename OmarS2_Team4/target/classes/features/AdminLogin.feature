Feature: Admin Login

  Scenario: Admin can login to OpenCart admin
    Given admin opens admin login page
    When admin provides valid credentials
    And admin submits login
    Then admin sees the dashboard
