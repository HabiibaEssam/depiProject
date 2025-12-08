Feature: Product Details Page

  Scenario: Add product to cart
    Given I am on the Product Details Page for "iMac"
    Then I see the product details for "iMac"
    When I add "1" quantity to cart

