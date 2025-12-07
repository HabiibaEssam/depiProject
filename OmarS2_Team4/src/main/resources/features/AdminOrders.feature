Feature: Admin Orders

  Scenario: Admin changes status of an order
    Given admin is logged in
    When admin navigates to orders page
    And admin changes first order status to "Shipped"
    Then the order status should be updated
