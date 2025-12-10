Feature: Admin Orders

  Scenario: Admin changes status of an order
    Given Admin logs in successfully
    And Admin opens the dashboard page
    When Admin navigates to orders page
    And Admin changes first order status to "Shipped"
    Then the order status should be updated
