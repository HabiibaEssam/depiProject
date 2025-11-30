Feature: Login Functionality

  Scenario: Verify that user is logged in when enter valid credentials
    Given user in home page
    When user click on form authentication form
    Then user redirect to login page
    When user enter valid username and password
    And  click on login button
    Then user redirect to secure page