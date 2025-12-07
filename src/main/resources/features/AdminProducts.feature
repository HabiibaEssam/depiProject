Feature: Admin Product Management

  Scenario: Admin adds a new product
    Given admin is logged in
    When admin navigates to products page
    And admin adds a new product
    Then the product list should contain products

  Scenario: Admin edits the first product
    Given admin is logged in
    When admin navigates to products page
    And admin edits the first product
    Then the product should be updated

  Scenario: Admin deletes the first product
    Given admin is logged in
    When admin navigates to products page
    And admin deletes the first product
    Then the product should be removed from the list
