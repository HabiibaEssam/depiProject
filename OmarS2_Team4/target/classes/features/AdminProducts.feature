Feature: Admin Product Management

  Scenario: Admin adds a new product
    Given Admin is logged in & navigates to products page
    When admin adds a new product
    Then the product list should contain products


  Scenario: Admin deletes the first product
    Given Admin is logged in & goes to products page
    When admin deletes the first product
    Then the product should be removed from the list
